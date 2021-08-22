package com.dongguo.java8;

import com.dongguo.java8.stream.Employee;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Dongguo
 * @date 2021/8/15 0015-6:39
 * @description:
 */
public class TestLambda3 {
    /**
     * @author Dongguo
     * @date 2021/8/15 0015 6:44
     * @description:类::静态方法名
     */
    @Test
    public void test2(){
        BiPredicate<String,String> bi1 = (x,y)->x.equals(y);
        BiPredicate<String,String> bi2 = String::equals;
    }
    /**
     * @author Dongguo
     * @date 2021/8/15 0015 6:45
     * @description:类::实例方法名
     */
    @Test
    public void test3(){
        Comparator<Integer> com1 = (x, y)->Integer.compare(x,y);
        Comparator<Integer> com2 = Integer::compare;

    }
    /**
     * @author Dongguo
     * @date 2021/8/15 0015 8:03
     * @description:构造器引用 ClassName::new
     */
    @Test
    public void test(){
        Supplier<Employee> sup1 = ()->new Employee();
        Supplier<Employee> sup2 = Employee::new;
    }
    @Test
    public void test4(){
        Function<Integer,String[]> fun1 = (x)->new String[x];
        String[] apply1 = fun1.apply(10);
        System.out.println(apply1.toString());

        Function<Integer,String[]> fun2 = String[]::new;
        String[] apply2 = fun2.apply(10);
        System.out.println(apply2.toString());
    }
}