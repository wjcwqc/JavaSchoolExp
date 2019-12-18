package com.wjcwqc.bm;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainPanel extends Panel implements Runnable, MouseListener, KeyListener {
    /**
     * 第一区域:变量声明初始化区域
     */
    // 1.1 背景图 静态的 永存的
    static BufferedImage back;
    int[][] floorMap = {
            {0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0},
    };

    int[][] buildMap = {
            {7, 2, 1, 2, 1, 0, 7, 7, 6, 0, 4, 1, 4, 7, 4},
            {7, 3, 6, 3, 6, 0, 6, 7, 7, 0, 1, 2, 7, 7, 7},
            {7, 7, 2, 1, 2, 0, 7, 6, 6, 0, 4, 6, 4, 6, 4},
            {6, 4, 6, 4, 6, 0, 6, 7, 7, 0, 2, 1, 2, 1, 2},
            {1, 2, 1, 2, 1, 0, 7, 7, 6, 0, 4, 6, 4, 6, 4},
            {2, 3, 2, 3, 2, 3, 6, 6, 7, 7, 1, 2, 1, 2, 1},
            {0, 0, 0, 0, 0, 0, 7, 7, 6, 0, 0, 0, 0, 0, 0},
            {1, 2, 1, 2, 1, 7, 6, 7, 7, 0, 1, 3, 1, 3, 7},
            {5, 6, 5, 6, 5, 0, 7, 6, 6, 0, 2, 1, 2, 7, 7},
            {2, 1, 2, 1, 2, 0, 6, 7, 7, 0, 6, 3, 6, 3, 7},
            {5, 7, 5, 6, 5, 0, 7, 7, 6, 0, 1, 2, 1, 2, 7},
            {7, 7, 1, 2, 1, 0, 6, 6, 7, 0, 6, 3, 7, 3, 7},
            {5, 7, 5, 1, 5, 0, 7, 7, 6, 0, 2, 7, 7, 7, 7}
    };

    static BufferedImage diban1;
    static BufferedImage diban3;
    static BufferedImage diban4;
    static BufferedImage shu;
    static BufferedImage red;
    static BufferedImage orange;
    static BufferedImage redHouse;
    static BufferedImage yellowHouse;
    static BufferedImage blueHouse;
    static BufferedImage box;
    static BufferedImage right;
    static BufferedImage left;
    static BufferedImage down;
    static BufferedImage up;


    /**第二区域:静态变量初始化区域*/
    static {
        try {
            // /
            back = ImageIO.read(MainPanel.class.getResource("resources/zhan2.jpg"));
            diban1 = ImageIO.read(MainPanel.class.getResource("resources/diban1.png"));
            diban3 = ImageIO.read(MainPanel.class.getResource("resources/diban3.png"));
            diban4 = ImageIO.read(MainPanel.class.getResource("resources/diban4.png"));
            shu = ImageIO.read(MainPanel.class.getResource("resources/shu.png"));
            red = ImageIO.read(MainPanel.class.getResource("resources/red.png"));
            orange = ImageIO.read(MainPanel.class.getResource("resources/orange.png"));
            redHouse = ImageIO.read(MainPanel.class.getResource("resources/redHouse.png"));
            yellowHouse = ImageIO.read(MainPanel.class.getResource("resources/yellowHouse.png"));
            blueHouse = ImageIO.read(MainPanel.class.getResource("resources/blueHouse.png"));
            box = ImageIO.read(MainPanel.class.getResource("resources/box.png"));
            right = ImageIO.read(MainPanel.class.getResource("resources/right.png"));
            left = ImageIO.read(MainPanel.class.getResource("resources/left.png"));
            up = ImageIO.read(MainPanel.class.getResource("resources/up.png"));
            down = ImageIO.read(MainPanel.class.getResource("resources/down.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    /**第三区域:绘制函数区域*/
    public void paint(Graphics g) {
        super.paint(g);
        // 3.1 绘制背景图
        paintBack(g);
        paintFloor(g);
        paintBuild(g);
    }

    private void paintBuild(Graphics g) {
        for (int i = 0; i < buildMap.length; i++) {
            for (int j = 0; j < buildMap[0].length; j++) {
                int type = buildMap[i][j];
                int fX = 25 + 50 * j;
                int fY = 25 + 50 * i;

                if (type == 0) {
                    g.drawImage(shu, fX, fY, 50, 50, null);
                } else if (type == 1) {
                    g.drawImage(red, fX, fY, 50, 50, null);
                } else if (type == 2) {
                    g.drawImage(orange, fX, fY, 50, 50, null);
                } else if (type == 3) {
                    g.drawImage(redHouse, fX, fY, 50, 50, null);
                } else if (type == 4) {
                    g.drawImage(yellowHouse, fX, fY, 50, 50, null);
                } else if (type == 5) {
                    g.drawImage(blueHouse, fX, fY, 50, 50, null);
                } else if (type == 6) {
                    g.drawImage(box, fX, fY, 50, 50, null);
                }
            }
        }
    }

    private void paintFloor(Graphics g) {
        for (int i = 0; i < floorMap.length; i++) {
            for (int j = 0; j < floorMap[0].length; j++) {
                int type = floorMap[i][j];
                int fX = 25 + 50 * j;
                int fY = 25 + 50 * i;

                if (type == 0) {
                    g.drawImage(diban1, fX, fY, 50, 50, null);
                } else if (type == 1) {
                    g.drawImage(diban3, fX, fY, 50, 50, null);
                } else if (type == 2) {
                    g.drawImage(diban4, fX, fY, 50, 50, null);
                }
            }
        }
    }

    // 3.1 绘制背景图
    public void paintBack(Graphics g) {
        // null默认绘制当前画布对象上
        g.drawImage(back, 0, 0, 925, 700, null);
    }


    /**
     * 第四区域:业务处理函数区域
     */
    @Override
    public void run() {
        while (true) {
            // 1.修改坐标值

            // 2.调用睡眠方法
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 3.调用重绘方法
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
        if (mouseX > 875 && mouseX < 910 && mouseY > 15 && mouseY < 15 + 24) {
            System.exit(0);
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
//    //part one
//    static BufferedImage back;
//    static BufferedImage diban1;
//    static BufferedImage diban3;
//    static BufferedImage diban2;
//    static BufferedImage block1;
//    static BufferedImage block2;
//    static BufferedImage block3;
//    static BufferedImage block4;
//    static BufferedImage block5;
//    static BufferedImage block6;
//    static BufferedImage block7;
//
//    int[][] floor = new int[13][15];
//
//    public void setFloor(int[][] floor) {
//        this.floor = floor;
//        floor = {
//                0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0,
//                0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0,
//                0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0,
//                0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0,
//                0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0,
//                0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0,
//                0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0,
//                0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0,
//                0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0,
//                0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0,
//                0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0,
//                0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0,
//                0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0,
//        };
//    }
//
//
//    int[][] block = new int[13][15];
//
//    //part two
//    static {
//        try {
//            back = ImageIO.read(MainPanel.class.getResource("resources/zhan2.jpg"));
//            diban1 = ImageIO.read(MainPanel.class.getResource("resources/diban1.jpg"));
//            diban2 = ImageIO.read(MainPanel.class.getResource("resources/diban3.jpg"));
//            diban3 = ImageIO.read(MainPanel.class.getResource("resources/diban4.jpg"));
//            block1 = ImageIO.read(MainPanel.class.getResource("resources/blueHouse.jpg"));
//            block2 = ImageIO.read(MainPanel.class.getResource("resources/box.jpg"));
//            block3 = ImageIO.read(MainPanel.class.getResource("resources/orange.jpg"));
//            block4 = ImageIO.read(MainPanel.class.getResource("resources/red.jpg"));
//            block5 = ImageIO.read(MainPanel.class.getResource("resources/redHouse.jpg"));
//            block6 = ImageIO.read(MainPanel.class.getResource("resources/yellowHouse.jpg"));
////            block2 = ImageIO.read(MainPanel.class.getResource("resources/zhan2.jpg"));
//            block7 = ImageIO.read(MainPanel.class.getResource("resources/shu.jpg"));
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    //part three
//    public void paint(Graphics g) {
//        super.paint(g);
//        paintBack(g);
//        paintFloor(g);
//        paintBlock(g);
//    }
//
//    private void paintFloor(Graphics g) {
//        for (int i = 0; i < 13; i++) {
//            for (int j = 1; j < 15; j++) {
//                if(floor[i][j]==0)
//                g.drawImage(diban1, 25 + 50 * i, 75 + 50 * i, 50, 50, null);
//                if(floor[i][j]==1)
//                    g.drawImage(diban2, 25 + 50 * i, 75 + 50 * i, 50, 50, null);
//                if(floor[i][j]==2)
//                    g.drawImage(diban3, 25 + 50 * i, 75 + 50 * i, 50, 50, null);
//            }
//        }
//    }
//
//    private void paintBlock(Graphics g) {
//        for (int i = 0; i < 13; i++) {
//            for (int j = 0; j < 15; j++) {
//                block = {
//                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//                        0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//                        0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//                        7, 0, 7, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//                }
//                block[i][j] = (int) (random() * 6);
//            }
//        }
//        for (int i = 0; i < 13; i++) {
//            for (int j = 0; j < 13; j++) {
//                g.drawImage()
//            }
//        }
//    }
//
//    public void paintBack(Graphics g) {
//        //参数null当前画布
//        g.drawImage(back, 0, 0, 925, 700, null);
//    }
//
//    //part four
//    @Override
//    public void run() {
//        while (true) {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            repaint();
//        }
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//        int mx = e.getX();
//        int my = e.getY();
//        if ()
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseClicked(MouseEvent e) {
//
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//}
