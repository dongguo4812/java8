package com.dongguo.java8.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Dongguo
 * @date 2021/8/15 0015-11:34
 * @description:
 */
public class TestStream4 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 3000, Status.VOCATION),
            new Employee("张三", 18, 4000, Status.BUSY),
            new Employee("李四", 28, 5000, Status.FREE),
            new Employee("王五", 38, 6000, Status.FREE),
            new Employee("赵六", 48, 5500, Status.BUSY),
            new Employee("田七", 58, 4500, Status.VOCATION));

    @Test
    public void test2() {
        Optional<Integer> reduce = employees.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);
        System.out.println(reduce.get());
    }

    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream()
                .map((x) -> x * x)
                .forEach(System.out::println);
    }
}