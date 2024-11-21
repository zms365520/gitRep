package com.aks.tank3.abstractfactory;

import com.aks.tank3.Group;
import com.aks.tank3.TankFrame;
import com.aks.tank3.Dir;

/**
 * @Auther: zms
 * @Date: 2024/11/14 - 11 - 14 - 22:03
 * @Description: com.aks.Tank2.abstractfactory
 * @version: 1.0
 */
public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf);
    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);
    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf);
}
