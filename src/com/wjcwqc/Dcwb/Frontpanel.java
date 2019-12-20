/*
 * Copyright (c) 2019. wjcwqc.Allright reserved.
 * Author:wjcwqc
 * Project name:$projectname
 */

package com.wjcwqc.Dcwb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.lang.Math.random;

public class Frontpanel extends JPanel implements Runnable, KeyListener {
    private long step = 8;
    static final int bx = 150;
    static final int by = 250;
    int sy = -250;
    static final int xmax = 4;
    static final int ymax = 5;
    int right = 6;
    int[][] block = new int[xmax][ymax];
    static final char[] c = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i'};
    int s = 0;
    private int speed = 2;

    public Frontpanel() {
        for (int x = 0; x < xmax; x++) {
            for (int y = 0; y < ymax; y++) {
                block[x][y] = (int) (random() * 10);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.white);
        g.setFont(new Font("微软雅黑", Font.BOLD, 30));

        for (int x = 0; x < xmax; x++) {
            for (int y = 0; y < ymax; y++) {
                if (block[x][y] > right) {
                    g.setColor(Color.BLACK);
                    g.fillRect(bx * x, by * y + sy, bx, by);
                } else if (block[x][y] > right - 1) {
                    g.setColor(Color.yellow);
                    g.fillRect(bx * x, by * y + sy, bx, by);
                }
            }
        }
        g.setColor(Color.red);
        g.drawString("得分:" + s, 100, 100);

    }

    @Override
    public void run() {
        while (true) {
            blockmove();
            try {
                Thread.sleep(step);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    private void blockmove() {
        if (sy >= 0) {
            sy = -250;
            switchmove();
        }
        sy += speed;
        level();
    }

    private void switchmove() {
        for (int x = 0; x < xmax; x++) {
            for (int y = ymax - 1; y > 0; y--) {
                block[x][y] = block[x][y - 1];
            }
            block[x][0] = (int) (random() * 10);
        }
    }

    private void level() {
        if (s > 50) {
            speed = 3;
        }
        if (s > 100) {
            step = 7;
        }
        if (s > 150) {
            speed = 4;
        }
        if (s > 250) {
            step = 6;
        }
        if (s > 300) {
            speed = 5;
        }
        if (s > 350) {
            step = 5;
        }
        if (s > 400) {
            speed = 6;
        }
        if (s > 450) {
            step = 4;
        }
        if (s > 500) {
            speed = 7;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (int i = 0; i < 4; i++) {
            if (e.getKeyChar() == c[i]) {
                if (block[i][ymax - 1] > right) {
                    s += 5;
                    block[i][ymax - 1] = 0;
                } else if (block[i][ymax - 1] > right - 1) {
                    s += 2;
                    block[i][ymax - 1] += 1;
                } else {
                    s -= 5;
                }
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
