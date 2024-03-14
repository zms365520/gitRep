package com.aks.service;

import com.aks.pojo.Player;
import com.aks.pojo.User;

import java.util.List;

/**
 * @Auther: zms
 * @Date: 2024/2/26 - 02 - 26 - 9:27
 * @Description: com.aks.service
 * @version: 1.0
 */
public interface PlayerService {
    void addPlayer(Player player);
    List<Player> getAllPlayer();
}
