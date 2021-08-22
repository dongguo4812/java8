package com.dongguo.java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dongguo
 * @date 2021/8/14 0014-15:02
 * @description:
 */
public class EmployeeDemo {
    //创建一个员工集合
    List<Employee> employees = Arrays.asList(new Employee("张三", 18, 3000),
            new Employee("张三", 18, 4000),
            new Employee("李四", 28, 5000),
            new Employee("王五", 38, 6000),
            new Employee("赵六", 48, 5500),
            new Employee("田七", 58, 4500));

    @Test
    public void test1() {
        List<Employee> list = filterEmployeeByAge(employees);
        System.out.println(list);
    }

    /**
     * @author Dongguo
     * @date 2021/8/14 0014 15:15
     * @description:获得当前公司员工年龄大于35的员工信息
     */
    public static List<Employee> filterEmployeeByAge(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (emp.getAge() > 35) {
                emps.add(emp);
            }
        }
        return emps;
    }

    @Test
    public void test2() {
        List<Employee> list = filterEmployeeByAge(employees);
        System.out.println(list);
    }

    /**
     * @author Dongguo
     * @date 2021/8/14 0014 15:19
     * @description:需求：获取当前公司员工工资大于5000的员工信息
     */
    public static List<Employee> filterEmployeeBySalary(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (emp.getSalary() > 5000) {
                emps.add(emp);
            }
        }
        return emps;
    }

    @Test
    public void test3() {
        //获得当前公司员工年龄大于35的员工信息
        List<Employee> list = filterEmployee(employees,new FilterEmployeeByAge());
        System.out.println(list);
        //获取当前公司员工工资大于5000的员工信息
        List<Employee> list2 = filterEmployee(employees,new FilterEmployeeBySalary());
        System.out.println(list2);
    }

    /**
     * @author Dongguo
     * @date 2021/8/14 0014 15:33
     * @description:根据不同的条件过滤
     */
    public static  List<Employee> filterEmployee( List<Employee> list ,MyPredicate p){
        List<Employee> emps = new ArrayList<>();
        for (Employee emp:list) {
            if (p.predicate(emp)){
                emps.add(emp);
            }
        }
        return emps;
    }

    @Test
    public void test4() {
        //获得当前公司员工年龄大于35的员工信息
        List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean predicate(Employee employee) {
                return employee.getAge() > 35;
            }
        });
        System.out.println(list);
        //获取当前公司员工工资大于5000的员工信息
        List<Employee> list2 = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean predicate(Employee employee) {
                return employee.getSalary()>5000;
            }
        });
        System.out.println(list2);
    }

}

