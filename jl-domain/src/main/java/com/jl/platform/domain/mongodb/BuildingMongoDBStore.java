/**
 * guanyuhuhu 2016年6月25日
 */
package com.jl.platform.domain.mongodb;

import org.bson.BsonDocument;
import org.springframework.stereotype.Service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.service.model.Building;
import com.mongodb.client.model.CreateCollectionOptions;

/**
 * @author zhanglu
 */
@Service
public class BuildingMongoDBStore extends MongoDBStore<Building> {

	/**
	 * @param pageQuery
	 * @return Result<Pagination<Building>>
	 */
	public Result<Pagination<Building>> pageQuery(PageQuery pageQuery) {
		return pageQuery0(pageQuery);
	}

	/**
	 * @param id
	 * @return Building
	 */
	public Result<Building> queryById(String id) {
		return find(ID, id);
	}

	/**
	 * @param buildingName
	 * @return Building
	 */
	public Result<Building> findByName(String buildingName) {
		return find("name", buildingName);
	}

	@Override
	protected void createCollection() {
		CreateCollectionOptions createCollectionOptions = new CreateCollectionOptions();
		createCollectionOptions.autoIndex(true);
		createCollectionOptions.sizeInBytes(SIZE_IN_BYTES);
		this.getMongoDB().getMongoDatabase()
				.createCollection(this.getType(), createCollectionOptions);
		this.collection = this.getMongoDB().getMongoDatabase()
				.getCollection(this.getType());

		BsonDocument bson = BsonDocument
				.parse("{\"createIndexes\": \"building\",\" indexes\": [{\" key\": {\"name\": \" 1\"},\" name\": \"name_index\",\"unique\": \" true\"}]}");
		this.collection.createIndex(bson);

	}
}
