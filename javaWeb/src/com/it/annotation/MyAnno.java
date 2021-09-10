package com.it.annotation;
@SuppressWarnings("all")
public @interface MyAnno {

    String show() default "zhangsan";

    String[] strs();

}
