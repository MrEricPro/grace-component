package com.eric.grace.mongodb.support.core;

import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.util.List;
import org.springframework.data.mongodb.core.convert.MongoConverter;

/**
 * MongoDataSource: 组成mongo数据源的四大属性，实现类必须实现方法
 *
 * @author: MrEric
 * @since: 2018/9/7 下午4:13
 */
public interface MongoDataSource {

    List<ServerAddress> getSeeds();

    List<MongoCredential> getMongoCredentials();

    String getDefaultDatabase();

    MongoClientOptions getMongoClientOptions();

    MongoConverter getMongoConverter();


}
