package cn.it.Interface;

/**
 * @author jx
 * @date 2021/8/20
 **/
public class Demo01 {
    public static void main(String[] args) {
        MyInterfaceImpl myInterface = new MyInterfaceImpl();
        myInterface.test();

        MyInterfaceStatic.test();
        System.out.println(MyInterface.a);
    }
}
