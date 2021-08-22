package com.dongguo.java8;


import com.dongguo.java8.lambda.Employee;
import com.dongguo.java8.lambda.MyFunction;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;


/**
 * @author Dongguo
 * @date 2021/8/14 0014-16:07
 * @description:
 */
public class TestLambda {
    /**
     * @author Dongguo
     * @date 2021/8/14 0014 16:20
     * @description:语法格式一：无参数，无返回值 ()->System.out.println("Hello world");
     */
    @Test
    public void test1() {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        };
        runnable1.run();
        System.out.println("----------------");
        Runnable runnable2 = () -> System.out.println("Hello world");
        runnable2.run();
    }

    /**
     * @author Dongguo
     * @date 2021/8/14 0014 16:27
     * @description:语法格式二：有一个参数，无返回值 (t)->System.out.println("Hello world");
     */
    @Test
    public void test2() {
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("Hello world");

        System.out.println("------------");
        Consumer<String> consumer2 = x -> System.out.println(x);
        consumer2.accept("Hello world2");
    }

    @Test
    public void test3() {
        Comparator<Integer> comparator = (o1, o2) -> {
            System.out.println("比较两个值");
            return Integer.compare(o1, o2);
        };
    }

    /**
     * @author Dongguo
     * @date 2021/8/14 0014 16:51
     * @description:需求：对一个数进行运算
     */
    @Test
    public void test4() {
        Integer num = 10;
        Integer i = operation(num, (n) -> n + 100);
        System.out.println(i);

    }

    public static Integer operation(Integer num, MyFunction function) {
        return function.getValue(num);
    }

    List<Employee> employees = Arrays.asList(new Employee("张三", 20, 3000),
            new Employee("张三", 18, 4000),
            new Employee("李四", 28, 5000),
            new Employee("王五", 58, 6000),
            new Employee("赵六", 48, 5500),
            new Employee("田七", 38, 4500));

    @Test
    public void test5() {
        Collections.sort(employees, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            }
            return Integer.compare(e1.getAge(), e2.getAge());
        });
        System.out.println(employees);
    }
    /**
     * @author Dongguo
     * @date 2021/8/14 0014 17:47
     * @description:处理字符串
     */
    public static String stringToUpper(String s, MyFun fun) {

        return fun.getValue(s);
    }
    @Test
    public void test6() {
        String str = "abcdefg";
        String s = stringToUpper(str, (x) -> x.toUpperCase());
        System.out.println(s);
    }
    public static long op(long l1, long l2, MyFun2<Long,Long> function2){
        return function2.getValue(l1,l2);
    }
    @Test
    public void test7() {
        long l1 = 20L;
        long l2 = 15L;
        long op1 = op(l1, l2, (x1, x2) -> x1 + x2);
        System.out.println(op1);
        long op2 = op(l1, l2, (x1, x2) -> x1 * x2);
        System.out.println(op2);
    }
}