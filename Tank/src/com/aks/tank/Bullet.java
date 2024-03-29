package com.aks.tank;

import java.awt.*;

/**
 * @Auther: zms
 * @Date: 2024/3/29 - 03 - 29 - 10:45
 * 子弹类
 */
public class Bullet {
    //子弹的速度
    private static final int SPEED = 1;

    //子弹的大小
    private static int WIDTH = 5, HEIGHT = 5;

    //子弹的位置
    private int x, y;

    //子弹的方向
    private Dir dir;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
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
    }
}