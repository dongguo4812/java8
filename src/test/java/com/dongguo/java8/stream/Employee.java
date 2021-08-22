package com.dongguo.java8.stream;

import java.util.Objects;

/**
 * @author Dongguo
 * @date 2021/8/14 0014-15:00
 * @description:
 */
public class Employee {

    private String name;
    private int age;
    private long salary;
    private Status Status;

    public Employee() {
    }

    public Employee(String name, int age, long salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String name, int age, long salary, Status status) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.Status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status status) {
        this.Status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && salary == employee.salary && Objects.equals(name, employee.name) && Status == employee.Status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, Status);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", status='" + Status + '\'' +
                '}';
    }
}