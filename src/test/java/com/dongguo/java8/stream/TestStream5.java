package com.dongguo.java8.stream;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author Dongguo
 * @date 2021/8/15 0015-20:52
 * @description:
 */
public class TestStream5 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 3000, Status.VOCATION),
            new Employee("张三", 18, 4000, Status.BUSY),
            new Employee("李四", 28, 5000, Status.FREE),
            new Employee("王五", 38, 6000, Status.FREE),
            new Employee("赵六", 48, 5500, Status.BUSY),
            new Employee("田七", 58, 4500, Status.VOCATION));
    @Test
    public void test1() {
        //求总数
        Long count = employees.stream()
                .collect(Collectors.counting());
        System.out.println(count);
        System.out.println("-------------------");
        //求平均值
        Double avg =  employees.stream()
                .collect(Collectors.averagingLong(Employee::getSalary));
        System.out.println(avg);
        //求总和
        long sum = employees.stream()
                .collect(Collectors.summingLong(Employee::getSalary));
        //求最大值
        Optional<Employee> max = employees.stream()
                .collect(Collectors.maxBy((e1, e2) -> Long.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(max.get());
        //求最小值
        Optional<Long> min = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Long::compare));
        System.out.println(min.get());
    }

    @Test
    public void test2() {
        //分组按照status
        Map<Status, List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
    }
    //多级分组
    @Test
    public void test3() {
        Map<Status, Map<String, List<Employee>>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (e.getAge() <= 35) {
                        return "青年";
                    } else if (e.getAge() <= 50) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                })));
        System.out.println(map);
    }
    //分区
    @Test
    public void test4() {
        Map<Boolean, List<Employee>> map = employees.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 5000));
        System.out.println(map);
    }
    //其他的获取方式
    @Test
    public void test5() {
        LongSummaryStatistics collect = employees.stream()
                .collect(Collectors.summarizingLong(Employee::getSalary));
        System.out.println(collect.getSum());
        System.out.println(collect.getAverage());
        System.out.println(collect.getMax());
        System.out.println(collect.getMin());
    }
    //拼接字符串
    @Test
    public void test6() {
        String str = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",","===","==="));
        System.out.println(str);
    }

    @Test
    public void test7() {
        long sum = employees.stream()
                .mapToLong(Employee::getSalary)
                .sum();
        System.out.println(sum);
    }

    @Test
    public void test8() {
        LongStream longStream = employees.stream()
                .mapToLong(Employee::getSalary);//数值流
        Stream<Long> stream = longStream.boxed();//转换回对象流
        stream.forEach(System.out::println);
    }

    @Test
    public void test9() {

        String collect = employees.stream()
                .collect(Collectors.collectingAndThen(Collectors.averagingLong(Employee::getSalary), s -> "平均工资为" + s));
        System.out.println(collect);
    }
}