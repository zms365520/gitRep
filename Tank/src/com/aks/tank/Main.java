package com.aks.tank;

/**
 * @Auther: zms
 * @Date: 2024/3/28 - 03 - 28 - 23:34
 * @Description: com.aks.tank
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException{
        TankFrame tf=new TankFrame();

        //主线程每隔50毫秒对窗口进行重新绘制  repaint方法
        while(true){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
