/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch05.ex03;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

/**
 * {@link LocalDateUtils}のテスト・クラスです。
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/01/16
 */
public class LocalDateUtilsTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * {@link ch05.ex03.LocalDateUtils#next(java.util.function.Predicate)} のためのテスト・メソッド。
     */
    @Test
    public void testNext() {
        LocalDate today = LocalDate.of(2017,1,20);
        assertThat(today.with(LocalDateUtils.next(w -> w.getDayOfWeek().getValue() < 6)),is(LocalDate.of(2017, 1, 23)));
    }

}
