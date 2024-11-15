package com.aks.tank;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf=new TankFrame();//这样也是可以直接运行的

        while(true){
            Thread.sleep(50);
            tf.repaint();
        }

    }
}
