package com.aks.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 */
public class T {
    public static void main(String[] args) {
        Frame f=new Frame();//Frame：窗口类
        f.setSize(800,600);

        f.setResizable(false);//改变窗口大小 false
        f.setTitle("tank war");
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {//关闭窗口
                System.exit(0);//退出
            }
        });
    }
}
