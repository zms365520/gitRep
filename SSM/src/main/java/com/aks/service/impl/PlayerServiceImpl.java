package com.aks.service.impl;

import com.aks.mapper.PlayerMapper;
import com.aks.pojo.Player;
import com.aks.service.PlayerService;
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
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerMapper playerMapper;


    @Override
    public void addPlayer(Player player) {
        playerMapper.addPlayer(player);
    }

    @Override
    public List<Player> getAllPlayer(){
        return playerMapper.getAllPlayer();
    }
}
