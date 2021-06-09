package org.xjosiah.mylittleairplay.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xjosiah.mylittleairplay.Service.UserService;
import org.xjosiah.mylittleairplay.mybatis.entity.User;
import org.xjosiah.mylittleairplay.mybatis.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean register(String key, String uuid) {
        return userMapper.insertUser(key, uuid);
    }

    @Override
    public User login(String key) {
        return userMapper.selUserByKey(key);
    }
}
