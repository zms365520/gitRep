package com.aks.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    int x=200,y=200;//放开的初始位置
    public TankFrame(){

        setSize(800,600);//设置大小
        setResizable(false);//窗口不可改变大小
        setTitle("Tank War another");
        setVisible(true);

        this.addKeyListener(new MyKeyListener());

        //f的window监听器，监听者windowClosing这件事，当点击❌时，系统退出
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(x,y,50,50);
        x+=10;
    }

    //键盘的监听处理类
    class MyKeyListener extends KeyAdapter{

        //键盘按键按下的时候触发该方法
        @Override
        public void keyPressed(KeyEvent e){
            x+=20;
            repaint();
        }

        //键盘按键按下之后抬起（松开）的时候触发该方法
        @Override
        public void keyReleased(KeyEvent e){

        }


    }
}
