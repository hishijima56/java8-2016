/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch08.ex01;

/**
 * 練習問題08_01
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/13
 */
public class UnsignedInt {

    public static void main(String[] args) {

       int a = Integer.MAX_VALUE;

       int b = Integer.MAX_VALUE + Integer.MAX_VALUE;

       System.out.println("---add---");
       System.out.println("int      ･･･ " + (a+a));
       System.out.println("unsigned ･･･ " + Integer.toUnsignedLong(a+a));
       System.out.println("---end add---");
       System.out.println("---sub---");
       System.out.println("int      ･･･ " + (b-1000));
       System.out.println("unsigned ･･･ " + Integer.toUnsignedLong(b-1000));
       System.out.println("---end sub---");
       System.out.println("---divide---");
       System.out.println("int      ･･･ " + (b/a));
       System.out.println("unsigned ･･･ " + Integer.divideUnsigned(b, a));
       System.out.println("---end divide---");
       System.out.println("---compare---");
       System.out.println("int      ･･･ " + Integer.compare(a,b));
       System.out.println("unsigned ･･･ " + Integer.compareUnsigned(a,b));
       System.out.println("---end compare---");
       System.out.println("---remainder---");
       System.out.println("int      ･･･ " + (b%a));
       System.out.println("unsigned ･･･ " + Integer.remainderUnsigned(b, a));
       System.out.println("---end remainder---");
    }
}
