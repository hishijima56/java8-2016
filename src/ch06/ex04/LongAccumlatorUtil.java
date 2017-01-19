/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch06.ex04;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.LongStream;

/**
 * 練習問題06_04
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/01/19
 */
public class LongAccumlatorUtil {

    public static void main(String[] args) {

        LongAccumulator longArrayMax = new LongAccumulator(Long::max, Long.MIN_VALUE);
        long[] longArray = LongStream.range(-100L, 100L).toArray();

        for (long l : longArray) {
            longArrayMax.accumulate(l);
        }

        long max = longArrayMax.get();

        System.out.println(max);
        LongAccumulator longArrayMin = new LongAccumulator(Long::min, Long.MAX_VALUE);
        for (long l : longArray) {
            longArrayMin.accumulate(l);
        }

        long min = longArrayMin.get();
        System.out.println(min);

    }

}
