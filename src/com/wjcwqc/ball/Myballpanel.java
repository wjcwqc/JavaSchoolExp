package com.wjcwqc.ball;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.random;

public class Myballpanel extends JPanel implements Runnable {
    int[] x = new int[5];
    int[] y = new int[5];
    int[] f = new int[5];
    boolean d = true;
    int s = 0;

    int[] G = new int[5], R = new int[5], B = new int[5];
    boolean[] turn = new boolean[5];

    public void init() {
        for (int i = 0; i < 5; i++) {
            x[i] = (int) (random() * 800);
            y[i] = (int) (random() * 600);
            f[i] = (int) (random() * 3);
            R[i] = (int) (random() * 255);
            G[i] = (int) (random() * 255);
            B[i] = (int) (random() * 255);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (d) {
            d = false;
            init();
        }
        g.drawString("分数：" + s, 100, 100);
        for (int i = 0; i < 5; i++) {
            if (turn[i]) {
                R[i] = (int) (random() * 255);
                G[i] = (int) (random() * 255);
                B[i] = (int) (random() * 255);
            }
            g.setColor(new Color(R[i], G[i], B[i]));
            g.fillOval(x[i], y[i], 30, 30);
        }
    }

    @Override
    public void run() {
        while (true) {
            // 1.根据飞行方向修改坐标值x,y
            fun();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }

    }

    public void fun() {
        int[] f1 = new int[5];
        for (int i = 0; i < 5; i++) {
            f1[i] = f[i];
            if (f[i] == 0) {
                x[i]++;
                y[i]++;
            } else if (f[i] == 1) {
                x[i]++;
                y[i]--;
            } else if (f[i] == 2) {
                x[i]--;
                y[i]--;
            } else if (f[i] == 3) {
                x[i]--;
                y[i]++;
            }
            if (y[i] >= 570) {
                if (f[i] == 0) f[i] = 1;
                else f[i] = 2;
            } else if (x[i] >= 770) {
                if (f[i] == 1) f[i] = 2;
                else f[i] = 3;
            } else if (y[i] <= 0) {
                if (f[i] == 2) f[i] = 3;
                else f[i] = 0;
            } else if (x[i] <= 0) {
                if (f[i] == 3) f[i] = 0;
                else f[i] = 1;
            }

            turn[i] = (f1[i] != f[i]);
            if (turn[i]) {
                s += 5;
            }
        }
    }
}
