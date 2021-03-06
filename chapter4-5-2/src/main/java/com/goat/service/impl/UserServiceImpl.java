package com.goat.service.impl;

import com.goat.chapter001.entity.User;
import com.goat.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 64274 on 2018/8/23.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/23---19:57
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired  MongoTemplate mongoTemplate;

    @Override
    public String sayHi(String name) {
        return "OK";
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> users = mongoTemplate.findAll(User.class);
        System.out.println(users);
        return users;
    }
}
