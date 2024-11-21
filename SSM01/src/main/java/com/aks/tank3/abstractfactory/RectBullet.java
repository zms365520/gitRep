package com.aks.tank3.abstractfactory;

import com.aks.tank3.*;

import java.awt.*;

//子弹
public class RectBullet extends BaseBullet {
    private static final int SPEED=10;
    private int x,y;

    public static int WIDTH= ResourceMgr.bulletD.getWidth();
    public static int HEIGHT=ResourceMgr.bulletD.getHeight();


    private Dir dir;

    public boolean living=true;//子弹 还 活着

    TankFrame tf=null;
    private Group group= Group.BAD;

    Rectangle rect=new Rectangle() ;



    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public RectBullet(){ }
    public RectBullet(int x, int y, Dir dir, Group group, TankFrame tf){
        this.x=x;
        this.y=y;
        this.dir=dir;
        this.group=group;
        this.tf=tf;


        rect.x=this.x;
        rect.y=this.y;
        rect.width=WIDTH;
        rect.height=HEIGHT;

        tf.bullets.add(this);
    }
    public void paint(Graphics g){
        if(!living){
            tf.bullets.remove(this);
        }

        //新的子弹 start
        Color c=g.getColor();
        g.setColor(Color.yellow);
        g.fillRect(x,y,20,20);
        g.setColor(c);
        //新的子弹 end

        move();

    }


    private void move() {
        switch (dir){
            case LEFT:
                x-=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
        }

        //更新rect
        rect.x=this.x;
        rect.y=this.y;

        if(x<0 || y<0 || x> TankFrame.GAME_WIDTH || y> TankFrame.GAME_HEIGHT) living=false;
    }

    //子弹和坦克相撞（判断两个方块是否相交）
    public void collideWith(Tank tank) {
        if(this.group==tank.getGroup())return;

        if(rect.intersects(tank.rect)){
            tank.die();//坦克消失
            this.die();//子弹消失


            //tf.explodes.add(new Explodes(x,y,tf));//在爆炸的list集合中添加一个爆炸效果

            int eX=tank.getX()+ Tank.WIDTH/2- Explode.WIDTH/2;
            int eY=tank.getY()+ Tank.HEIGHT/2- Explode.HEIGHT/2;
            //tf.explodes.add(new Explode(eX,eY,tf));
            tf.explodes.add(tf.gf.createExplode(eX,eY,tf));
        }
    }

    private void die() {
        this.living=false;
    }
}
