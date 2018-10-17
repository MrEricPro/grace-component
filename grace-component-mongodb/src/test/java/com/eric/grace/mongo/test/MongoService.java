package com.eric.grace.mongo.test;

import com.eric.grace.mongodb.annotation.DynamicMongoSource;
import com.eric.grace.mongodb.factory.MongoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MongoService:
 *
 * @author: MrEric
 * @since: 2018/9/7 下午4:49
 */
@Service
public class MongoService {

    @Autowired
    MongoFactory mongoFactory;

    @DynamicMongoSource(db = "admin")
    public void findAdmin() {
        System.err.println(mongoFactory.dynamicMongoDao.getMongoTemplate().findAll(Admin.class, "system.users"));
    }

    @DynamicMongoSource(key = "localMongo", db = "idea")
    public void findIdea() {
        System.err.println(mongoFactory.dynamicMongoDao.findListBean(Idea.class));
    }

    @DynamicMongoSource(db = "idea")
    public void addTest() {
        Idea i = new Idea();
        i.setName("grace");
        i.setCnName("Eric");
        mongoFactory.dynamicMongoDao.insert(i);
    }

}
