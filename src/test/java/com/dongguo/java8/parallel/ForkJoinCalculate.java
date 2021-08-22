package com.dongguo.java8.parallel;

import java.util.concurrent.RecursiveTask;

/**
 * @author Dongguo
 * @date 2021/8/16 0016-7:10
 * @description:/计算从start-end之和
 */

public class ForkJoinCalculate extends RecursiveTask<Long> {

    private static final long serialVersionUID = 13475679780L;

    private long start;//初始值
    private long end;//结束值

    private static final long THRESHOLD = 10000L; //拆分临界值

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        //个数小于临界值
        if (length <= THRESHOLD) {
            long sum = 0;

            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            //个数大于临界值 拆分为两部分
            long middle = (start + end) / 2;

            ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
            left.fork(); //并将该子任务压入线程队列

            ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
            right.fork();//并将该子任务压入线程队列
            //汇总
            return left.join() + right.join();
        }
    }
}