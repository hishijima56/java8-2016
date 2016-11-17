/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch02.ex12;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

/**
 * 練習問題02_12
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/18
 */
public class StringStreamElementCounterTest {

    /**
     * {@link StringStreamElementCounter}
     */
    private StringStreamElementCounter target;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        target = new StringStreamElementCounter();
    }

    /**
     * {@link ch02.ex12.StringStreamElementCounter#countElementLength(java.util.stream.Stream, int)} のためのテスト・メソッド。
     */
    @Test
    public void testCountElementLength() {
        String[] contents = { "aaa", "bb", "ccccc", "dd", "e", "ffffff", "ggg" };
        Stream<String> wordsStream = Arrays.stream(contents);

        int[] elementCounts = target.countElementLength(wordsStream, 5);

        assertThat(elementCounts.length, is(6));
        assertThat(elementCounts[0], is(0));
        assertThat(elementCounts[1], is(1));
        assertThat(elementCounts[2], is(2));
        assertThat(elementCounts[3], is(2));
        assertThat(elementCounts[4], is(0));
        assertThat(elementCounts[5], is(1));
    }

    /**
     * {@link ch02.ex12.StringStreamElementCounter#countElementLength(java.util.stream.Stream, int)} のためのテスト・メソッド。
     */
    @Test(expected=NullPointerException.class)
    public void testCountElementLengthNull() {
        int[] elementCounts = target.countElementLength(null, 10);
    }

    /**
     * {@link ch02.ex12.StringStreamElementCounter#countElementLength(java.util.stream.Stream, int)} のためのテスト・メソッド。
     */
    @Test(expected=IllegalArgumentException.class)
    public void testCountElementLengthMinus() {
        String[] contents = { "aaa", "bb", "ccccc", "dd", "e", "ffffff", "ggg" };
        Stream<String> wordsStream = Arrays.stream(contents);
        int[] elementCounts = target.countElementLength(wordsStream, -1);

    }

}
