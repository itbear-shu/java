package day_11;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        D dd = new D();
        List<E> e = new ArrayList<E>();
        List<D> d = new ArrayList<D>();
        dd.test1(e);
        dd.test2(d);

        List<IA_implements> ia_implements = new ArrayList<IA_implements>();
        dd.test3(ia_implements);
    }
}

class D extends Person{
    public void test(List<?> list) {}//不确定集合类型时，用？代替😳
    public void test1(List<? extends E> list) {}//list参数元素只能是E即其子类
    public void test2(List<? super E> list) {}//list参数元素只能是E即其父类
    public void test3(List<? extends IA> list) {}////list参数元素只能是接口IA的实现类
}

class E extends D {}

class F extends E {}

interface IA {};

class IA_implements implements IA {

}