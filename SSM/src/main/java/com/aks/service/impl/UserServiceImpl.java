package com.aks.service.impl;

import com.aks.mapper.UserMapper;
import com.aks.pojo.User;
import com.aks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: zms
 * @Date: 2024/2/26 - 02 - 26 - 9:27
 * @Description: com.aks.service.impl
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUser(String cname, String room) {
        return userMapper.findUser(cname,room);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }
}
