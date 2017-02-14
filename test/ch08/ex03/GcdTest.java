/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch08.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * {@link Gcd}のテスト・クラスです。
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/13
 */
public class GcdTest {

    private int a, b, expected;

    /**
     * {@link ch08.ex03.Gcd#gcdByPercent(int, int)} のためのテスト・メソッド。
     */
    @Test
    public void testGcdByPercent() {
        a = 120;
        b = 28;
        expected = 4;
        assertEquals(expected, Gcd.gcdByPercent(a, b));
    }

    /**
     * {@link ch08.ex03.Gcd#gcdByPercent(int, int)} のためのテスト・メソッド。
     */
    @Test
    public void testGcdByPercentIfAIsZero() {
        a = 0;
        b = 20;
        expected = b;
        assertEquals(expected, Gcd.gcdByPercent(a, b));
    }

    /**
     * {@link ch08.ex03.Gcd#gcdByPercent(int, int)} のためのテスト・メソッド。
     */
    @Test
    public void testGcdByPercentIfBIsZero() {
        a = 10;
        b = 0;
        expected = a;
        assertEquals(expected, Gcd.gcdByPercent(a, b));
    }

    /**
     * {@link ch08.ex03.Gcd#gcdByPercent(int, int)} のためのテスト・メソッド。
     */
    @Test
    public void testGcdByPercentIfAIsMinus() {
        a = -100;
        b = 28;
        expected = 4;
        assertEquals(expected, Gcd.gcdByPercent(a, b));
    }

    /**
     * {@link ch08.ex03.Gcd#gcdByPercent(int, int)} のためのテスト・メソッド。
     */
    @Test
    public void testGcdByPercentIfBIsMinus() {
        a = 100;
        b = -28;
        expected = 4; //正の数になるはず
        assertEquals(expected, Gcd.gcdByPercent(a, b));
    }

    /**
     * {@link ch08.ex03.Gcd#gcdByPercent(int, int)} のためのテスト・メソッド。
     */
    @Test
    public void testGcdByPercentIfAAndBIsMinus() {
        a = -100;
        b = -28;
        expected = 4; //正の数になるはず
        assertEquals(expected, Gcd.gcdByPercent(a, b));
    }

    /**
     * {@link ch08.ex03.Gcd#gcdByFloorMod(int, int)} のためのテスト・メソッド。
     */
    @Test
    public void testGcdByFloorMod() {
        a = 120;
        b = 28;
        expected = 4;
        assertEquals(expected, Gcd.gcdByFloorMod(a, b));
    }

    /**
     * {@link ch08.ex03.Gcd#gcdByFloorMod(int, int)} のためのテスト・メソッド。
     */
    @Test
    public void testGcdByFloorModAIsZero() {
        a = 0;
        b = 20;
        expected = b;
        assertEquals(expected, Gcd.gcdByFloorMod(a, b));
    }

    /**
     * {@link ch08.ex03.Gcd#gcdByFloorMod(int, int)} のためのテスト・メソッド。
     */
    @Test
    public void testGcdByFloorModBIsZero() {
        a = 10;
        b = 0;
        expected = a;
        assertEquals(expected, Gcd.gcdByFloorMod(a, b));
    }

    /**
     * {@link ch08.ex03.Gcd#gcdByFloorMod(int, int)} のためのテスト・メソッド。
     */
    @Test
    public void testGcdByFloorModAIsMinus() {
        a = -100;
        b = 28;
        expected = 4;
        assertEquals(expected, Gcd.gcdByFloorMod(a, b));
    }

    /**
     * {@link ch08.ex03.Gcd#gcdByFloorMod(int, int)} のためのテスト・メソッド。
     */
    @Test
    public void testGcdByFloorModBIsMinus() {
        a = 100;
        b = -28;
        expected = 4;
        assertEquals(expected, Gcd.gcdByFloorMod(a, b));
    }

    /**
     * {@link ch08.ex03.Gcd#gcdByFloorMod(int, int)} のためのテスト・メソッド。
     */
    @Test
    public void testGcdByFloorModAAndBIsMinus() {
        a = -120;
        b = -28;
        expected = 4;
        assertEquals(expected, Gcd.gcdByFloorMod(a, b));
    }

    /**
     * {@link ch08.ex03.Gcd#gcdByRem(int, int)} のためのテスト・メソッド。
     */
    @Test
    public void testGcdByRem() {
        a = 120;
        b = 28;
        expected = 4;
        assertEquals(expected, Gcd.gcdByRem(a, b));
    }

    /**
     * {@link ch08.ex03.Gcd#gcdByRem(int, int)} のためのテスト・メソッド。
     */
    @Test
    public void testGcdByRemAIsZero() {
        a = 0;
        b = 20;
        expected = b;
        assertEquals(expected, Gcd.gcdByRem(a, b));
    }

    /**
     * {@link ch08.ex03.Gcd#gcdByRem(int, int)} のためのテスト・メソッド。
     */
    @Test
    public void testGcdByRemBIsZero() {
        a = 10;
        b = 0;
        expected = a;
        assertEquals(expected, Gcd.gcdByRem(a, b));
    }

    /**
     * {@link ch08.ex03.Gcd#gcdByRem(int, int)} のためのテスト・メソッド。
     */
    @Test
    public void testGcdByRemAIsMinus() {
        a = -100;
        b = 28;
        expected = 4;
        assertEquals(expected, Gcd.gcdByRem(a, b));
    }

    /**
     * {@link ch08.ex03.Gcd#gcdByRem(int, int)} のためのテスト・メソッド。
     */
    @Test
    public void testGcdByRemBIsMinus() {
        a = 100;
        b = -28;
        expected = 4;
        assertEquals(expected, Gcd.gcdByRem(a, b));
    }

    /**
     * {@link ch08.ex03.Gcd#gcdByRem(int, int)} のためのテスト・メソッド。
     */
    @Test
    public void testGcdByRemAAndBIsMinus() {
        a = -120;
        b = -28;
        expected = 4;
        assertEquals(expected, Gcd.gcdByRem(a, b));
    }

}
