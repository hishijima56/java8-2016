/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch05.ex06;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 *
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/01/16
 */
public class ShowFriday13th {

    public static void main(String[] args) {
        showAllFriday13th();
    }

    private static void showAllFriday13th(){
        LocalDate targetDate = LocalDate.of(1901, 1, 13);
        LocalDate endDate = targetDate.plusYears(100).minusDays(1);
        while(targetDate.compareTo(endDate) < 0){
            if(targetDate.getDayOfWeek() == DayOfWeek.FRIDAY){
                System.out.println(targetDate.toString());
            }
            targetDate = targetDate.plusMonths(1);
        }

    }

}
