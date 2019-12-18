/*
 * Copyright (c) 2019. wjcwqc.Allright reserved.
 * Author:wjcwqc
 * Project name:$projectname
 */

package com.wjcwqc.bm;

import java.awt.image.BufferedImage;

public class Bao extends MainObeject {

    public BufferedImage images[];

    public Bao() {
        this.image = MainPanel.down;
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
        this.row = 13;
        this.col = 0;
        this.images = new BufferedImage[]{
                MainPanel.up,
                MainPanel.down,
                MainPanel.left,
                MainPanel.right
        };
    }
}
