/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch02.ex09;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

/**
 * 連取問題02_09
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/18
 */
public class StreamToArrayListConverterTest {

    /**
     * test target
     */
    private StreamToArrayListConverter target;

    /**
     * expected
     */
    private ArrayList<String> expected;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        target = new StreamToArrayListConverter();

        expected = new ArrayList<>();
        expected.add("sample");
        expected.add("test");
        expected.add("arraylist");
        expected.add("aaa");

    }

    /**
     * {@link ch02.ex09.StreamToArrayListConverter#convertToArrayList1(java.util.stream.Stream)} のためのテスト・メソッド。
     */
    @Test
    public void testConvertToArrayList1() {
        ArrayList<String> actual = target.convertToArrayList1(Stream.of(expected));
        assertThat(actual, is(expected));

    }

    /**
     * {@link ch02.ex09.StreamToArrayListConverter#convertToArrayList2(java.util.stream.Stream)} のためのテスト・メソッド。
     */
    @Test
    public void testConvertToArrayList2() {
        ArrayList<String> actual = target.convertToArrayList2(Stream.of(expected));
        assertThat(actual, is(expected));
    }

    /**
     * {@link ch02.ex09.StreamToArrayListConverter#convertToArrayList3(java.util.stream.Stream)} のためのテスト・メソッド。
     */
    @Test
    public void testConvertToArrayList3() {
        ArrayList<String> actual = target.convertToArrayList3(Stream.of(expected));
        assertThat(actual, is(expected));
    }

}
