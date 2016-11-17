/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch02.ex07;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * 練習問題02_07
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/17
 */
public class FiniteStreamChecker {

    /**
     * 指定されたストリームが有限かどうかを返します。
     * @param stream stream
     * @return true/false
     */
    public static <T> boolean isFinite( Stream<T> stream){
        Objects.requireNonNull(stream);

        //estimateSizeを使用する
        long estimateSize = stream.spliterator().estimateSize();
        System.out.println(estimateSize);
        return estimateSize < Long.MAX_VALUE;
    }
}
