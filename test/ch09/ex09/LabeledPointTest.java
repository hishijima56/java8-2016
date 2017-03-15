/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch09.ex09;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 練習問題09_09
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/03/12
 */
public class LabeledPointTest {

    /**
     * テスト対象クラス
     */
    private LabeledPoint target1,target2;

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
     * {@link ch09.ex09.LabeledPoint#hashCode()} のためのテスト・メソッド。
     */
    @Test
    public void testHashCodeItselfEqual() {
        assertEquals(target1.hashCode(), target1.hashCode());
    }

    /**
     * {@link ch09.ex09.LabeledPoint#hashCode()} のためのテスト・メソッド。
     */
    @Test
    public void testHashCodeFieldsEqual() {
        target2 = new LabeledPoint();
        target2.setLabel(target1.getLabel());
        target2.setX(target1.getX());
        target2.setY(target1.getY());
        assertEquals(target2.hashCode(), target1.hashCode());
    }

    /**
     * {@link ch09.ex09.LabeledPoint#hashCode()} のためのテスト・メソッド。
     */
    @Test
    public void testHashCodeLabelNotEqual() {
        target2 = new LabeledPoint();
        target2.setLabel(target1.getLabel() + "test");
        target2.setX(target1.getX());
        target2.setY(target1.getY());
        assertNotEquals(target2.hashCode(), target1.hashCode());
    }

    /**
     * {@link ch09.ex09.LabeledPoint#hashCode()} のためのテスト・メソッド。
     */
    @Test
    public void testHashCodeXNotEqual() {
        target2 = new LabeledPoint();
        target2.setLabel(target1.getLabel());
        target2.setX(target1.getX()+1);
        target2.setY(target1.getY());
        assertNotEquals(target2.hashCode(), target1.hashCode());
    }

    /**
     * {@link ch09.ex09.LabeledPoint#hashCode()} のためのテスト・メソッド。
     */
    @Test
    public void testHashCodeYNotEqual() {
        target2 = new LabeledPoint();
        target2.setLabel(target1.getLabel());
        target2.setX(target1.getX());
        target2.setY(target1.getY()+1);
        assertNotEquals(target2.hashCode(), target1.hashCode());
    }

    /**
     * {@link ch09.ex09.LabeledPoint#hashCode()} のためのテスト・メソッド。
     */
    @Test
    public void testHashCodeAllFieldsNotEqual() {
        target2 = new LabeledPoint();
        target2.setLabel(target1.getLabel()+"test");
        target2.setX(target1.getX()+1);
        target2.setY(target1.getY()+1);
        assertNotEquals(target2.hashCode(), target1.hashCode());
    }

    /**
     * {@link ch09.ex09.LabeledPoint#equals(java.lang.Object)} のためのテスト・メソッド。
     */
    @Test
    public void testEqualsObject() {
        target2 = new LabeledPoint();
        target2.setLabel(target1.getLabel());
        target2.setX(target1.getX());
        target2.setY(target1.getY());
        assertEquals(true, target1.equals(target2));
    }

    /**
     * {@link ch09.ex09.LabeledPoint#equals(java.lang.Object)} のためのテスト・メソッド。
     */
    @Test
    public void testEqualsNull() {
        assertEquals(false, target1.equals(null));
    }

    /**
     * {@link ch09.ex09.LabeledPoint#equals(java.lang.Object)} のためのテスト・メソッド。
     */
    @Test
    public void testEqualsItSelf() {
        assertEquals(true, target1.equals(target1));
    }

    /**
     * {@link ch09.ex09.LabeledPoint#equals(java.lang.Object)} のためのテスト・メソッド。
     */
    @Test
    public void testEqualsOtherIsNotLabeledPointClass() {
        assertEquals(false, target1.equals(new Object()));
    }

    /**
     * {@link ch09.ex09.LabeledPoint#equals(java.lang.Object)} のためのテスト・メソッド。
     */
    @Test
    public void testEqualsOtherLabeldIsNotEqual() {
        target2 = new LabeledPoint();
        target2.setLabel(target1.getLabel()+"test");
        target2.setX(target1.getX());
        target2.setY(target1.getY());
        assertEquals(false, target1.equals(target2));
    }

    /**
     * {@link ch09.ex09.LabeledPoint#equals(java.lang.Object)} のためのテスト・メソッド。
     */
    @Test
    public void testEqualsOtherXIsNotEqual() {
        target2 = new LabeledPoint();
        target2.setLabel(target1.getLabel());
        target2.setX(target1.getX()+1);
        target2.setY(target1.getY());
        assertEquals(false, target1.equals(target2));
    }

    /**
     * {@link ch09.ex09.LabeledPoint#equals(java.lang.Object)} のためのテスト・メソッド。
     */
    @Test
    public void testEqualsOtherYIsNotEqual() {
        target2 = new LabeledPoint();
        target2.setLabel(target1.getLabel());
        target2.setX(target1.getX());
        target2.setY(target1.getY()+1);
        assertEquals(false, target1.equals(target2));
    }

    /**
     * {@link ch09.ex09.LabeledPoint#equals(java.lang.Object)} のためのテスト・メソッド。
     */
    @Test
    public void testEqualsObjectAllFieldsIsNotEqual() {
        target2 = new LabeledPoint();
        target2.setLabel(target1.getLabel()+"test");
        target2.setX(target1.getX()+1);
        target2.setY(target1.getY()+1);
        assertEquals(false, target1.equals(target2));
    }
}
