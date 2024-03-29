package com.aks.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther: zms
 * @Date: 2024/3/28 - 03 - 28 - 23:30
 * @Description: com.aks.tank
 * @version: 1.0
 */
public class TankFrame extends Frame {
    int x=200,y=200;
    public TankFrame(){

        setSize(800,600);
        setResizable(false);//改变窗口大小 false
        setTitle("tank war");
        setVisible(true);

        this.addKeyListener(new MyKeyListener());

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
        g.fillRect(x,y,50,50);
        x+=10;
        //y+=10;
    }

    //键盘监听的处理类
    class MyKeyListener extends KeyAdapter{
        //键盘按下，会触发该方法
        @Override
        public void keyPressed(KeyEvent e) {
            //super.keyPressed(e);
            //System.out.println("an xia");
            //x+=20;
            //repaint();
        }

        //键盘被抬起，会触发该方法
        @Override
        public void keyReleased(KeyEvent e) {
            //super.keyReleased(e);
            System.out.println("tai qi");
        }
    }
}
