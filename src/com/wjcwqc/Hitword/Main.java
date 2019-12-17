/*
 * Copyright (c) 2019. wjcwqc.Allright reserved.
 * Author:wjcwqc
 * Package name:com.wjcwqc.Hitword
 */

package com.wjcwqc.Hitword;

import javax.swing.*;
import java.awt.event.KeyListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Wordpanel panel = new Wordpanel();
        frame.add(panel);
        Thread t = new Thread(panel);
        t.start();
        panel.addKeyListener(panel);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
