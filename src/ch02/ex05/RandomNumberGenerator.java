/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch02.ex05;

import java.util.stream.Stream;

/**
 * 練習問題02_05
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/17
 */
public class RandomNumberGenerator {

    /**
     * 線形合同法の乱数ストリームを返します。
     * @param a 定数a
     * @param c 定数c
     * @param m 定数m
     * @param seed シード(変数)
     * @return 乱数ストリーム
     */
    public static Stream<Long> getRundomNumberStream(long a, long c, long m, long seed) {
        return Stream.iterate(seed, x -> (a * x + c) % m).skip(1);
    }

    /**
     * mainメソッド
     * @param args 実行時j引数
     */
    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);

        Stream<Long> rundomNumberStream = getRundomNumberStream(a, c, m, 2);

        rundomNumberStream.limit(10).forEach(System.out::println);

    }

}
