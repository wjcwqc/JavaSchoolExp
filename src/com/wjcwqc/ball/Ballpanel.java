package com.wjcwqc.ball;

import javax.swing.*;
import java.awt.*;

public class Ballpanel extends JPanel implements Runnable {

    int x = 30;
    int y = 30;
    int f = 0;

    @Override
    public void paint(Graphics g) {
        super.paint(g);


        for (int i = 0; i < 5; i++) {
            g.fillOval(x, y, 30, 30);
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
        int f1 = f;
        for (int i = 0; i < 5; i++) {
            f1 = f;
            if (f == 0) {
                x++;
                y++;
            } else if (f == 1) {
                x++;
                y--;
            } else if (f == 2) {
                x--;
                y--;
            } else if (f == 3) {
                x--;
                y++;
            }
            if (y >= 570) {
                if (f == 0) f = 1;
                else f = 2;
            } else if (x >= 770) {
                if (f == 1) f = 2;
                else f = 3;
            } else if (y <= 0) {
                if (f == 2) f = 3;
                else f = 0;
            } else if (x <= 0) {
                if (f == 3) f = 0;
                else f = 1;
            }


        }
    }
}
