package com.dongguo.java8.stream;


import org.junit.jupiter.api.Test;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Dongguo
 * @date 2021/8/15 0015-8:31
 * @description:
 */
public class TestStream2 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 3000, Status.VOCATION),
            new Employee("张三", 18, 4000, Status.BUSY),
            new Employee("李四", 28, 5000, Status.FREE),
            new Employee("王五", 38, 6000, Status.FREE),
            new Employee("王五", 38, 6000, Status.FREE),
            new Employee("赵六", 48, 5500, Status.BUSY),
            new Employee("田七", 58, 4500, Status.VOCATION));

    @Test
    public void test8() {
        employees.stream()
                .filter((e) -> e.getSalary() > 5000)
                .collect(toList())//import static java.util.stream.Collectors.toList;
                .forEach(System.out::println);
    }

    @Test
    public void test() {
        //中间操作：不执行任何操作
        Stream<Employee> stream1 = employees.stream()
                .filter((x) -> {
                    System.out.println("Stream API 的中间操作");
                    return x.getAge() > 35;
                });
        //终止操作：执行全部操作  惰性求值
        stream1.forEach(System.out::println);
    }

    @Test
    void test2() {
        employees.stream()
                .filter((x) -> {
                    System.out.println("短路");
                    return x.getSalary() > 4000;
                })
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    void test3() {
        employees.stream()
                .filter((x) -> x.getSalary() > 4000)
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void test7() {
        employees.stream()
                .filter(e -> e.getSalary() > 3000)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void test4() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        list.stream()
                .map((x) -> x.toUpperCase())
                .forEach(System.out::println);
        System.out.println("--------------");

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

    }

    @Test
    public void test5() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        Stream<Stream<Character>> stream1 = list.stream()
                .map(TestStream2::filterCharactor);
        stream1.forEach((s) -> {
            s.forEach(System.out::println);
        });
        System.out.println("-------------------------");
        list.stream()
                .flatMap(TestStream2::filterCharactor)
                .forEach(System.out::println);
    }

    public static Stream<Character> filterCharactor(String str) {
        List<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);

        }
        return list.stream();
    }

    @Test
    public void test6() {
        List<String> list = Arrays.asList("ccc", "aaa", "ddd", "bbb");
        list.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("----------------------------");
        employees.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge() == e2.getAge()) {
                        return e1.getName().compareTo(e2.getName());
                    }
                    return Integer.compare(e1.getAge(), e2.getAge());
                })
                .forEach(System.out::println);
    }
}