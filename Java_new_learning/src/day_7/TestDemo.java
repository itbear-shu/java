package day_7;

public class TestDemo {
    public static void main(String[] args) {
        Person p = new Person();
        p.showInfo();

        Student s = new Student();
        s.showInfo();

        Person e = new Student();
        e.showInfo();

//        System.out.println(p instanceof Person);
//        System.out.println(s instanceof Student);
//        System.out.println(e instanceof Student);
        System.out.println(p.equals(s));
        System.out.println(s.equals(e));
        System.out.println(p.hashCode());
        System.out.println(p.toString());
    }
}
