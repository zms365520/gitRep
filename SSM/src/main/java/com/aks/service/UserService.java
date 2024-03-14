package com.aks.service;

import com.aks.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: zms
 * @Date: 2024/2/26 - 02 - 26 - 9:27
 * @Description: com.aks.service
 * @version: 1.0
 */
public interface UserService {
    User findUser(String cname,String room);
    List<User> findAllUser();
}
