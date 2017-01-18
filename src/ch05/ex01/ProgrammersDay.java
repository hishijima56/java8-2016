/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch05.ex01;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * 練習問題05_01
 *
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/01/15
 */
public class ProgrammersDay {

    /**
     * mainメソッド.
     * @param args
     */
    public static void main(String[] args) {

        for(int i = 2000; i<2031; i++){
            System.out.println(i+"年のプログラマーの日は" + calcProgrammersDay(i).format(DateTimeFormatter.ISO_LOCAL_DATE) + " です。");
        }
    }

    /**
     * プログラマーの日を計算します。
     */
    private static LocalDate calcProgrammersDay(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("引数は 1以上の整数に設定して下さい。 設定値：" + year);
        }

        return LocalDate.of(year, 1, 1).plus(Period.ofDays(255));

    }

}
