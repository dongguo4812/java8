package com.dongguo.java8.lambda;

/**
 * @author Dongguo
 * @date 2021/8/14 0014-15:21
 * @description:
 */
@FunctionalInterface
public interface MyPredicate<T> {
    public boolean predicate(T t);
}
