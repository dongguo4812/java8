package com.dongguo.java8.inter;

/**
 * @author Dongguo
 * @date 2021/8/16 0016-8:07
 * @description:
 */
public interface MyFun {
    default String getName(){
        return "哈哈哈";
    }
    public static void show(){
        System.out.println("接口中的静态方法");
    }
}
