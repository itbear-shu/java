package cn.it.FanXing;


/**
 * @author jx
 * @date 2021/8/23
 **/
public class GenericInterfaceImpl<E> implements GenericInterface<E>{
    @Override
    public E test01(E e) {
        return e;
    }

    @Override
    public void test02(E e) {
        System.out.println(e);
    }

}
