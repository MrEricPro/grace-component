package com.eric.grace.mongo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * MongoTest:
 *
 * @author: MrEric
 * @since: 2018/9/7 下午4:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:rabbitmq.xml"})
public class MongoTest {
    @Autowired
    MongoService mongoService;

    @Test
    public void test() throws Exception {
//        System.err.println(mongoFactory.defaultMongoDao.getMongoTemplate().getDb());
//        List<Idea> idea = mongoFactory.defaultMongoDao.findListBean(Idea.class);
//        System.err.println(idea.toString());
//        mongoService.findAdmin();
//        mongoService.findIdea();
        mongoService.addTest();
    }


}
