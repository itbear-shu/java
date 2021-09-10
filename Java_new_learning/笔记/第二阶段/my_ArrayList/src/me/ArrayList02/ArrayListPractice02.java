package me.ArrayList02;

import java.util.ArrayList;

public class ArrayListPractice02 {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<Student> arr = new ArrayList<>();
        //创建学生对象
        Student s1 = new Student("zjx", 18);
        Student s2 = new Student("zjt", 19);
        Student s3 = new Student("zjy", 17);

        //添加学生到集合
        arr.add(s1);
        arr.add(s2);
        arr.add(s3);

        //遍历对象
        for (int i = 0; i < arr.size(); i++) {
            Student student = arr.get(i);
            System.out.println("name: " + student.getName() + " age: "+ student.getAge());
        }
    }
}
