package day_9;

public abstract class Template {
    public abstract void code();

    public final void getTime() {
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();
        System.out.println("code方法执行的时间为：" + (end - start));
    }
}


