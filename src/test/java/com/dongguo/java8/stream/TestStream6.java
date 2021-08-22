package com.dongguo.java8.stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Dongguo
 * @date 2021/8/15 0015-21:36
 * @description:
 */
public class TestStream6 {

    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");
    List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950));

    /**
     * @author Dongguo
     * @date 2021/8/15 0015 21:38
     * @description:找出2011年发生的所有交易，并按交易额排序（从低到高）
     */
    @Test
    public void test1() {
        transactions.stream()
                .filter((t) -> t.getYear() == 2011)
                .sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
                .forEach(System.out::println);

    }

    /**
     * @author Dongguo
     * @date 2021/8/15 0015 21:46
     * @description:所有交易员所在的城市
     */
    @Test
    public void test2() {
        transactions.stream()
                .map((t) -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * @author Dongguo 
     * @date 2021/8/15 0015 21:51
     * @description:查找所有来自剑桥的交易员并按照姓名排序
     */
    @Test
    public void test3() {
        transactions.stream()
                .filter((t)->t.getTrader().getCity() =="Cambridge")
                .map(Transaction::getTrader)
                .distinct()
                .sorted((t1,t2)->t1.getName().compareTo(t2.getName()))
                .forEach(System.out::println);
    }
    /**
     * @author Dongguo 
     * @date 2021/8/15 0015 21:54
     * @description:返回所有交易员的姓名，并按照字母顺序排序
     */
    @Test
    public void test4() {
        transactions.stream()
                .map((t)->t.getTrader().getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
    /**
     * @author Dongguo 
     * @date 2021/8/15 0015 21:59
     * @description:是否有交易员在米兰工作
     */
    @Test
    public void test5() {
        boolean b = transactions.stream()
                .anyMatch((t) -> t.getTrader().getCity().equals("Milan"));
        System.out.println(b);

    }
    /**
     * @author Dongguo 
     * @date 2021/8/15 0015 22:03 
     * @description:计算在剑桥的交易员所有交易额
     */
    @Test
    public void test6() {
        Optional<Integer> sum = transactions.stream()
                .filter((t) -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(Integer::sum);
        System.out.println(sum.get());
    }
    /**
     * @author Dongguo 
     * @date 2021/8/15 0015 22:04 
     * @description:所有的交易中最高的交易额
     */
    @Test
    public void test7() {
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compare);
        System.out.println(max.get());
        System.out.println("--------------------------------");
        LongSummaryStatistics collect = transactions.stream()
                .collect(Collectors.summarizingLong(Transaction::getValue));
        System.out.println(collect.getMax());
        
    }
    /**
     * @author Dongguo 
     * @date 2021/8/15 0015 22:10
     * @description:找到交易额最小的交易
     */
    @Test
    public void test8() {
        Optional<Transaction> min = transactions.stream()
                .min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));
        System.out.println(min.get());

    }

    @Test
    public void test9() {
    }
}