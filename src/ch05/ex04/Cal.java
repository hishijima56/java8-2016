/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch05.ex04;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * 練習問題05_04
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/01/15
 */
public class Cal {

    /**
     * mainメソッド
     * @param args 実行時引数 (第一引数：月,第二引数：年)
     */
    public static void main(String[] args) {
        int year = -1;
        int month = -1;
        if (args.length != 2) {
            System.err.println("引数を2個設定して下さい。(第一引数：月,第二引数：年)");
            return;
        }
        try {
            month = Integer.parseInt(args[0]);
            year = Integer.parseInt(args[1]);
        } catch (NumberFormatException ne) {
            System.err.println("引数は半角数字を設定して下さい。");
            return;
        }

        if (month < 1 || month > 12) {
            System.err.println("第一引数は1以上12以下を設定して下さい。");
            return;
        }
        if (year < 1) {
            System.err.println("第一引数は1以上を設定して下さい。");
            return;
        }

        showCallender(year, month);

    }

    private static void showCallender(int year, int month) {
        LocalDate targetDate = LocalDate.of(year, month, 1);
        int targetDateLastDay = targetDate.plusMonths(1L).minusDays(1L).getDayOfMonth();


        //開始日まで空欄を入力させる
        if (!targetDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            for (int i = 1; i <= targetDate.getDayOfWeek().getValue(); i++) {
                System.out.print("\t");
            }
        }

        //カレンダー形式で表示する
        for (int d = 1; d <= targetDateLastDay; d++) {
            System.out.printf("%2d\t", d);
            if (targetDate.plusDays(d).getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                System.out.println();
            }
        }

    }
}
