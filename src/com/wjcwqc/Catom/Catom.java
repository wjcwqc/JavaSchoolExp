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
        Tompanel panel = new Tompanel();
        frame.add(panel);
        Thread t = new Thread(panel);
        t.start();
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(320, 512);
    }
}
