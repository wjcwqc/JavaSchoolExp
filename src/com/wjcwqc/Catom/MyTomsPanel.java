/*
 * Copyright (c) 2019. wjcwqc.Allright reserved.
 * Author:wjcwqc
 * Project name:$projectname
 */

package com.wjcwqc.Catom;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MyTomsPanel extends Panel implements Runnable, MouseListener {

    BufferedImage back;
    BufferedImage eatButton;
    BufferedImage drinkButton;
    BufferedImage cymbalButton;
    BufferedImage fartButton;
    BufferedImage pieButton;
    BufferedImage scratchButton;
    String[] imageList = new String[100];
    int index = 0;
    int count = -1;

    public MyTomsPanel() {
        try {
            back = ImageIO.read(MyTomsPanel.class.getResource("Animations/Eat/eat_00.jpg"));
            eatButton = ImageIO.read(MyTomsPanel.class.getResource("Buttons/eat.png"));
            drinkButton = ImageIO.read(MyTomsPanel.class.getResource("Buttons/drink.png"));
            cymbalButton = ImageIO.read(MyTomsPanel.class.getResource("Buttons/cymbal.png"));
            fartButton = ImageIO.read(MyTomsPanel.class.getResource("Buttons/fart.png"));
            pieButton = ImageIO.read(MyTomsPanel.class.getResource("Buttons/pie.png"));
            scratchButton = ImageIO.read(MyTomsPanel.class.getResource("Buttons/scratch.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(back, 0, 0, 320, 512, null);
        g.drawImage(eatButton, 30, 240, 60, 60, null);
        g.drawImage(drinkButton, 30, 320, 60, 60, null);
        g.drawImage(cymbalButton, 30, 400, 60, 60, null);
        g.drawImage(fartButton, 240, 240, 60, 60, null);
        g.drawImage(pieButton, 240, 320, 60, 60, null);
        g.drawImage(scratchButton, 240, 400, 60, 60, null);
//		g.setColor(Color.RED);
//		g.drawRect(100,100, 150, 150);
//
//		g.drawRect(100,280, 120, 160);
//
//		g.drawRect(100,440, 60, 50);
//		g.drawRect(160,440, 60, 50);
//		g.drawRect(210,400, 50, 60);


    }

    @Override
    public void run() {
        while (true) {

            index++;
            if (count > index) {
                try {
                    back = ImageIO.read(MyTomsPanel.class.getResource(imageList[index]));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else {
                index = 0;
                count = -1;
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (mouseX > 30 && mouseX < 30 + 60 && mouseY > 240 && mouseY < 240 + 60) {
            count = 40;
            updateImageList("eat");
        }
        if (mouseX > 30 && mouseX < 30 + 60 && mouseY > 320 && mouseY < 320 + 60) {
            count = 81;
            updateImageList("Drink");
        }
        if (mouseX > 30 && mouseX < 30 + 60 && mouseY > 400 && mouseY < 400 + 60) {
            count = 13;
            updateImageList("Cymbal");
        }
        if (mouseX > 240 && mouseX < 240 + 60 && mouseY > 240 && mouseY < 240 + 60) {
            count = 28;
            updateImageList("Fart");
        }
        if (mouseX > 240 && mouseX < 24030 + 60 && mouseY > 320 && mouseY < 320 + 60) {
            count = 24;
            updateImageList("Pie");
        }
        if (mouseX > 240 && mouseX < 240 + 60 && mouseY > 400 && mouseY < 400 + 60) {
            count = 56;
            updateImageList("Scratch");
        }

        if (mouseX > 100 && mouseX < 250 && mouseY > 100 && mouseY < 250) {
            count = 81;
            updateImageList("Knockout");
        }
        if (mouseX > 100 && mouseX < 220 && mouseY > 280 && mouseY < 440) {
            count = 34;
            updateImageList("Stomach");
        }
        if (mouseX > 100 && mouseX < 160 && mouseY > 440 && mouseY < 510) {
            count = 30;
            updateImageList("FootRight");
        }
        if (mouseX > 160 && mouseX < 220 && mouseY > 440 && mouseY < 510) {
            count = 30;
            updateImageList("FootLeft");
        }
        if (mouseX > 210 && mouseX < 260 && mouseY > 400 && mouseY < 460) {
            count = 26;
            updateImageList("Angry");
        }
    }


    private void updateImageList(String name) {
        //System.out.println("111");
        for (int i = 0; i < count; i++) {
            if (i < 10) {
                imageList[i] = "Animations/" + name + "/" + name + "_0" + i + ".jpg";
            } else {
                imageList[i] = "Animations/" + name + "/" + name + "_" + i + ".jpg";
            }
        }
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
