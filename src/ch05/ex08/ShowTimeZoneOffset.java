/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch05.ex08;

import java.time.Instant;
import java.time.ZoneId;

/**
 * 練習問題05_08
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

        showAllTimeZoneOffset();
    }

    private static void showAllTimeZoneOffset() {
        ZoneId.getAvailableZoneIds().stream().forEach(z -> System.out.println(z + ": " + ZoneId.of(z).getRules().getOffset(Instant.now()).toString()));
    }
}
