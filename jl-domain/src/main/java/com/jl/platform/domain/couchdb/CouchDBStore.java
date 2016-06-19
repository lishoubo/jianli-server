package com.jl.platform.domain.couchdb;

import com.alibaba.fastjson.JSON;
import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.common.StatusCode;
import com.jl.platform.domain.couchdb.frame.CouchDbClient;
import com.jl.platform.domain.couchdb.frame.JLView;
import com.jl.platform.service.model.BaseModel;
import org.apache.commons.lang3.StringUtils;
import org.lightcouch.Page;
import org.lightcouch.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * Created by lishoubo on 16/6/18.
 */
public abstract class CouchDBStore<T extends BaseModel> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private CouchDbClient couchDbClient;

    public Result<Response> save(T model) {
        try {
            polishModel(model);
            Response response = couchDbClient.save(model);
            if (response.getError() != null) {
                logger.error("[couchdb][save] response not success.{}",
                        JSON.toJSONString(response));
                return Result.create(StatusCode.SERVER_SAVE_FAIL);
            }
            return Result.create(response);
        } catch (Exception e) {
            logger.error("[couchdb][save] exception.{}",
                    JSON.toJSONString(model), e);
        }
        return Result.create(StatusCode.SYSTEM_ERROR);
    }

    private void polishModel(BaseModel model) {
        String className = this.getClass().getSimpleName();
        String type = className.substring(0, className.indexOf("CouchDBStore"));
        model.setType(StringUtils.uncapitalize(type));
    }

    protected Result<Pagination<T>> pageQuery0(String viewId,
                                               PageQuery pageQuery, Class<T> clazz, boolean includeDocs) {
        JLView view = couchDbClient.view(viewId);
        try {
            Page<T> tPage = view.includeDocs(includeDocs)
                    .skip(pageQuery.getOffset())
                    .queryPage(pageQuery.getPageSize(), null, clazz);
            return Result
                    .pagination(tPage.getResultList(), pageQuery, (int) (tPage
                            .getTotalResults() / pageQuery.getPageSize()) + 1);
        } catch (Exception e) {
            logger.error("[couchbb][query] exception.", e);
        }
        return Result.create(StatusCode.SYSTEM_ERROR);
    }

    protected List<T> listQuery0(String viewId, Class<T> clazz, int limit,
                                 Object... keys) {
        JLView view = couchDbClient.view(viewId);
        try {
            List<T> result = view.includeDocs(true).key(keys).limit(limit)
                    .query(clazz);
            return result;
        } catch (Exception e) {
            logger.error("[couchbb][query] exception.", e);
        }
        return Collections.EMPTY_LIST;
    }

    public Result<Response> update(T model) {
        try {
            polishModel(model);
            Response response = couchDbClient.update(model);
            if (response.getError() != null) {
                logger.error("[couchdb][update] response not success.{}",
                        JSON.toJSONString(response));
                return Result.create(StatusCode.SERVER_UPDATE_FAIL);
            }
            return Result.create(response);
        } catch (Exception e) {
            logger.error("[couchdb][update] exception.{}",
                    JSON.toJSONString(model), e);
        }
        return Result.create(StatusCode.SYSTEM_ERROR);
    }

    public Result<Response> delete(String id, String rev) {
        try {
            Response response = couchDbClient.remove(id, rev);
            if (response.getError() != null) {
                logger.error("[couchdb][delete] response not success.{}",
                        JSON.toJSONString(response));
                return Result.create(StatusCode.SERVER_DELETE_FAIL);
            }
            return Result.create(response);
        } catch (Exception e) {
            logger.error("[couchdb][delete] exception.{}", "id:", id, "rev:",
                    rev, e);
        }
        return Result.create(StatusCode.SYSTEM_ERROR);
    }
}
