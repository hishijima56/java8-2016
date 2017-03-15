/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch09.ex08;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 練習問題09_08
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/03/12
 */
public class PointTest {

    Point target1, target2;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        target1 = new Point(10, 20);
    }

    /**
     * {@link ch09.ex08.Point#compareTo(ch09.ex08.Point)} のためのテスト・メソッド。
     */
    @Test(expected = NullPointerException.class)
    public void testCompareToOtherIsNull() {
        target1.compareTo(null);
    }

    /**
     * {@link ch09.ex08.Point#compareTo(ch09.ex08.Point)} のためのテスト・メソッド。
     */
    @Test
    public void testCompareToOtherEqual() {
        assertEquals(0, target1.compareTo(target1));
    }

    /**
     * {@link ch09.ex08.Point#compareTo(ch09.ex08.Point)} のためのテスト・メソッド。
     */
    @Test
    public void testCompareToOtherXLow() {
        target2 = new Point(9,20);
        assertEquals(1, target1.compareTo(target2));
    }

    /**
     * {@link ch09.ex08.Point#compareTo(ch09.ex08.Point)} のためのテスト・メソッド。
     */
    @Test
    public void testCompareToOtherXHigh() {
        target2 = new Point(11,20);
        assertEquals(-1, target1.compareTo(target2));
    }

    /**
     * {@link ch09.ex08.Point#compareTo(ch09.ex08.Point)} のためのテスト・メソッド。
     */
    @Test
    public void testCompareToOtherYLow() {
        target2 = new Point(10,19);
        assertEquals(1, target1.compareTo(target2));
    }

    /**
     * {@link ch09.ex08.Point#compareTo(ch09.ex08.Point)} のためのテスト・メソッド。
     */
    @Test
    public void testCompareToOtherYHigh() {
        target2 = new Point(10,21);
        assertEquals(-1, target1.compareTo(target2));
    }

    /**
     * {@link ch09.ex08.Point#compareTo(ch09.ex08.Point)} のためのテスト・メソッド。
     */
    @Test
    public void testCompareToOtherXYEqual() {
        target2 = new Point(10,20);
        assertEquals(0, target1.compareTo(target2));
    }

}
