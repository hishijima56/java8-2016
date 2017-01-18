/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch05.ex02;

import java.time.LocalDate;

/**
 * 練習問題05_02
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/01/15
 */
public class PlusYearsToLeapDay {

    /**
     * mainメソッド.
     * @param args 実行時引数
     */
    public static void main(String[] args) {

        LocalDate leapDay = LocalDate.of(2000, 2, 29);

        //1年を加算する
        System.out.println(leapDay.toString() + "に1年を加算すると " + leapDay.plusYears(1L).toString());

        //1年を加算する
        System.out.println(leapDay.toString() + "に4年を加算すると " + leapDay.plusYears(4L).toString());

        //1年を加算する
        System.out.println(leapDay.toString() + "に1年を4回加算すると " + leapDay.plusYears(1L).plusYears(1L).plusYears(1L).plusYears(1L).toString());

    }
}
