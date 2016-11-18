/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/
package ch01.ex09;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * 練習問題01_09
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/16
 */
public interface Collection2<T> extends Collection<T> {

    /**
     *
     * @param action
     * @param filter
     */
    default void forEachIf(Consumer<T> action, Predicate<T> filter){
        stream().forEach(t -> {
            if(filter.test(t)){
                action.accept(t);
            }
        });
    }
}
