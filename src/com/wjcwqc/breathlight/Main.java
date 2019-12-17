package com.wjcwqc.breathlight;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        LightPanel panel = new LightPanel();
        frame.add(panel);
        Thread t = new Thread(panel);
        t.start();
        frame.setUndecorated(true);
        frame.setTitle("I'm a breath light!");
        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
