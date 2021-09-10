package com.itjx.Gold;

import java.awt.*;

public class GoldPlus extends Gold {
    public GoldPlus() {
        this.setX((int)(Math.random() * 1200) + 10);
        this.setWidth(105);
        this.setHeight(105);
        this.setM(40);
        this.setCount(10);
        this.setImg(Toolkit.getDefaultToolkit().getImage("images/gold2.gif"));
    }
}
