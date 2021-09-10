package com.itjx.Line;
/**
 * 线类：设置线及线的移动
 */

import com.itjx.Bg.Bg;
import com.itjx.GameWin.GameWin;
import com.itjx.Object.Object;

import java.awt.*;

public class Line {
    //线的起点坐标
    int x = 870;
    int y = 290;
    //线的终点坐标
    int endx = 1000;
    int endy = 1000;
    //线长
    double length = 100;
    //线长最小值
    double MIN_length = 50;
    //线长最大值
    double MAX_length = 1100;
    double n = 0.1;
    //方向参数
    int dir = 1;
    //状态：0:摇摆 1:抓取 2:回收 3:抓取返回
    int state;
    //钩爪图片
    Image hook = Toolkit.getDefaultToolkit().getImage("images/hook.png");

    //抓取判定
    GameWin frame;

    public Line(GameWin frame) {
        this.frame = frame;
    }

    //判断：x 属于 [x, x + width]，y 属于 [y, y + height]
    public void logic() {
        for (Object object : this.frame.objectList)
            if (endx > object.getX() && endx < (object.getX() + object.getWidth()) &&
                    endy > object.getY() && endy < (object.getY() + object.getHeight()))
            {
                this.state = 3;//抓取返回
                object.setFlag(true);
            }
    }

    //绘制方法
    public void paintLine(Graphics graphics) {
        endx = (int) (x + (length * Math.cos(n * Math.PI)));
        endy = (int) (y + (length * Math.sin(n * Math.PI)));
        graphics.setColor(Color.red);
        graphics.drawLine(x - 1, y, endx - 1, endy);
        graphics.drawLine(x + 1, y, endx + 1, endy);
        graphics.drawImage(hook, endx - 36, endy - 2, null);
    }

    public void paintSelf(Graphics graphics) {
        logic();
        switch (state) {
            case 0://左右摇摆
                if (n < 0.05) dir = 1;
                else if (n > 0.95) dir = -1;
                n += 0.0041 * dir;
                this.paintLine(graphics);
                break;
            case 1://抓取
                if (length <= MAX_length) {
                    length += 20;
                    this.paintLine(graphics);
                } else state = 2;
                break;
            case 2://回收
                if (length >= MIN_length) {
                    length -= 20;
                    this.paintLine(graphics);
                } else state = 0;
                break;
            case 3://抓取返回
                double m = 1;
                if (length >= MIN_length) {
                    length -= 10;
                    this.paintLine(graphics);
                    for (Object object : frame.objectList)
                    {
                        if(object.getFlag()) {
                            m = object.getM();
                            object.setX(endx - object.getWidth() / 2);
                            object.setY(endy);
                            if(length < MIN_length) {
                                object.setX(-150);
                                object.setY(-150);
                                object.setFlag(false);
                                Bg.waterFlag = false;
                                //加分
                                Bg.count += object.getCount();
                                state = 0;
                            }
                            if(Bg.waterFlag) {//按了鼠标右键之后
                                if(object.getType() == 1) {
                                    m = 1;//如果是金块，加快移动速度
                                }
                                if(object.getType() == 2) {//如果是石块，爆破即消失
                                    object.setX(-150);
                                    object.setY(-150);
                                    object.setFlag(false);
                                    Bg.waterFlag = false;
                                    state = 2;
                                }
                            }
                        }
                    }
                }
                try {
                    Thread.sleep((long) m);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
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

    public int getEndx() {
        return endx;
    }

    public void setEndx(int endx) {
        this.endx = endx;
    }

    public int getEndy() {
        return endy;
    }

    public void setEndy(int endy) {
        this.endy = endy;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
