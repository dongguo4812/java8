package com.dongguo.java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Dongguo
 * @date 2021/8/15 0015-15:33
 * @description:
 */
public class TestLambda {


    List<Employee> employees = Arrays.asList(new Employee("张三", 18, 3000),
            new Employee("张三", 18, 4000),
            new Employee("李四", 28, 5000),
            new Employee("王五", 38, 6000),
            new Employee("赵六", 48, 5500),
            new Employee("田七", 58, 4500));

    @Test
    public void test1() {
        //获得当前公司员工年龄大于35的员工信息
        List<Employee> list = filterEmployee(employees, (employee) -> employee.getAge() > 35);
        System.out.println(list);
        //获取当前公司员工工资大于5000的员工信息
        List<Employee> list2 = filterEmployee(employees, (employee) -> employee.getSalary() > 5000);
        System.out.println(list2);
    }
    /**
     * @author Dongguo
     * @date 2021/8/14 0014 15:33
     * @description:根据不同的条件过滤
     */
    public static List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> p) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (p.predicate(emp)) {
                emps.add(emp);
            }
        }
        return emps;
    }
    @Test
    public void test2() {
        //获得当前公司员工年龄大于35的员工信息
        employees.stream().filter(employee -> (employee.getAge() > 35)).forEach(System.out::println);
        System.out.println("-------------------------------------");
        //获取当前公司员工工资大于5000的员工信息
        employees.stream().filter(employee -> (employee.getSalary() > 5000)).forEach(System.out::println);
    }

    @Test
    public void test3() {
        //匿名内部类
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        //lambda
        Comparator<Integer> comparator2 = (o1, o2) -> o1.compareTo(o2);
    }

    @Test
    public void test4() throws Exception {
        //使用这个接口创建执行不同行为的线程：
        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
        //用Lambda表达式
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
        Thread.currentThread().join();
    }
}