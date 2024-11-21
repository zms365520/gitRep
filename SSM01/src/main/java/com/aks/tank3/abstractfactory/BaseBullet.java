package com.aks.tank3.abstractfactory;


import com.aks.tank3.Tank;

import java.awt.*;

public abstract class BaseBullet {
    public abstract void paint(Graphics g);

    public abstract void collideWith(Tank tank);
}
