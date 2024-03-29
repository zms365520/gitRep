package com.aks.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zms
 * @Date: 2024/3/28 - 03 - 28 - 23:30
 * @Description: com.aks.tank
 * @version: 1.0
 */
public class TankFrame extends Frame {

    Tank myTank = new Tank(200, 200, Dir.DOWN,this);
    //Bullet bullet = new Bullet(300, 300, Dir.DOWN);
    List<Bullet> bullets=new ArrayList<>();
    static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;

    public TankFrame() {

        setSize(GAME_WIDTH, GAME_HEIGHT);
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

    //用双缓冲 解决画面闪烁现象 start
    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }
    //用双缓冲 解决画面闪烁现象 end

    //Frame类的方法
    //Frame窗口发生改变的时候会触发该方法
    @Override
    public void paint(Graphics g) {
        //显示子弹的数量 文字  start
        Color c=g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量："+bullets.size(),10,60);
        g.setColor(c);
        //显示子弹的数量 文字  end

        myTank.paint(g);
        //bullet.paint(g);//画子弹
        //画出  子弹集合  start
        /*
        for (Bullet bullet : bullets) { //这种遍历方式，删除元素时会报错,所以使用下面的方式进行遍历
            bullet.paint(g);
        }
        */

        for (int i=0;i<bullets.size();i++) {
            bullets.get(i).paint(g);
        }
        //画出  子弹集合  end
        /*for(Iterator<Bullet> it=bullets.iterator();it.hasNext();){
            Bullet b=it.next();
            if(!b.live) it.remove();
        }*/

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

        //按键抬起，会触发该方法
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

                //空格按键抬起，发射一颗子弹
                case KeyEvent.VK_SPACE://VK_CONTROL  ctrl按键
                    myTank.fire();
                    break;

                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            //四个方向按键都未按下，则设置移动状态为false
            if (!bL && !bR && !bU && !bD) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);
                if (bL) {
                    //dir = Dir.LEFT;
                    myTank.setDir(Dir.LEFT);
                }
                if (bR) {
                    //dir = Dir.RIGHT;
                    myTank.setDir(Dir.RIGHT);
                }
                if (bU) {
                    //dir = Dir.UP;
                    myTank.setDir(Dir.UP);
                }
                if (bD) {
                    //dir = Dir.DOWN;
                    myTank.setDir(Dir.DOWN);
                }
            }
        }

    }
}
