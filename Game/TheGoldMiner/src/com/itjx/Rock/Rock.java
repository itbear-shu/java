package com.itjx.Rock;

import com.itjx.Object.Object;

import java.awt.*;

public class Rock extends Object{
    public Rock() {
        this.setX((int)(Math.random() * 1500) + 10);
        this.setY((int)(Math.random() * 760 + 400));
        this.setWidth(80);
        this.setHeight(80);
        this.setM(50);
        this.setCount(-5);
        this.setType(2);
        this.setImg(Toolkit.getDefaultToolkit().getImage("images/rock2.png"));
    }
}
