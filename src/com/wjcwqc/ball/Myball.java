package com.wjcwqc.ball;

import javax.swing.*;

public class Myball {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Myballpanel panel = new Myballpanel();
        frame.add(panel);
        Thread t = new Thread(panel);
        t.start();

        frame.setSize(800, 600);
//        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
