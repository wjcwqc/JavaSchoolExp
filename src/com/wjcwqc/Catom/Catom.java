/*
 * Copyright (c) 2019. wjcwqc.Allright reserved.
 * Author:wjcwqc
 * Project name:$projectname
 */

package com.wjcwqc.Catom;

import javax.swing.*;

public class Catom {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Tomspanel panel = new Tomspanel();
        frame.add(panel);
        Thread t = new Thread(panel);
        t.start();
        frame.addMouseListener(panel);
        frame.setSize(320, 512);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
