package com.example.demo;/**
 * yjli
 * 2019/3/29 16:23
 */

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yjli
 * @description
 * @date 2019/3/29
 */
@Component
public class UserDaoImpl implements UserDao{

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void saveDemo(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public void removeDemo(Long id) {
        mongoTemplate.remove(id);
    }

    @Override
    public void updateDemo(User user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));

        Update update = new Update();
        update.set("name", user.getName());
        update.set("password", user.getPassword());
        update.set("role", user.getRole());
        update.set("level", user.getLevel());

        mongoTemplate.updateFirst(query, update, User.class);
    }

    @Override
    public User findDemoById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }

    @Override
    public User findDemoByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> list = mongoTemplate.findAll(User.class);
        return list;
    }
}
