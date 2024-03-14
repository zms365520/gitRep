package com.aks.controller;

import com.aks.pojo.Player;
import com.aks.service.PlayerService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * @Auther: zms
 * @Date: 2024/2/27 - 02 - 27 - 8:49
 * @Description: com.aks.controller
 * @version: 1.0
 */
@Controller
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @RequestMapping("addPlayer.do")
    public String addPlayer(Player player){
        System.out.println(player.toString());
        playerService.addPlayer(player);
        return "redirect:/index.jsp";
    }

    @RequestMapping("getAllPlayer.do")
    @ResponseBody
    public List<Player> getAllPlayer(){
        List<Player> allPlayer = playerService.getAllPlayer();
        System.out.println(allPlayer);
        return allPlayer;
    }

    @RequestMapping("photoDownload.do")
    public void photoDownload(String photoName, String photoType, HttpServletResponse response) throws IOException {
        //设置响应头
        response.setHeader("Content-Disposition","attachment;photoName="+photoName);
        response.setContentType(photoType);
        InputStream inputStream = new URL("http://192.168.1.12:8090/upload/" + photoName).openStream();
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(inputStream,outputStream);


    }
}
