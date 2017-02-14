/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch08.ex03;

/**
 * 練習問題08_03
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/11
 */
public class Gcd {

    public static int gcdByPercent(int a, int b){
        return  b == 0 ? a : b > 0 ? gcdByPercent(b, a%b) : gcdByPercent((0-b), a%(0-b));
    }

    public static int gcdByFloorMod(int a, int b){
        return  b == 0 ? a : b > 0 ? gcdByFloorMod(b, Math.floorMod(a,b)) : gcdByFloorMod((0-b), Math.floorMod(a,(0-b)));
    }

    public static int gcdByRem(int a, int b){
        return b == 0 ? a :gcdByRem(b, rem(a,b));
    }

    private static int rem(int b, int a) {
        return Math.abs(b) % Math.abs(a);
    }

}
