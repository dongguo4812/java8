package com.dongguo.java8;

/**
 * @author Dongguo
 * @date 2021/8/14 0014-17:49
 * @description:
 */
@FunctionalInterface
public interface MyFun2<T, R> {
    R getValue(T t1, T t2);
}
