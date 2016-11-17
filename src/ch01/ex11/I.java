/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch01.ex11;

/**
 * 練習問題01_11
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/17
 */
public interface I {

    /**
     *
     */
//    void f();

    /**
     * デフォルトメソッド
     */
    default void f(){
        System.out.println("Interface I#f default.");
    }

    /**
     * staticメソッド
     */
//    static void f(){
//        System.out.println("Interface I#f static.");
//    }
}
