package com.jl.platform.domain.mongodb;

import com.alibaba.fastjson.JSON;
import com.jl.platform.common.Result;
import com.jl.platform.common.StatusCode;
import com.jl.platform.common.utils.IDUtils;
import com.jl.platform.service.model.BaseModel;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.CreateCollectionOptions;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.codecs.DocumentCodec;
import org.lightcouch.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by lishoubo on 16/6/23.
 */
public abstract class MongoDBStore<T extends BaseModel> implements InitializingBean {
    private static final int SIZE_IN_BYTES = 5 * 1024 * 1024;
    private static final String ID = "_id";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private MongoDB mongoDB;

    private String type;
    private DocumentCodec documentCodec;
    private MongoCollection<Document> collection;

    @Override
    public void afterPropertiesSet() throws Exception {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] acts = pt.getActualTypeArguments();
        this.type = StringUtils.uncapitalize(((Class<T>) acts[0]).getSimpleName());
        this.mongoDB.getMongoDatabase().getCollection(this.type);

        boolean needCreate = true;
        MongoCursor<String> iterator = this.mongoDB.getMongoDatabase().listCollectionNames().iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.equalsIgnoreCase(this.type)) {
                needCreate = false;
                break;
            }
        }
        if (needCreate) {
            CreateCollectionOptions createCollectionOptions = new CreateCollectionOptions();
            createCollectionOptions.autoIndex(true);
            createCollectionOptions.sizeInBytes(SIZE_IN_BYTES);
            this.mongoDB.getMongoDatabase().createCollection(this.type, createCollectionOptions);
        }
        this.collection = this.mongoDB.getMongoDatabase().getCollection(this.type);
        this.documentCodec = new DocumentCodec();
    }

    public Result<String> save(T model) {
        try {
            Document document = Document.parse(JSON.toJSONString(model), documentCodec);
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

    private String id() {
        return IDUtils.nextId();
    }
}
