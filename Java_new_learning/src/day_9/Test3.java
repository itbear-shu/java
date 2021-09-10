package day_9;

public class Test3 {
    int i,j,k;

    class A{
        int i = 4;
        public void setTest3() {
            Test3.this.i = 1;//内部类访问外部类
            Test3.this.j = 2;
            Test3.this.k = 3;
        }
    }

    public void setInfo() {
        new A().setTest3();//外部类访问内部类
        new A().i = 5;
    }

    public void showInfo() {
        System.out.println(this.i);
        System.out.println(this.j);
        System.out.println(this.k);
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        test3.setInfo();
        test3.showInfo();
    }
}
