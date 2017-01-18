/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch05.ex10;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * 練習問題05_10
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/01/17
 */
public class FlightTimePlan {

    /**
     * 到着時刻を取得します。
     * @param departureTime
     * @param flightDuration
     * @param arriveZone
     * @return
     */
    public ZonedDateTime getArriveTime(ZonedDateTime departureTime, Duration flightDuration, ZoneId arriveZone){
        Objects.requireNonNull(departureTime, "departureTimeはnullではいけません。");
        Objects.requireNonNull(flightDuration, "flightDurationはnullではいけません。");
        Objects.requireNonNull(arriveZone, "arriveZoneはnullではいけません。");
        return departureTime.toInstant().plus(flightDuration).atZone(arriveZone);
    }

    public static void main(String[] args) {
        ZonedDateTime departureTime = ZonedDateTime.of(LocalDateTime.of(2017, 1, 1, 3, 5), ZoneId.of("America/Los_Angeles"));
        Duration flightDuration = Duration.ofHours(10L).plusMinutes(50L);
        ZonedDateTime arrivedTime = new FlightTimePlan().getArriveTime(departureTime, flightDuration, ZoneId.of("CET"));
        System.out.println(departureTime);
        System.out.println(arrivedTime);
    }
}
