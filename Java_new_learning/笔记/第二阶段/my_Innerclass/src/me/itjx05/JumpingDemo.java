package me.itjx05;

public class JumpingDemo {
    public static void main(String[] args) {
        JumpingOperator jo = new JumpingOperator();
        Jumping j = new Cat();
        jo.method(j);

        jo.method(new Jumping() {
            @Override
            public void jumping() {
                System.out.println("跳跳糖");
            }
        });
    }
}
