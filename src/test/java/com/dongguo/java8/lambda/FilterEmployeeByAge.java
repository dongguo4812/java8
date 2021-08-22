package com.dongguo.java8.lambda;

/**
 * @author Dongguo
 * @date 2021/8/14 0014-15:29
 * @description:
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean predicate(Employee e) {
        return e.getAge() > 35;
    }
}