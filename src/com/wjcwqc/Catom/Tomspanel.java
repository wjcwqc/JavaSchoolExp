/*
 * Copyright (c) 2019. wjcwqc.Allright reserved.
 * Author:wjcwqc
 * Project name:$projectname
 */

package com.wjcwqc.Catom;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tomspanel extends Panel implements Runnable, MouseListener {
    BufferedImage back;
    BufferedImage eatButtom;
    BufferedImage drinkButtom;
    BufferedImage cymbalButtom;
    BufferedImage fartButtom;
    BufferedImage pieButtom;
    BufferedImage scratchButtom;
    String[] button = {"eat", "drink", "cymbal", "fart", "pie", "scratch"};
    int cnt = -1;
    String[] imageList = new String[100];
    int index = 0;

    public Tomspanel() {
        try {
            back = ImageIO.read(Tomspanel.class.getResource("Animations/Eat/eat_01.jpg"));

            eatButtom = ImageIO.read(Tomspanel.class.getResource("Buttons/eat.png"));
            drinkButtom = ImageIO.read(Tomspanel.class.getResource("Buttons/drink.png"));
            cymbalButtom = ImageIO.read(Tomspanel.class.getResource("Buttons/cymbal.png"));
            fartButtom = ImageIO.read(Tomspanel.class.getResource("Buttons/fart.png"));
            pieButtom = ImageIO.read(Tomspanel.class.getResource("Buttons/pie.png"));
            scratchButtom = ImageIO.read(Tomspanel.class.getResource("Buttons/scratch.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(back, 0, 0, 320, 512, null);
        g.drawImage(eatButtom, 30, 300, 30, 30, null);
        g.drawImage(drinkButtom, 30, 340, 30, 30, null);
        g.drawImage(pieButtom, 30, 380, 30, 30, null);
        g.drawImage(cymbalButtom, 260, 300, 30, 30, null);
        g.drawImage(fartButtom, 260, 340, 30, 30, null);
        g.drawImage(scratchButtom, 260, 380, 30, 30, null);
        //g.drawRect();
        for (int x = 30; x < 320; x += 30) {
            g.drawString(String.format("%d", x), x, 20);
        }
        for (int y = 30; y < 512; y += 30) {
            g.drawString(String.format("%d", y), 0, y);
        }
    }

    @Override
    public void run() {
        while (true) {
            index++;

            if (cnt > index) {
                try {
                    back = ImageIO.read(Tomspanel.class.getResource(imageList[index]));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else {
                index = 0;
                cnt = -1;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();

        }
    }

    private void updateImageList(String name) {
        for (int i = 0; i < cnt; i++) {
            if (i < 10) {
                imageList[i] = "Animations/" + name + '/' + name + "_0" + i + ".jpg";
            } else {
                imageList[i] = "Animations/" + name + "/" + name + "_" + i + ".jpg";
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (mx > 30 && mx < 90
                && my > 300 && my < 360) {
            cnt = 40;
            updateImageList("eat");
        }
        if (mx > 30 && mx < 90
                && my > 340 && my < 370) {
            cnt = 81;
            updateImageList("drink");
        }
        if (mx > 30 && mx < 90
                && my > 380 && my < 420) {
            cnt = 24;
            updateImageList("pie");
        }
        if (mx > 260 && mx < 300
                && my > 300 && my < 360) {
            cnt = 13;
            updateImageList("cymbal");
        }
        if (mx > 260 && mx < 300
                && my > 340 && my < 370) {
            cnt = 28;
            updateImageList("fart");
        }
        if (mx > 260 && mx < 300
                && my > 380 && my < 420) {
            cnt = 56;
            updateImageList("scratch");
        }

    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
