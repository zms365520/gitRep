package com.aks.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf=new TankFrame();//这样也是可以直接运行的

        while(true){
            Thread.sleep(50);
            tf.repaint();
        }

    }
}
