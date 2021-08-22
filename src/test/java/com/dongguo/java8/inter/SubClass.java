package com.dongguo.java8.inter;

/**
 * @author Dongguo
 * @date 2021/8/16 0016-8:11
 * @description:
 */
public class SubClass  implements MyFun,MyFun2{
    @Override
    public String getName() {
        return MyFun2.super.getName();
    }
}