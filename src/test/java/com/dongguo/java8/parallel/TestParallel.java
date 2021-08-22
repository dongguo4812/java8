package com.dongguo.java8.parallel;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author Dongguo
 * @date 2021/8/16 0016-7:10
 * @description:
 */
public class TestParallel {
    @Test
    public void test1() {
        //执行前时间
        //long start = System.currentTimeMillis();
        Instant start = Instant.now();//java8时间
        //创建一个ForkJoinPool线程池
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0, 100000000000L);//1000亿的累加

        long sum = pool.invoke(task);
        System.out.println(sum);
        //执行后时间
        //long end = System.currentTimeMillis();
        Instant end = Instant.now();
        System.out.println("耗费的时间为: " + (Duration.between(start, end).toMillis()));//19229毫秒
    }

    @Test
    public void test2() {
        Instant start = Instant.now();
        long sum = 0l;
        for (int i = 0; i < 50000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗费的时间为: " + (Duration.between(start, end).toMillis()));//15720毫秒
    }

    @Test
    public void test3() {
        long start = System.currentTimeMillis();

        Long sum = LongStream.rangeClosed(0L, 100000000L)
                .parallel()
                .sum();

        System.out.println(sum);

        long end = System.currentTimeMillis();

        System.out.println("耗费的时间为: " + (end - start));
    }
}