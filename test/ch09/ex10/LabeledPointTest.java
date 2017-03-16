/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch09.ex10;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 練習門愛09_10
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/03/15
 */
public class LabeledPointTest {

    LabeledPoint target1,target2;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        target1 = new LabeledPoint();
        target1.setLabel("test");
        target1.setX(10);
        target1.setY(20);
    }

    /**
     * {@link ch09.ex10.LabeledPoint#compareTo(ch09.ex10.LabeledPoint)} のためのテスト・メソッド。
     */
    @Test(expected=NullPointerException.class)
    public void testCompareToNull() {
        target1.compareTo(null);
    }

    /**
     * {@link ch09.ex10.LabeledPoint#compareTo(ch09.ex10.LabeledPoint)} のためのテスト・メソッド。
     */
    @Test
    public void testCompareToItself() {
        assertEquals(0, target1.compareTo(target1));
    }

    /**
     * {@link ch09.ex10.LabeledPoint#compareTo(ch09.ex10.LabeledPoint)} のためのテスト・メソッド。
     */
    @Test
    public void testCompareToXLow() {
        target2 = new LabeledPoint();
        target2.setLabel(target1.getLabel());
        target2.setX(target1.getX()+1);
        target2.setY(target1.getY());
        assertEquals(-1, target1.compareTo(target2));
    }

    /**
     * {@link ch09.ex10.LabeledPoint#compareTo(ch09.ex10.LabeledPoint)} のためのテスト・メソッド。
     */
    @Test
    public void testCompareToXHigh() {
        target2 = new LabeledPoint();
        target2.setLabel(target1.getLabel());
        target2.setX(target1.getX()-1);
        target2.setY(target1.getY());
        assertEquals(1, target1.compareTo(target2));
    }

    /**
     * {@link ch09.ex10.LabeledPoint#compareTo(ch09.ex10.LabeledPoint)} のためのテスト・メソッド。
     */
    @Test
    public void testCompareToYLow() {
        target2 = new LabeledPoint();
        target2.setLabel(target1.getLabel());
        target2.setX(target1.getX());
        target2.setY(target1.getY()+1);
        assertEquals(-1, target1.compareTo(target2));
    }

    /**
     * {@link ch09.ex10.LabeledPoint#compareTo(ch09.ex10.LabeledPoint)} のためのテスト・メソッド。
     */
    @Test
    public void testCompareToYHigh() {
        target2 = new LabeledPoint();
        target2.setLabel(target1.getLabel());
        target2.setX(target1.getX());
        target2.setY(target1.getY()-1);
        assertEquals(1, target1.compareTo(target2));
    }

    /**
     * {@link ch09.ex10.LabeledPoint#compareTo(ch09.ex10.LabeledPoint)} のためのテスト・メソッド。
     */
    @Test
    public void testCompareToLabelNull() {
        target2 = new LabeledPoint();
        target2.setLabel(target1.getLabel());
        target2.setX(target1.getX());
        target2.setY(target1.getY());
        target1.setLabel(null);
        assertEquals(1, target1.compareTo(target2));
    }

    /**
     * {@link ch09.ex10.LabeledPoint#compareTo(ch09.ex10.LabeledPoint)} のためのテスト・メソッド。
     */
    @Test
    public void testCompareToLabelAsc() {
        target2 = new LabeledPoint();
        target2.setLabel("tesu");
        target2.setX(target1.getX());
        target2.setY(target1.getY());
        assertEquals(-1, target1.compareTo(target2));
    }

    /**
     * {@link ch09.ex10.LabeledPoint#compareTo(ch09.ex10.LabeledPoint)} のためのテスト・メソッド。
     */
    @Test
    public void testCompareToLabelDesc() {
        target2 = new LabeledPoint();
        target2.setLabel("tess");
        target2.setX(target1.getX());
        target2.setY(target1.getY());
        assertEquals(1, target1.compareTo(target2));
    }

    /**
     * {@link ch09.ex10.LabeledPoint#compareTo(ch09.ex10.LabeledPoint)} のためのテスト・メソッド。
     */
    @Test
    public void testCompareToAllFieldsEquals() {
        target2 = new LabeledPoint();
        target2.setLabel(target1.getLabel());
        target2.setX(target1.getX());
        target2.setY(target1.getY());
        assertEquals(0, target1.compareTo(target2));
    }

}
