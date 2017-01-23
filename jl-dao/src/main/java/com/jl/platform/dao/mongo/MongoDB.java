package com.jl.platform.dao.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.Resource;

/**
 * Created by lishoubo on 16/6/23.
 */
public class MongoDB implements InitializingBean {
    @Resource
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private String dbName;

    @Override
    public void afterPropertiesSet() throws Exception {
        mongoDatabase = mongoClient.getDatabase(dbName);
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public MongoDatabase getMongoDatabase() {
        return mongoDatabase;
    }
}
