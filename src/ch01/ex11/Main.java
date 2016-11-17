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
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        IAndJImpl target = new IAndJImpl();
        target.f();

        SExtendsIImpl target2 = new SExtendsIImpl();
        target2.f();

    }

}
