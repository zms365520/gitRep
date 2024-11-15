package com.aks.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    public TankFrame(){

        setSize(800,600);//设置大小
        setResizable(false);//窗口不可改变大小
        setTitle("Tank War another");
        setVisible(true);

        //f的window监听器，监听者windowClosing这件事，当点击❌时，系统退出
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
