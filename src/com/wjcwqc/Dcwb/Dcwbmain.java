/*
 * Copyright (c) 2019. wjcwqc.Allright reserved.
 * Author:wjcwqc
 * Project name:$projectname
 */

package com.wjcwqc.Dcwb;

import javax.swing.*;

public class Dcwbmain {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Frontpanel panel = new Frontpanel();
        frame.add(panel);
        Thread t = new Thread(panel);
        t.start();
        frame.addKeyListener(panel);
        frame.setTitle("别踩白块！ by wjcwqc");
        frame.setUndecorated(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(Frontpanel.bx * Frontpanel.xmax, Frontpanel.by * (Frontpanel.ymax - 1));
        frame.setFocusable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
