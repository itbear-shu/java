package cn.it.superAndthis;

/**
 * @author jx
 * @date 2021/8/21
 **/
public class Zi extends Fu{
    int n;
    int m;
    public Zi() {
        super(1);
    }
    public Zi(int n, int m) {
        this();
    }

    public void method() {
        System.out.println(super.a);
        super.method();
    }
}
