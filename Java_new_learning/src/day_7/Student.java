package day_7;

public class Student extends Person {
    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void showInfo() {//重写了父类Person()的showInfo()方法
        System.out.println("Student方法");
//        System.out.println(this.getAge());
//        System.out.println(this.getName());
//        System.out.println(this.getGender());
//        System.out.println(this.getSchool());
    }
}
