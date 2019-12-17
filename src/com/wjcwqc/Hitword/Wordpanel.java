/*
 * Copyright (c) 2019. wjcwqc.Allright reserved.
 * Author:wjcwqc
 * Package name:com.wjcwqc.Hitword
 */

package com.wjcwqc.Hitword;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.lang.Math.random;

public class Wordpanel extends JPanel implements Runnable, KeyListener {
    int[] x = new int[10];
    int[] y = new int[10];
    char[] c = new char[10];
    Color[] color = new Color[10];
    int s = 0;
    long step = 5;

    public Wordpanel() {
        for (int i = 0; i < 10; i++) {
            x[i] = (int) (random() * 800);
            y[i] = (int) (random() * 600);
            c[i] = (char) (random() * 26 + 65);
            color[i] = getcolor();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font font = new Font("微软雅黑", Font.BOLD, 30);
        g.setFont(font);
        g.drawString("Scores:" + s, 100, 100);
        for (int i = 0; i < 10; i++) {
            g.setColor(color[i]);
            g.drawString("" + c[i], x[i], y[i]);
        }

    }

    public Color getcolor() {
        int R = (int) (random() * 255);
        int G = (int) (random() * 255);
        int B = (int) (random() * 255);
        return new Color(R, G, B);
    }

    public void fun() {
        for (int i = 0; i < 10; i++) {
            y[i]++;
            if (y[i] > 600) {
                y[i] = 0;
            }
        }
    }

    public long level() {
        if (s > 100) step = 4;
        if (s > 200) step = 3;
        if (s > 300) step = 2;
        if (s > 400) step = 1;
        return step;
    }

    @Override
    public void run() {
        while (true) {
            fun();
            try {
                Thread.sleep(level());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getKeyChar() == c[i]) {
                s += 5;
                c[i] = (char) (random() * 26 + 65);
                x[i] = (int) (random() * 800);
                y[i] = -(int) (random() * 600);
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
