package me.Extend06;

public class Demo {
    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        t1.setAge(22);
        t1.setName("自江西");
        t1.teach();
        Student st = new Student();
        st.study();

        Teacher t2 = new Teacher("zjx", 19);
        t2.teach();

        Student st1 = new Student();
        st1.study();

        Student st2 = new Student("zjx", 19);
        st2.study();
    }
}
