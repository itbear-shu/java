package com.itjx.Bg;
/**
 * 背景类：设置背景
 */

import com.itjx.GameWin.GameWin;

import java.awt.*;

public class Bg {
    //开始时间
    public static long startTime;
    //结束时间
    public static long endTime;
    //设置关卡数
    public static int level = 1;
    //每一关的目标得分
    public static int goal = level * 10;
    //总分
    public static int count = 0;
    //药水数量
    public static int water_num = 3;
    //药水状态，默认是false，true是正在使用
    public static boolean waterFlag = false;

    Image bg = Toolkit.getDefaultToolkit().getImage("images/bg.jpg");
    Image bg1 = Toolkit.getDefaultToolkit().getImage("images/bg1.jpg");
    Image peo = Toolkit.getDefaultToolkit().getImage("images/peo.png");
    Image water = Toolkit.getDefaultToolkit().getImage("images/water.png");

    public void paintSelf(Graphics graphics) {
        graphics.drawImage(bg, 0, 0, null);
        graphics.drawImage(bg1, 0, 0, null);
        switch (GameWin.state) {
            case 0:
                drawWord(graphics, 700, 200, 80, Color.red, "准备开始");
                break;
            case 1:
                graphics.drawImage(peo, 800, 145, null);
                drawWord(graphics, 30, 150, 35, Color.black, "积分：" + count);
                if(water_num < 0) {
                    drawWord(graphics, 470, 200, 35, Color.green, "*0");
                }
                else {
                    drawWord(graphics, 470, 200, 35, Color.green, "*" + water_num);
                }
                graphics.drawImage(water, 400, 150, null);
                graphics.drawString(" 来自东方的神秘力量",380, 120);

                //关卡数
                drawWord(graphics, 806, 100, 50, Color.darkGray, "第" + level + "关");
                //目标分数
                drawWord(graphics, 1000, 160, 45, Color.red, "目标: " + goal + "分");

                drawWord(graphics, 1300, 150, 35, Color.orange, "规则: ");
                graphics.drawString("     1.夹中大块加8分",1300, 150);
                graphics.drawString("     2.夹中中快加4分",1300, 185);
                graphics.drawString("     3.夹中小块加2分",1300, 220);
                graphics.drawString("     4.夹中石块扣5分",1300, 255);
                //时间组件
                endTime = System.currentTimeMillis();
                //倒计时
                long time = 60 - (endTime - startTime) / 1000;
                drawWord(graphics, 30, 200, 35, Color.black, "倒计时: " + (time > 0 ? time : 0));
                break;
            case 2:break;
            case 3:
                drawWord(graphics, 750, 500, 80, Color.orange, "游戏失败！");
                drawWord(graphics, 750, 580, 80, Color.orange, "积分：" + count);
                break;
            case 4:
                drawWord(graphics, 750, 500, 80, Color.red, "通过成功！");
                break;
        }
    }

    //ture倒计时完成，false正在倒计时
    public boolean gameTime() {
        long tim = (endTime - startTime) / 1000;
        if(tim > 60) {
            return true;
        }
        return false;
    }

    public static void drawWord(Graphics graphics, int x, int y, int size, Color color, String str){
        graphics.setColor(color);
        graphics.setFont(new Font("楷体", Font.BOLD, size));
        graphics.drawString(str, x, y);

    }
}
