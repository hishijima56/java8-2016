/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch06.ex03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * 練習問題06_03
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/01/18
 */
public class CompareCountUpTime {

    private static final int THREADS_SIZE = 1000;

    private static final int MAX_COUNT = 100000;

    private static final int TIMEOUT_MINUTE = 10;

    /**
     * mainメソッドです。
     * @param args 実行時引数
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        //AtomicLong
        AtomicLong atomicLongCounter = new AtomicLong();

        //LongAdder
        LongAdder longAdderCounter = new LongAdder();

        long startTime;
        long finishTime;
        long atomicLongTime;
        long longAdderTime;


        //AromicLongの時間計測
        System.out.println("AtomicLongの時間計測を行います。");
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_SIZE);
        startTime = System.nanoTime();
        for (int i = 1; i < THREADS_SIZE; i++) {
            executor.submit(() -> {
                for (int j = 1; j < MAX_COUNT; j++) {
                    atomicLongCounter.incrementAndGet();
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(TIMEOUT_MINUTE, TimeUnit.MINUTES);
        finishTime = System.nanoTime();
        atomicLongTime = finishTime - startTime;

        //LongAdderの時間計測
        System.out.println("LongAdderの時間計測を行います。");
        ExecutorService executor2 = Executors.newFixedThreadPool(THREADS_SIZE);
        startTime = System.nanoTime();
        for (int i = 1; i < THREADS_SIZE; i++) {
            executor2.submit(() -> {
                for (int j = 1; j < MAX_COUNT; j++) {
                    longAdderCounter.increment();
                }
            });
        }
        executor2.shutdown();
        executor2.awaitTermination(TIMEOUT_MINUTE, TimeUnit.MINUTES);
        finishTime = System.nanoTime();
        longAdderTime = finishTime - startTime;

        System.out.println("AtomicLong : "+ atomicLongTime);
        System.out.println("LongAdder  : "+ longAdderTime);


    }
}
