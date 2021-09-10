package com.itjx.Other;

import com.itjx.Object.Object;

import java.awt.*;

public class Other extends Object {
    public Other() {
        this.setX((int)(Math.random() * 1500) + 10);
        this.setY((int)(Math.random() * 800 + 350));
        this.setWidth(473);
        this.setHeight(426);
        this.setM(20);
        this.setCount(5);
        this.setImg(Toolkit.getDefaultToolkit().getImage("images/test.jpg"));
    }
}
