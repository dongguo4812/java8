package com.dongguo.java8.annotation;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * @author Dongguo
 * @date 2021/8/15 0015-14:44
 * @description:
 */
public class TestAnnotation {
    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show(@MyAnnotation("abc")String str) {
    }

    @Test
    public void test1() throws Exception {
        Class<TestAnnotation> aClass = TestAnnotation.class;
        Method show = aClass.getMethod("show");
        MyAnnotation[] annotations = show.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation my : annotations) {
            System.out.println(my.value());
        }
    }
}