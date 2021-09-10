package me.ArrayListP;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListP {
    public static void main(String[] args) {
        //创建学生集合对象
        ArrayList<Student> array = new ArrayList<>();
        //输入需要添加的学生对象的个数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生人数： ");
        int n = sc.nextInt();
        for(int i = 0;i < n;i++){
            addStudent(array);
        }
        System.out.println("添加完毕!感谢使用！");
        System.out.println("学生信息： ");
        for(int i = 0;i < n;i++){
            Student st;
            st = array.get(i);
            System.out.println("学生姓名：" + st.getName() + "&学生年龄：" + st.getAge());
        }
//        for (int i = 0; i < array.size(); i++){
//            Student st = array.get(i);
//            System.out.println("name: " + st.getName() + " age: " + st.getAge());
//        }
    }
    public static void addStudent(ArrayList<Student> array){
        //输入数据
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生姓名： ");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄： ");
        String age = sc.nextLine();
        //创建学生对象
        Student stu = new Student(name, age);
        //将学生对象添加到学生集合中
        array.add(stu);
    }
}
