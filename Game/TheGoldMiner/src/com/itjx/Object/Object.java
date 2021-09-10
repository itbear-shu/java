package com.itjx.Object;
/**
 * 作为金块和石块的父类
 */

import java.awt.*;

public class Object {
    //false代表不可移动，true代表可以移动
    private boolean flag = false;
    //坐标
    private int x;
    private int y;
    //宽高
    private int width;
    private int height;
    //图片
    private Image img;
    //质量
    private double m;
    //积分
    private int count;
    //类型 1为金块，2为石块
    private int type;

    //获取矩形
    public Rectangle getRec() {
        return new Rectangle(x, y, width, height);
    }
    public void paintSelf(Graphics graphics) {
        graphics.drawImage(img, x, y, null);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
