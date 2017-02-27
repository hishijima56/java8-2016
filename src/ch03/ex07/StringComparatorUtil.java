/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch03.ex07;

import java.util.Comparator;
import java.util.Objects;

/**
 * 練習問題03_07
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/27
 */
public class StringComparatorUtil {

    private StringComparatorUtil() {
    }

    /**
     * {@link String}のComparatorを生成します。
     * @param isNaturalOrder true:昇順/false:降順
     * @param isIgnoreCase true:大文字小文字無視/false:無視しない
     * @param isIgnoreSpace true:空白無視/false:無視しない
     * @return {@link Comparator}
     */
    public static Comparator<String> comparatorGenerator(boolean isNaturalOrder, boolean isIgnoreCase, boolean isIgnoreSpace) {
        return (s1, s2) -> {
            Objects.requireNonNull(s1, "compare string is not null");
            Objects.requireNonNull(s2, "compare string is not null");

            //空白無視かどうか
            if (isIgnoreSpace) {
                s1 = s1.replaceAll("　|\\s", "");
                s2 = s2.replaceAll("　|\\s", "");
            }

            //大文字小文字無視かどうか
            if (isIgnoreCase) {
                s1 = s1.toLowerCase();
                s2 = s2.toLowerCase();
            }

            //昇順or降順
            return isNaturalOrder ? s1.compareTo(s2) : s2.compareTo(s1);
        };
    }

}
