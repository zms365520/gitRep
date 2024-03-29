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
    int x = 200, y = 200;
    Dir dir = Dir.DOWN;
    private static final int SPEED = 10;

    public TankFrame() {

        setSize(800, 600);
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
        g.fillRect(x, y, 50, 50);
        //x+=10;
        //y+=10;

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

    //键盘监听的处理类
    class MyKeyListener extends KeyAdapter {

        //设置四个方向是否被按下  false表示未按下
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        //键盘按下，会触发该方法
        @Override
        public void keyPressed(KeyEvent e) {
            //super.keyPressed(e);
            //System.out.println("an xia");
            //x+=20;
            //repaint();

            int key = e.getKeyCode();
            switch (key) {
                //左键被按下
                case KeyEvent.VK_LEFT:
                    //x -= 10;
                    bL = true;
                    break;
                //上键被按下
                case KeyEvent.VK_UP:
                    //y -= 10;
                    bU = true;
                    break;
                //右键被按下
                case KeyEvent.VK_RIGHT:
                    //x += 10;
                    bR = true;
                    break;
                //下键被按下
                case KeyEvent.VK_DOWN:
                    //y += 10;
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        //键盘被抬起，会触发该方法
        @Override
        public void keyReleased(KeyEvent e) {
            //super.keyReleased(e);
            //System.out.println("tai qi");

            //按键抬起，恢复原始状态 false：未按下
            int key = e.getKeyCode();
            switch (key) {
                //左键被按下
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                //上键被按下
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                //右键被按下
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                //下键被按下
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (bL) {
                dir = Dir.LEFT;
            }
            if (bR) {
                dir = Dir.RIGHT;
            }
            if (bU) {
                dir = Dir.UP;
            }
            if (bD) {
                dir = Dir.DOWN;
            }
        }

    }
}
