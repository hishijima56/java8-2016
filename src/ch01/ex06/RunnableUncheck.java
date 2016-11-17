/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch01.ex06;

import java.util.concurrent.Callable;

/**
 * 練習問題01_06
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/17
 */
public class RunnableUncheck {

    /**
     * チェック例外を非チェック例外に変更してスローします。
     * @param runnableEx {@link RunnableEx}インタフェース
     * @return {@link Runnable}
     */
    public static Runnable uncheck(RunnableEx runnableEx) {
        return () -> {

            try {
                runnableEx.run();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        };
    }

    /**
     * チェック例外を非チェック例外に変更してスローします。
     * @param callable {@link Callable}インタフェース
     * @return {@link Runnable}
     */
    public static Runnable uncheck(Callable<Void> callable) {
        return () -> {
            try {
                callable.call();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        };
    }

}
