/**
 * guanyuhuhu 2016年7月2日
 */
package com.jl.platform.domain.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.common.StatusCode;
import com.jl.platform.service.model.Charge;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Sorts;

/**
 * @author zhanglu
 */
@Service
public class ChargeMongoDBStore extends MongoDBStore<Charge> {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * @param pageQuery
	 * @return Result<Pagination<Charge>>
	 */
	public Result<Pagination<Charge>> pageQuery(PageQuery pageQuery) {
		try {
			FindIterable<Document> iterable = collection.find()
					.sort(Sorts.descending("createDate"))
					.skip(pageQuery.getOffset()).limit(pageQuery.getPageSize());
			final List<Charge> list = new ArrayList<Charge>(
					pageQuery.getPageSize());
			iterable.forEach(new Block<Document>() {
				@Override
				public void apply(Document document) {
					list.add(JSON.parseObject(document.toJson(), Charge.class));
				}
			});
			return Result.pagination(list, pageQuery,
					tablePage(pageQuery.getPageSize()));
		} catch (Exception e) {
			logger.error("[mongodb][query] exception.", e);
		}
		return Result.create(StatusCode.SYSTEM_ERROR);
	}

}
