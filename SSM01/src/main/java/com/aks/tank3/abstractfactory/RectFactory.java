package com.aks.tank3.abstractfactory;

import com.aks.tank3.Dir;
import com.aks.tank3.Group;
import com.aks.tank3.TankFrame;

public class RectFactory extends GameFactory {
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return null;
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x,y,tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectBullet(x,y,dir,group,tf);
    }
}
