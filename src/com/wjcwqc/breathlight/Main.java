package com.wjcwqc.breathlight;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        LightPanel panel = new LightPanel();
        frame.add(panel);
        Thread t = new Thread();
        t.start();
        frame.setUndecorated(true);
        frame.setTitle("I'm a breath light!");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
