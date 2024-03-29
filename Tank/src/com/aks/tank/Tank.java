package com.aks.tank;

import java.awt.*;

/**
 * @Auther: zms
 * @Date: 2024/3/29 - 03 - 29 - 10:09
 * 封装Tank类，java的三大特性之一：封装
 */
public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;

    //坦克的状态  是否正在移动   false：静止状态
    private boolean moving=false;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Dir dir) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {

        g.fillRect(x, y, 50, 50);

        move();
    }
    public void move(){
        //坦克的移动状态：false，直接返回
        if(!moving){
            return;
        }
        //坦克的移动状态：true
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
