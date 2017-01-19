/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch05.ex11;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * 練習問題05_11
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/01/17
 */
public class FlightTimePlan {

    /**
     * 飛行時間を取得します。
     * @param departureTime 出発時刻
     * @param arrivedTime 到着時刻
     * @return　Duration 飛行時間
     */
    public Duration getFlightTime(ZonedDateTime departureTime, ZonedDateTime arrivedTime){
        Objects.requireNonNull(departureTime, "departureTimeはnullではいけません。");
        Objects.requireNonNull(arrivedTime, "arrivedTimeはnullではいけません。");
        return Duration.between(departureTime, arrivedTime);
    }

    public static void main(String[] args) {
        ZonedDateTime departureTime = ZonedDateTime.of(LocalDateTime.of(2017, 1, 1, 14, 5), ZoneId.of("CET"));
        ZonedDateTime arrivedTime = ZonedDateTime.of(LocalDateTime.of(2017, 1, 1, 16, 40), ZoneId.of("America/Los_Angeles"));
        Duration flightDuration = new FlightTimePlan().getFlightTime(departureTime, arrivedTime);
        System.out.println(departureTime);
        System.out.println(arrivedTime);
        System.out.println(flightDuration.toHours() + ":" + flightDuration.toMinutes() % 60);
    }
}
