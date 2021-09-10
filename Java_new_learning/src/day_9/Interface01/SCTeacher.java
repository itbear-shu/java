package day_9.Interface01;

import com.sun.org.apache.xalan.internal.xsltc.trax.StAXEvent2SAX;

/*
描述会唱歌的厨子是一个老师的类
* */
public class SCTeacher extends Person implements Cooking, Sing{
    private String Course;

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    @Override
    public void fry() {
        System.out.println("会做饭");
    }

    @Override
    public void showInfo() {
        System.out.println(this.getName());
        System.out.println(this.getAge());
        System.out.println(this.getGender());
        System.out.println(this.getCourse());
    }

    @Override
    public void singing() {
        System.out.println("会唱歌");
    }

    public static void main(String[] args) {
        SCTeacher teacher = new SCTeacher();
        teacher.setAge(30);
        teacher.setName("jjj");
        teacher.setGender("male");
        teacher.setCourse("Physic");

        teacher.showInfo();
        teacher.singing();
        teacher.fry();
    }
}
