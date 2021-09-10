package day_11.枚举;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        Season.SPRING.showInfo();
//        @SuppressWarnings("rawtypes")
        //noinspection rawtypes
        List list = new ArrayList();
    }
}

enum Season implements IA{
    //相当于调用构造方法
    SPRING("Spring", "A"),
    SUMMER("Summer", "B"),
    AUTUMN("Autumn", "C"),
    WINTER("Winter", "D");

    private final String NAME;
    private final String DESC;

    Season(String NAME, String DESC) {
        this.NAME = NAME;
        this.DESC = DESC;
    }

    public void showInfo() {
        System.out.println(this.NAME + ", " + this.DESC);
    }

    @Override
    public void test() {

    }
}

enum Season1 implements IA{;
    @Override
    public void test() {

    }
}
interface IA {
    void test();

}

@Target(ElementType.FIELD)//表示这个注解类给其他类的属性做注解
@Retention(RetentionPolicy.RUNTIME)//表示定义注解的生命周期
@interface TestAnn {
    public int id() default 0;

    public String desc() default "";
}

class A {
    @TestAnn(id=1, desc = "abc")
    String name;
}