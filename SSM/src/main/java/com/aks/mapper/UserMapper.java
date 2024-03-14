package com.aks.mapper;

import com.aks.pojo.User;

import java.util.List;

/**
 * @Auther: zms
 * @Date: 2024/2/26 - 02 - 26 - 9:28
 * @Description: com.aks.mapper
 * @version: 1.0
 */
public interface UserMapper {
    User findUser(String cname, String room);

    List<User> findAllUser();
}
