package day_7;

public class Son extends Person{
    @Override
    public void showInfo() {
        System.out.println(this.getName());
    }

    public static void main(String[] args) {
        Son s = new Son();
        s.setAge(19);
        s.setName("zz");
        s.setGender("male");
        s.showInfo();
    }
}
