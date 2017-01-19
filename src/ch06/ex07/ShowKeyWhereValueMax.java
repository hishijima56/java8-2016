/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch06.ex07;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 *　練習問題06_07
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/01/19
 */
public class ShowKeyWhereValueMax {

    /**
     * mainメソッド
     * @param args 実行時引数
     */
    public static void main(String[] args) {
        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();

        map.put("v1", 1L);
        map.put("v2", -1L);
        map.put("v3", 111L);
        map.put("v4", -21L);
        map.put("v5", 321L);
        map.put("v6", 11L);
        map.put("v7", 2L);

        Entry<String, Long> maxEntry = map.reduceEntries(2, (e1, e2) -> {
            return e1.getValue() > e2.getValue() ? e1 : e2;
        });

        System.out.println("max value entry ･･･ " + maxEntry.getKey() + " : " + maxEntry.getValue());

    }

}
