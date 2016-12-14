/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch03.ex03;

import java.util.function.Predicate;

/**
 * 練習問題03_03
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @param <T>
 * @since 2016/12/13
 */
public class Assertion<T> {

    public void assertThat(Predicate<T> predicate){
        if(!predicate.test(null)){
            throw new AssertionError();
        }
    }
    public void assertThat(Predicate<T> predicate , String message){
        if(!predicate.test(null)){
            throw new AssertionError(message);
        }
    }

}
