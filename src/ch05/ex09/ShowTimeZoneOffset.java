/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch05.ex09;

import java.time.Instant;
import java.time.ZoneId;

/**
 * 練習問題05_09
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/01/16
 */
public class ShowTimeZoneOffset {

    /**
     * mainメソッド.
     * @param args
     */
    public static void main(String[] args) {

        showTimeZoneOffsetFiltered();
    }

    private static void showTimeZoneOffsetFiltered() {
        ZoneId.getAvailableZoneIds().stream().filter(z -> {
            int totalSeconds = ZoneId.of(z).getRules().getOffset(Instant.now()).getTotalSeconds();
            return (Math.abs(totalSeconds) % 3600 ) != 0;
        }).forEach(s -> System.out.println(s + ": " + ZoneId.of(s).getRules().getOffset(Instant.now()).toString()));
    }
}
