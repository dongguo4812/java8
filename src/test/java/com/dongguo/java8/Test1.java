package com.dongguo.java8;

/**
 * @author Dongguo
 * @date 2021/8/20 0020-9:52
 * @description:
 */
public class Test1 {
    public static void main(String[] args) {
        String str = "abcdefg";
        String reverseStr1 = reverse(str);
        System.out.println(reverseStr1);
        StringBuilder sb = new StringBuilder(str);
        StringBuilder reverseStr2 = sb.reverse();
        System.out.println(reverseStr2);
        String reverseStr3 = reverseRecursive(str);
        System.out.println(reverseStr3);
    }

    private static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length()-1; i >=0 ; i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    public static String reverseRecursive(String originStr) {
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

}