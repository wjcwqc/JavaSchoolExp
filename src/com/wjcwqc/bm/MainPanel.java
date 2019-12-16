package com.wjcwqc.bm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainPanel extends JPanel implements Runnable {
    //part one
    static BufferedImage back;
    //part two
    static {
        try {
            back = ImageIO.read(MainPanel.class.getResource("resources/zhan2.jpg"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //part three
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(100,100,100,100);
    }

    public void paintBack(Graphics g){
        //参数null当前画布
        g.drawImage(back,0,0,925,700,null);
    }
    //part four
    @Override
    public void run(){
        while (true){
            try{
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            repaint();
        }
    }
}
