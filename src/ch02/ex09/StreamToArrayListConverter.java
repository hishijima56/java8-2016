/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch02.ex09;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 練習問題02_09
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/18
 */
public class StreamToArrayListConverter {

    public <T> ArrayList<T> convertToArrayList1(Stream<ArrayList<T>> stream) {
        Objects.requireNonNull(stream);

        Optional<ArrayList<T>> optionalArrayList = stream.reduce((a, b) -> {
            a.addAll(b);
            return a;
        });

        return optionalArrayList.get();
    }

    public <T> ArrayList<T> convertToArrayList2(Stream<ArrayList<T>> stream) {
        Objects.requireNonNull(stream);

        ArrayList<T> resultList = stream.reduce(new ArrayList<T>(), (a, b) -> {
            a.addAll(b);
            return a;
        });

        return resultList;
    }

    public <T> ArrayList<T> convertToArrayList3(Stream<ArrayList<T>> stream) {
        Objects.requireNonNull(stream);
        ArrayList<T> resultList = new ArrayList<>();
        return stream.reduce(resultList, (a, b) -> {
            a.addAll(b);
            return a;
        }, (c, d) -> {
            c.addAll(d);
            return c;
        });

    }
}
