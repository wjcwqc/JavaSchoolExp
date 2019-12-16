package com.wjcwqc.fullstar;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.*;

public class StarPanel extends JPanel implements Runnable {

    static final int max = 20000;
    static final int w = 1920;
    static final int l = 1080;
    int[] xx = new int[max];
    int[] yy = new int[max];

    public StarPanel() {
        for (int i = 0; i < max; i++) {
            xx[i] = (int) (random() * w);
            yy[i] = (int) (random() * l);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);
        Font font = new Font("微软雅黑", Font.BOLD, 28);
        g.setColor(Color.WHITE);
        for (int i = 0; i < max; i++) {
//            int x=(int)(random()*800);
//            int y=(int)(random()*600);
            int R = (int) (random() * 255);
            int G = (int) (random() * 255);
            int B = (int) (random() * 255);
            Color color = new Color(R, G, B);
            g.setColor(color);
            g.drawString("*", xx[i], yy[i]);
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}
