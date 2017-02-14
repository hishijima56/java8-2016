/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch08.ex04;

import java.util.Random;
import java.util.stream.LongStream;

/**
 * 練習問題08_04
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/14
 */
public class FindMinSeed {

    private static final long N = (long) Math.pow(2, 48);

    private static final long m = 25214903917L;

    private static final long a = 11L;

    private static final long v = 246154705703781L;

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("N : " + N);
        long s = prev(prev(prev(0L)));
        System.out.println("s : " + s);
        System.out.println("s^m : " + (s ^ m));

        Random gen = new Random(s ^ m);

        System.out.println("1回目 :");
        System.out.println(gen.nextDouble());

        System.out.println("2回目 :");
        System.out.println(gen.nextDouble());

        long minseed = LongStream.iterate(0L, seed -> prev(seed)).limit(1000000).min().orElse(Long.MAX_VALUE);

        System.out.println("minseed : " + minseed);
        gen = new Random();
        gen.setSeed(minseed^m);
        long i = 0;
        double d =100.0;
        while (d != 0.0d) {
            i++;
            d = gen.nextDouble();
        }
        //TODO 0にならない
        for(i=0;i<376050; i++){
            d = gen.nextDouble();
        }
        System.out.println(i + "回目　: " + d);
    }

    private static long prev(long s) {
        return (s - a) * v % N;
    }

}
