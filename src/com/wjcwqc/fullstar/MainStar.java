package com.wjcwqc.fullstar;

import javax.swing.*;

public class MainStar {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        //画布初始化
        StarPanel panel = new StarPanel();
        frame.add(panel);
        //线程初始化
        Thread t = new Thread(panel);
        t.start();
        //窗口初始化
        frame.setTitle("Stars");
        frame.setUndecorated(true);
        frame.setSize(StarPanel.w, StarPanel.l);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
