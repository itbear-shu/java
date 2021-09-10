package com.itjx.GameWin;

import com.itjx.Bg.Bg;
import com.itjx.Gold.Gold;
import com.itjx.Gold.GoldMini;
import com.itjx.Gold.GoldPlus;
import com.itjx.Line.Line;
import com.itjx.Object.Object;
import com.itjx.Other.Other;
import com.itjx.Rock.Rock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GameWin extends JFrame {
    //0未开始 1运行中 2商店 3失败 4胜利
    public static int state;
    //存储金块、石块
    public List<Object> objectList = new ArrayList<Object>();

    Bg bg = new Bg();
    Line line = new Line(this);

    {
        //是否可以放置
        boolean isPlace = true;
        for (int i = 0; i < 12; i++) {
            double random = Math.random();
            Gold gold;//存放当前生成的变量
            if (random <= 0.3) gold = new GoldMini();
            else if (random > 0.3 && random <= 0.7) gold = new GoldPlus();
            else gold = new Gold();
            for (Object object : objectList) {
                if (gold.getRec().intersects(object.getRec())) {
                    //堆叠，不可放置，需要重新生成
                    isPlace = false;
                }
            }
            if (isPlace) objectList.add(gold);
            else {
                isPlace = true;
                i--;
            }
        }
        for (int i = 0; i < 10; i++) {
            Rock rock = new Rock();
            for (Object object : objectList) {
                if (rock.getRec().intersects(object.getRec())) isPlace = false;
            }
            if (isPlace) objectList.add(rock);
            else {
                isPlace = true;
                i--;
            }
        }
//        for (int i = 0; i < 2; i++) {
//            Other other = new Other();
//            for (Object object : objectList) {
//                if(other.getRec().intersects(object.getRec())) isPlace = false;
//            }
//            if (isPlace) objectList.add(other);
//            else {
//                isPlace = true;
//                i--;
//            }
//        }
    }

    Image offScreenImage;//定义画布

    public void launch() {
        this.setVisible(true);//设置窗口是否可见
        this.setSize(1800, 1200);//设置窗口位置
        this.setLocationRelativeTo(null);//设置窗口居中
        this.setTitle("The Gold Miner");//设置窗口名称
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置默认关闭方式
        //键盘操作
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);//按下空格键时调用此方法
                if (e.getKeyCode() == 0x20 && line.getState() == 0) line.setState(1);
            }
        });
        //鼠标操作
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch (state) {
                    case 0:
                        if (e.getButton() == 3)
                        {
                            state = 1;
                            Bg.startTime = System.currentTimeMillis();
                        }
                        break;
                    case 1:
                        //左键是1，右键是3，滚轮是2
                        if (e.getButton() == 1 && line.getState() == 0) line.setState(1);//左右摇摆时
                        //抓取回去并且点击鼠标右键时
                        if (e.getButton() == 2 && line.getState() == 3 && Bg.water_num > 0) ;
                        {
                            Bg.waterFlag = true;
                            Bg.water_num--;
                            if (Bg.water_num < 0) Bg.water_num = 0;
                        }
                    break;
                    case 2:
                        break;
                    case 3:

                        break;
                    case 4:
                        break;
                    default:
                        break;
                }

            }
        });

        while (true) {
            repaint();//重复绘画
            nextLevel();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //下一关
    public void nextLevel() {
        if (state == 1 && bg.gameTime()) {
            if(Bg.count >= Bg.goal) {
                if(Bg.level >= 5) {
                    state = 4;
                } else {
                    Bg.level++;
                }
                Bg.count = 0;
                Bg.goal = 10 * Bg.level;
                Bg.waterFlag = false;
                Bg.water_num = 5;
                dispose();//释放之前的窗体
                GameWin gameWin1 = new GameWin();
                gameWin1.launch();
            } else state = 3;
        }
    }

    @Override
    public void paint(Graphics graphics) {
        //双缓存技术解决频闪问题
        offScreenImage = this.createImage(2000, 1800);
        Graphics gImage = offScreenImage.getGraphics();

        bg.paintSelf(gImage);
        if (state == 1) {
            //只有在游戏运行时绘制物体
            for (Object object : objectList) {
                object.paintSelf(gImage);
            }
            line.paintSelf(gImage);
        }

        graphics.drawImage(offScreenImage, 0, 0, null);
    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}
