/**
 * guanyuhuhu 2016年6月25日
 */
package com.jl.platform.domain.mongodb;

import static com.mongodb.client.model.Sorts.ascending;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.common.StatusCode;
import com.jl.platform.service.model.Baike;
import com.jl.platform.service.model.BaikeQueryCondition;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

/**
 * @author zhanglu
 */
@Service
public class BaikeMongoDBStore extends MongoDBStore<Baike> {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * @param pageQuery
	 * @return Result<Pagination<Baike>>
	 */
	public Result<Pagination<Baike>> pageQuery(PageQuery pageQuery) {
		return pageQuery0(pageQuery);
	}

	/**
	 * @param id
	 * @return Result
	 */
	public Result find(String id) {
		return find(ID, id);
	}

	/**
	 * @param condition
	 * @return Result
	 */
	public Result<Pagination<Baike>> queryByCondition(
			BaikeQueryCondition condition) {
		try {
			Bson filter = condition.getProcedure() == null ? Filters
					.exists("procedure") : Filters.eq("procedure",
					condition.getProcedure());

			FindIterable<Document> iterable = collection.find(filter)
					.sort(ascending(condition.getSortConditions()))
					.skip(condition.getOffset()).limit(condition.getPageSize());
			final List<Baike> list = new ArrayList<Baike>(
					condition.getPageSize());
			iterable.forEach(new Block<Document>() {
				@Override
				public void apply(Document document) {
					list.add(JSON.parseObject(document.toJson(), Baike.class));
				}
			});
			return Result.pagination(list, condition,
					tablePage(condition.getPageSize()));
		} catch (Exception e) {
			logger.error("[mongodb][Baike query by Condition] exception.", e);
		}
		return Result.create(StatusCode.SYSTEM_ERROR);
	}

}
