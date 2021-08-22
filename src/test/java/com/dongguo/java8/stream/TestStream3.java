package com.dongguo.java8.stream;


import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Dongguo
 * @date 2021/8/15 0015-10:37
 * @description:
 */
public class TestStream3 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 3000, Status.VOCATION),
            new Employee("张三", 18, 4000, Status.BUSY),
            new Employee("李四", 28, 5000, Status.FREE),
            new Employee("王五", 38, 6000, Status.FREE),
            new Employee("赵六", 48, 5500, Status.BUSY),
            new Employee("田七", 58, 4500, Status.VOCATION));
    @Test
    public void test1() {
        boolean match1 = employees.stream()
                .allMatch((e) -> e.getStatus().equals(Status.BUSY));
        System.out.println(match1);
        boolean match2 = employees.stream()
                .anyMatch((e) -> e.getStatus().equals(Status.BUSY));
        System.out.println(match2);
        boolean match3 = employees.stream()
                .noneMatch((e) -> e.getStatus().equals(Status.BUSY));
        System.out.println(match3);
    }

    @Test
    public void test2() {
        Optional<Employee> op = employees.stream()
                .sorted((e1, e2) -> -Long.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println(op.get());  
        Optional<Employee> op2 = employees.stream()
                .filter((e)->e.getStatus().equals(Status.FREE))
                .findAny();
        System.out.println(op2.get());
    }

    @Test
    public void test3() {
        long count = employees.stream()
                .count();
        System.out.println(count);
        Optional<Employee> max = employees.stream()
                .max((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println(max.get());
        Optional<Long> min = employees.stream()
                .map(Employee::getSalary)
                .min((e1, e2) -> Long.compare(e1,e2));
        System.out.println(min.get());
    }

    @Test
    public void test4() {
        List<Integer>list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduce = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(reduce);

        System.out.println("---------------------");
        Optional<Long> op = employees.stream()
                .map(Employee::getSalary)
                .reduce(Long::sum);
        System.out.println(op.get());
    }

    @Test
    public void test5() {
        List<String> list = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println("--------------------------------");
        Set<String> set = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

        System.out.println("-----------------------------------");
        HashSet<String> hashSet = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hashSet.forEach(System.out::println);
    }
}