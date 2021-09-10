package com.it.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.TYPE, ElementType.FIELD, ElementType.METHOD}) //表示该注解只能作用于类上
@Retention(RetentionPolicy.CLASS)
public @interface MyAnno2 {
}
