package com.wjcwqc.breathlight;

import javax.swing.*;
import java.awt.*;

public class LightPanel extends JPanel implements Runnable {

    int R = 255;
    int cnt = 10;
    int f = 0;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);
        Font font = new Font("微软雅黑", Font.BOLD, 30);
        Color color = new Color(R, R, R);
        g.setColor(color);
        g.drawString("wjcwqc", 970, 540);
        //g.drawString(" ");
    }

    @Override
    public void run() {
        while (true) {

            try {

                Thread.sleep(funrun());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private int funrun() {
        if (f == 0) R--;
        else R++;
        if (cnt > 12) {
            cnt = 10;
            f = 1 - f;
        }
        return cnt;
    }
}
