package com.dongguo.java8.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Dongguo
 * @date 2021/8/15 0015-8:13
 * @description:
 */
public class TestStream1 {
    /**
     * @author Dongguo
     * @date 2021/8/15 0015 8:16
     * @description:创建stream
     */
    @Test
    public void test1() {
        //1可以通过collection系列集合提供的stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();
        //2通过Arrays中的静态方法stream()
        Employee[] employees = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(employees);
        //3通过Stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("aaa", "bbb");
        //4创建无限流
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        //迭代
        stream4.limit(10)
                .forEach(System.out::println);

        //生成
        Stream.generate(()->Math.random())
                .limit(5)
                .forEach(System.out::println);
    }
        List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 3000, Status.VOCATION),
            new Employee("张三", 18, 4000, Status.BUSY),
            new Employee("李四", 28, 5000, Status.FREE),
            new Employee("王五", 38, 6000, Status.FREE),
            new Employee("赵六", 48, 5500, Status.BUSY),
            new Employee("田七", 58, 4500, Status.VOCATION));
    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        for(Employee e: employees){
            list.add(e.getName());
        }
        System.out.println(list);
    }

    @Test
    public void test3() {
        List<String> list = new ArrayList<>();
        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()) {
            Employee e = iterator.next();
            list.add(e.getName());
        }
        System.out.println(list);
    }

    @Test
    public void test4() {
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}