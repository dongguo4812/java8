package com.dongguo.java8;

import com.dongguo.java8.stream.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Dongguo
 * @date 2021/8/14 0014-20:21
 * @description:
 */
public class TestLambda2 {
    /**
     * @author Dongguo
     * @date 2021/8/14 0014 21:13
     * @description:将满足条件的字符串放到集合中
     */
    public List<String> filterStr(List<String> list, Predicate<String> predicate) {
        List<String> strList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                strList.add(s);
            }
        }
        return strList;
    }

    @Test
    public void test4() {
        List<String> asList = Arrays.asList("java", "c", "c++", "python");
        List<String> strings = filterStr(asList, (x) -> x.length() > 3);
        for (String s : strings) {
            System.out.println(s);
        }
    }

    /**
     * @author Dongguo
     * @date 2021/8/14 0014 21:01
     * @description:用于处理字符串
     */
    public String strHandler(String s, Function<String, String> function) {
        return function.apply(s);
    }

    @Test
    public void test3() {
        String str = "abcdefg";
        String s = strHandler(str, (x) -> x.toUpperCase());
        System.out.println(s);
    }

    /**
     * @author Dongguo
     * @date 2021/8/14 0014 20:50
     * @description:产生指定个数的整数，并放入集合
     */
    public List<Integer> getNumList(int num, Supplier<Integer> s) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer integer = s.get();
            list.add(integer);
        }
        return list;
    }

    @Test
    public void test2() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer i : numList) {
            System.out.println(i);
        }
    }

    public void consumer(double money, Consumer con) {
        con.accept(money);
    }
    /**
     * @author Dongguo
     * @date 2021/8/15 0015 6:36
     * @description:方法引用 对象::实例方法名
     */
    @Test
    public void test1() {
        Consumer<String> con1 = (x) -> System.out.println("Hello World");

        Consumer<String> con2 = System.out::println;
        con2.accept("Hello World");
        System.out.println("-------------------------------------------");
        Employee employee = new Employee("张三",18,3000);
        Supplier<Integer> sup1 = ()->employee.getAge();
        System.out.println(sup1.get());

        Supplier<Integer> sup2 = employee::getAge;
        System.out.println( sup2.get());
    }

}