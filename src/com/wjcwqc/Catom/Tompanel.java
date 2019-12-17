/*
 * Copyright (c) 2019. wjcwqc.Allright reserved.
 * Author:wjcwqc
 * Project name:$projectname
 */

package com.wjcwqc.Catom;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tompanel extends JPanel implements Runnable {
    BufferedImage back;
    String[] eatlist = new String[40];
    int index = 0;
    static final int cnt = 40;

    public Tompanel() {
        try {
            back = ImageIO.read(Tompanel.class.getResource("Animations/Eat/eat_00.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 40; i++) {
            if (i < 10) {
                eatlist[i] = "Animations/Eat/eat_0" + i + ".jpg";
            } else {
                eatlist[i] = "Animations/Eat/eat_" + i + ".jpg";
            }
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(back, 0, 0, 320, 512, null);
    }

    @Override
    public void run() {
        while (true) {
            index++;
            if (index < cnt) {
                try {
                    back = ImageIO.read(Tompanel.class.getResource(eatlist[index]));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            } else {
                index = 0;
            }
        }
    }

//    private void fun() {
//        index++;
//
//        try {
//            back = ImageIO.read(Tompanel.class.getResource(eatlist[index]));
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//    }
}
