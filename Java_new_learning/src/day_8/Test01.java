package day_8;

public class Test01 {
    public void method(Person p) {
        if(p instanceof Student) {
            Student me = (Student) p;
            me.getSchool();
        }
    }
    public static void main(String[] args) {
        Person p = new Person();
        Student s = new Student();

//        p = s;
//        s = (Student) p;
//
//        long l = 1L;
//        int i = (int) l;
//        Test01 t = new Test01();
//        t.method(s);

        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        Person p1 = new Person();
        Person p2 = new Person();
        System.out.println(p1.equals(p2));
    }

}
