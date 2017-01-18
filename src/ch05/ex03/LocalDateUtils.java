/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch05.ex03;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

/**
 * 練習問題05_03
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/01/15
 */
public class LocalDateUtils {

    /**
     * mainメソッド.
     * @param args 実行時引数
     */
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today.with(next(w -> w.getDayOfWeek().getValue() < 6)));
    }

    /**
     * 条件を満たす翌日の日付を返します。
     * @param p 条件
     * @return {@link LocalDate}
     */
    public static TemporalAdjuster next(Predicate<LocalDate> p) {
        return TemporalAdjusters.ofDateAdjuster(d -> {
            LocalDate localDate = d.plusDays(1L);
            while (!p.test(localDate)) {
                localDate = localDate.plusDays(1L);
            }
            return localDate;
        });
    }
}
