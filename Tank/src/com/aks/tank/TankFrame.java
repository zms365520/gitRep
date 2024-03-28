package com.aks.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther: zms
 * @Date: 2024/3/28 - 03 - 28 - 23:30
 * @Description: com.aks.tank
 * @version: 1.0
 */
public class TankFrame extends Frame {
    public TankFrame(){

        setSize(800,600);
        setResizable(false);//改变窗口大小 false
        setTitle("tank war");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {//关闭窗口
                System.exit(0);//退出
            }
        });
    }

    //Frame类的方法
    //Frame窗口发生改变的时候会触发该方法
    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        g.fillRect(200,200,50,50);
    }
}
