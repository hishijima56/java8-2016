/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch08.ex02;

/**
 * 練習問題08_02
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/07
 */
public class Main {

    /**
     * mainメソッドです。
     * @param args 実行時引数
     */
    public static void main(String[] args) {

        try{
            //longの最大値ではオーバーフローにならない
            long a = Long.MAX_VALUE;
            System.out.println("a = "+ a);
            long negate = Math.negateExact(a);
            System.out.println("Math.negateExtract("+a+") -> " + negate);

            //longの最小値ではオーバーフローとなる
            a = Long.MIN_VALUE;
            System.out.println("a = "+ a);
            negate = Math.negateExact(a);
            System.out.println("Math.negateExtract("+a+") -> " + negate);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
