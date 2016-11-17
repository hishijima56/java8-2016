/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch02.ex13;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 練習問題02_13
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/17
 */
public class StringStreamElementCounterEx {

    /**
     * {@link AtomicIntegerArray}
     */
    private AtomicIntegerArray atomicCountArray;

    /**
     * 指定されたストリームに対して指定された文字数以下の要素数を返します。
     * @param stream stream
     * @param length 指定文字数
     * @return 指定文字数ごとの要素数の配列
     */
    public int[] countElementLength(Stream<String> stream, int length) {
        Objects.requireNonNull(stream);
        if (length < 0) {
            throw new IllegalArgumentException("lengthは0以上を設定して下さい。");
        }
        atomicCountArray = new AtomicIntegerArray(length + 1);
        stream.parallel().filter(s -> s.length() <= length).forEach(s -> atomicCountArray.getAndIncrement(s.length()));

        int[] intArray = new int[atomicCountArray.length()];
        IntStream.range(0, length + 1).forEach(i -> intArray[i] = atomicCountArray.get(i));
        return intArray;
    }

}
