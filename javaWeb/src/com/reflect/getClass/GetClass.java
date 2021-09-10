package com.reflect.getClass;

public class GetClass {
    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("com.reflect.getClass.Person");
        System.out.println(clazz);
    }
}
