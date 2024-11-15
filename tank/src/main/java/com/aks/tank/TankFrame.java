package com.aks.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    public TankFrame(){

        this.setSize(800,600);//设置大小
        this.setResizable(false);//窗口不可改变大小
        this.setTitle("Tank War another");
        this.setVisible(true);

        //f的window监听器，监听者windowClosing这件事，当点击❌时，系统退出
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
