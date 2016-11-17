/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch02.ex07;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/18
 */
public class FiniteStreamCheckerTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * {@link ch02.ex07.FiniteStreamChecker#isFinite(java.util.stream.Stream)} のためのテスト・メソッド。
     */
    @Test
    public void testIsFinite() {
        //有限ストリームについて実行
        assertThat(FiniteStreamChecker.isFinite(IntStream.range(0,100).boxed()), is(true));

        //無限ストリームについて実行
        assertThat(FiniteStreamChecker.isFinite(Stream.generate(() -> Math.random())), is(false));

    }

}
