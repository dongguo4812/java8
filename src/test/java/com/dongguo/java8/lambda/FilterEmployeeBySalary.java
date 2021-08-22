package com.dongguo.java8.lambda;

/**
 * @author Dongguo
 * @date 2021/8/14 0014-15:30
 * @description:
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee> {
    @Override
    public boolean predicate(Employee employee) {
        return employee.getSalary() > 5000;
    }
}