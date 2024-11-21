package com.aks.tank3.abstractfactory;

import com.aks.tank3.TankFrame;
import com.aks.tank3.Audio;
import com.aks.tank3.ResourceMgr;

import java.awt.*;

public class CircleExplode extends BaseExplode {


    public static int WIDTH= ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT=ResourceMgr.explodes[0].getHeight();

    private int x,y;
    TankFrame tf=null;

    private int step=0;//数组的第一张图片



    public CircleExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;


        new Audio("./audio/explode.wav").run();

    }
    @Override
    public void paint(Graphics g){
        //g.drawImage(ResourceMgr2.explodes[step++],x,y,null);
        Color c=g.getColor();
        g.setColor(Color.blue);
        g.fillOval(x,y,10*step,10*step);

        step++;

        if(step>=10){
            tf.explodes.remove(this);
        }

        g.setColor(c);
    }
}
