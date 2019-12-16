package com.wjcwqc.breathlight;

import javax.swing.*;
import java.awt.*;

public class LightPanel extends JPanel implements Runnable {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);
        Font font = new Font("微软雅黑", Font.BOLD, 100);

    }

    @Override
    public void run() {
        while (true) {
            funrun();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void funrun() {

    }
}
