package day_7;

public class Person {
    private String name;
    private int age;
    private String gender;

//    public Person(String name) {
//
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void showInfo() {
        System.out.println("Person方法");
//        System.out.println(this.name);
//        System.out.println(this.age);
//        System.out.println(this.gender);
    }
}
