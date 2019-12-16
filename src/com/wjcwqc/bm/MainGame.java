package com.wjcwqc.bm;

import javax.swing.*;

public class MainGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        //画布初始化
        MainPanel panel = new MainPanel();
        frame.add(panel);
        //线程初始化
        Thread t=new Thread(panel);
        t.start();
        //窗口初始化
        frame.setTitle("ff");
        frame.setUndecorated(true);
        frame.setSize(925,700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
