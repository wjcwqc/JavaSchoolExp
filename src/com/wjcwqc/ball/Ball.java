package com.wjcwqc.ball;

import javax.swing.*;

public class Ball {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Ballpanel panel = new Ballpanel();
        frame.add(panel);
        Thread t = new Thread(panel);
        t.start();

        frame.setSize(800, 600);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
