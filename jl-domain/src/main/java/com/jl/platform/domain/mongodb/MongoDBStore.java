package com.jl.platform.domain.mongodb;

import static com.mongodb.client.model.Sorts.ascending;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.codecs.DocumentCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import com.alibaba.fastjson.JSON;
import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.common.StatusCode;
import com.jl.platform.common.utils.IDUtils;
import com.jl.platform.service.model.BaseModel;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

/**
 * Created by lishoubo on 16/6/23.
 */
public abstract class MongoDBStore<T extends BaseModel> implements
		InitializingBean {
	protected static final int SIZE_IN_BYTES = 5 * 1024 * 1024;
	protected static final String ID = "_id";

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private MongoDB mongoDB;

	private String type;
	private Class<T> tClass;
	private DocumentCodec documentCodec;
	protected MongoCollection<Document> collection;

	@Override
	public void afterPropertiesSet() throws Exception {
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		init(pt);

		initCollection();

	}

	/**
	 * void
	 */
	private void initCollection() {
		if (needCreate()) {
			createCollection();
			return;
		}
		this.collection = this.mongoDB.getMongoDatabase().getCollection(
				this.type);
	}

	/**
	 * void
	 */
	protected void createCollection() {
		CreateCollectionOptions createCollectionOptions = new CreateCollectionOptions();
		createCollectionOptions.autoIndex(true);
		createCollectionOptions.sizeInBytes(SIZE_IN_BYTES);
		this.mongoDB.getMongoDatabase().createCollection(this.type,
				createCollectionOptions);
	}

	/**
	 * @return boolean
	 */
	private boolean needCreate() {
		boolean needCreate = true;
		MongoCursor<String> iterator = this.mongoDB.getMongoDatabase()
				.listCollectionNames().iterator();
		while (iterator.hasNext()) {
			String name = iterator.next();
			if (name.equalsIgnoreCase(this.type)) {
				needCreate = false;
				break;
			}
		}
		return needCreate;
	}

	/**
	 * @param pt
	 *            void
	 */
	private void init(ParameterizedType pt) {
		Type[] acts = pt.getActualTypeArguments();
		tClass = (Class<T>) acts[0];
		this.type = StringUtils.uncapitalize(tClass.getSimpleName());
		this.mongoDB.getMongoDatabase().getCollection(this.type);
		this.documentCodec = new DocumentCodec();
	}

	public Result<String> save(T model) {
		try {
			Document document = Document.parse(JSON.toJSONString(model),
					documentCodec);
			String id = id();
			document.put(ID, id);
			collection.insertOne(document);
			return Result.create(id);
		} catch (Exception e) {
			logger.error("[mongodb][save] exception.{}",
					JSON.toJSONString(model), e);
		}
		return Result.create(StatusCode.SYSTEM_ERROR);
	}

	protected Result<Pagination<T>> pageQuery0(PageQuery pageQuery) {
		try {
			FindIterable<Document> iterable = collection.find()
					.sort(ascending("_id")).skip(pageQuery.getOffset())
					.limit(pageQuery.getPageSize());
			final List<T> list = new ArrayList<T>(pageQuery.getPageSize());
			iterable.forEach(new Block<Document>() {
				@Override
				public void apply(Document document) {
					list.add(JSON.parseObject(document.toJson(), tClass));
				}
			});
			return Result.pagination(list, pageQuery,
					tablePage(pageQuery.getPageSize()));
		} catch (Exception e) {
			logger.error("[mongodb][query] exception.", e);
		}
		return Result.create(StatusCode.SYSTEM_ERROR);
	}

	public Result<T> find(String name, String value) {
		try {
			FindIterable<Document> documents = collection.find(Filters.eq(name,
					value));
			if (!documents.iterator().hasNext()) {
				return Result.create(StatusCode.STAFF_NOT_FOUND);
			}
			return Result.create(JSON.parseObject(documents.iterator().next()
					.toJson(), tClass));
		} catch (Exception e) {
			logger.error("[mongodb][find] exception.", e);
		}
		return Result.create(StatusCode.SYSTEM_ERROR);
	}

	public Result<T> delete(String id) {
		try {
			DeleteResult deleteResult = collection
					.deleteOne(Filters.eq(ID, id));
		} catch (Exception e) {
			logger.error("[mongodb][delete] exception.", e);
		}

		return Result.create(StatusCode.SUCCESS);
	}

	public Result<T> update(T model) {
		try {
			UpdateResult updateResult = collection.updateOne(
					Filters.eq(ID, model.getId()),
					new BsonDocument("$set", BsonDocument.parse(JSON
							.toJSONString(model))));
		} catch (Exception e) {
			logger.error("[mongodb][update] exception.", e);
		}

		return Result.create(StatusCode.SUCCESS);
	}

	public int tablePage(int pageSize) {
		return (int) ((collection.count() + pageSize - 1) / pageSize);
	}

	private String id() {
		return IDUtils.nextId();
	}

	public MongoDB getMongoDB() {
		return mongoDB;
	}

	public void setMongoDB(MongoDB mongoDB) {
		this.mongoDB = mongoDB;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MongoCollection<Document> getCollection() {
		return collection;
	}

	public void setCollection(MongoCollection<Document> collection) {
		this.collection = collection;
	}

}
