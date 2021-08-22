package com.dongguo.java8.optional;

import com.dongguo.java8.stream.Employee;
import com.dongguo.java8.stream.Status;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @author Dongguo
 * @date 2021/8/15 0015-12:41
 * @description:
 */
public class TestOptional {
    @Test
    public void test1() {
        Optional<Employee> optional = Optional.of(new Employee());
        Employee employee = optional.get();
        System.out.println(employee);//Employee{name='null', age=0, salary=0, status='null'}
    }

    @Test
    public void test2() {
        Optional<Employee> optional = Optional.empty();//创建一个空的Optional实例
        Employee employee = optional.get();//java.util.NoSuchElementException: No value present
        System.out.println(employee);
    }

    @Test
    public void test3() {
        Optional<Employee> optional = Optional.ofNullable(new Employee());
        Employee employee = optional.orElseGet(()->new Employee("张三", 18, 3000, Status.BUSY));
        System.out.println(employee);//Employee{name='null', age=0, salary=0, status='null'}

        Optional<Employee> optional2 = Optional.ofNullable(null);
        Employee employee2 = optional2.orElseGet(()->new Employee("张三", 18, 3000, Status.BUSY));
        System.out.println(employee2);//Employee{name='张三', age=18, salary=3000, status='BUSY'}
    }

    @Test
    public void test4() {
        Optional<Employee> optional = Optional.ofNullable(new Employee("张三", 18, 3000, Status.BUSY));
        Optional<String> optional1 = optional.flatMap((x) -> optional.of(x.getName()));
        System.out.println(optional1.get());//张三
    }
}