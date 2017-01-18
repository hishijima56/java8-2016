/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch05.ex05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 練習問題05_05
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/01/15
 */
public class CalcDaysSinceBirthDay {

    /**
     * mainメソッド
     * @param args
     */
    public static void main(String[] args) {

        LocalDate birthDay = LocalDate.of(1988, 5, 6);
        System.out.println("誕生日：" + birthDay.toString());
        System.out.println("生まれてからの日数は" + calcDaysSinceBirthDay(birthDay));
    }

    private static long calcDaysSinceBirthDay(LocalDate birthDay) {
        return birthDay.until(LocalDate.now(), ChronoUnit.DAYS);
    }
}