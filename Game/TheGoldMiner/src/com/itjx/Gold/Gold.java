package com.itjx.Gold;

import com.itjx.Object.Object;

import java.awt.*;

public class Gold extends Object {
    public Gold() {
        this.setX((int)(Math.random() * 1500) + 10);
        this.setY((int)(Math.random() * 800 + 400));
        this.setWidth(52);
        this.setHeight(52);
        this.setM(20);
        this.setCount(5);
        this.setType(1);
        this.setImg(Toolkit.getDefaultToolkit().getImage("images/gold1.gif"));
    }
}

