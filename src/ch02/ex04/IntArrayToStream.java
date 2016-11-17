/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch02.ex04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 練習問題02_04
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/17
 */
public class IntArrayToStream {

    public static void main(String[] args) {
        int[] values = {1,4,9,16};
        Stream<int[]>intArrayStream =  Stream.of(values);

        //int[] の Straemである
        intArrayStream.forEach(System.out::println);

        IntStream is = IntStream.of(values);
        //int の Straemである
        is.forEach(System.out::println);
    }
}
