package com.aks.tank;

import java.awt.*;

/**
 * @Auther: zms
 * @Date: 2024/3/29 - 03 - 29 - 10:45
 * 子弹类
 */
public class Bullet {
    //子弹的速度
    private static final int SPEED = 5;

    //子弹的大小
    private static int WIDTH = 20, HEIGHT = 20;

    //子弹的位置
    private int x, y;

    //子弹的方向
    private Dir dir;

    //子弹是否活着（是否超出了屏幕）
    public boolean live=true;

    private TankFrame tf=null;

    public Bullet(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;
    }

    public void paint(Graphics g) {

        //子弹消亡了，从list集合中删除
        if(!live){
            tf.bullets.remove(this);
        }

        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(c);

        move();
    }

    public void move() {
        //子弹不需要是否   移动的状态    否则，就成了地雷了

        //子弹的移动状态：true
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }

        //子弹飞出屏幕，则消亡
        if(x<0 || x>TankFrame.GAME_WIDTH || y<0 || y>TankFrame.GAME_HEIGHT){
            live=false;
        }
    }
}