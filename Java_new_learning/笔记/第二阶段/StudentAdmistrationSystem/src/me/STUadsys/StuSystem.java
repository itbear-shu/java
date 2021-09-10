package me.STUadsys;

import java.util.ArrayList;
import java.util.Scanner;

public class StuSystem {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<Student> arrList = new ArrayList<>();
        //循环
        while (true) {
            //输出主界面
            System.out.println("------欢迎来到学生管理系统------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择：");

            //输入数据
            Scanner sc = new Scanner(System.in);
            int selection = sc.nextInt();

            //功能选择
            if (selection == 1) {
//                System.out.println("添加学生");
                addStudent(arrList);
            } else if (selection == 2) {
//                System.out.println("删除学生");
                delStudent(arrList);
            } else if (selection == 3) {
//                System.out.println("修改学生");
                updataStudent(arrList);
            } else if (selection == 4) {
//                System.out.println("查看所有学生");
                findAllStudent(arrList);
            } else if (selection == 5) {
                System.out.println("已成功退出!");
                break;
            } else {
                System.out.println("输入错误，请重新输入！");
            }
        }
    }

    //添加学生
    public static void addStudent(ArrayList<Student> arrayList) {
        //输入学生信息
        Scanner sc = new Scanner(System.in);
        String sid;
        while (true) {
            System.out.println("请输入学生学号： ");
            sid = sc.nextLine();
            boolean flag = isUsed(arrayList, sid);
            if (flag) {
                System.out.println("你输入的学号已经被使用，请重新输入！");
            } else {
                break;
            }
        }
        System.out.println("请输入学生姓名： ");
        String name = sc.nextLine();

        System.out.println("请输入学生年龄： ");
        String age = sc.nextLine();

        System.out.println("请输入学生居住地： ");
        String address = sc.nextLine();
        //创建学生对象
        Student st = new Student(sid, name, age, address);
        //把学生对象添加到集合中
        arrayList.add(st);
        //输入结束
        System.out.println("输入完毕!");
    }

    //查看学生
    public static void findAllStudent(ArrayList<Student> arrayList) {
        //先判断集合中是否有数据
        if (arrayList.size() == 0) {
            System.out.println("无信息，请添加后再查询！");
            return;
        }
        //输出提示信息
        System.out.println("学号\t\t姓名\t\t年龄\t\t居住地");
        //输出学生信息
        for (int i = 0; i < arrayList.size(); i++) {
            Student st = arrayList.get(i);
            System.out.print(st.getSid() + "\t" + st.getName() + "\t\t" + st.getAge()
                    + "\t\t" + st.getAddress());
            System.out.println();
        }
    }

    //删除学生
    public static void delStudent(ArrayList<Student> arrayList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的学生学号： ");
        String sid = sc.nextLine();
        boolean flag = false;
        for (int i = 0; i < arrayList.size(); i++) {
            Student st = arrayList.get(i);
            flag = false;
            if (st.getSid().equals(sid)) {
                arrayList.remove(i);
                flag = true;
            }
        }
        if (flag) {
            System.out.println("删除成功！");
        } else {
            System.out.println("未查询到相应学生，请检查输入是否有误!");
        }
    }

    //修改学生
    public static void updataStudent(ArrayList<Student> arrayList) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你要修改的学生学号： ");
        String sid = sc.nextLine();

        System.out.println("请输入修改后的学生年龄： ");
        String age = sc.nextLine();

        System.out.println("请输入修改后的学生居住地： ");
        String address = sc.nextLine();

        boolean flag = false;
        for (int i = 0; i < arrayList.size(); i++) {
            Student stu = arrayList.get(i);
            flag = false;
            if (stu.getSid().equals(sid)) {
                stu.setAge(age);
                stu.setAddress(address);
                flag = true;
            }
            arrayList.set(i, stu);
        }
        if (flag)
            System.out.println("修改成功!");
        else
            System.out.println("修改失败！未查询到相应学生，请检查学生学号输入是否有误！");
    }

    //判断学生学号是否被使用
    public static boolean isUsed(ArrayList<Student> arrayList, String sid) {
        boolean flag = false;
        for (int i = 0; i < arrayList.size(); i++) {
            Student st = arrayList.get(i);
            if(st.getSid().equals(sid)){
                flag = true;
            }
        }
        return flag;
    }
}
