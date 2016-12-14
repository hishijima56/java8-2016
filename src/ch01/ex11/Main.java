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
//        target.f();

        I i = new IAndJImpl();
//        i.f();


        SExtendsIImpl target2 = new SExtendsIImpl();
        target2.f();

        I i2 = new SExtendsIImpl();
//        i2.f();

        S s = new SExtendsIImpl();
        s.f();

    }

}
