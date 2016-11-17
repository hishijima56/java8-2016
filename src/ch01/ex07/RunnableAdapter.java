/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/
package ch01.ex07;

/**
 * 練習問題01_07
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/16
 */
public class RunnableAdapter {

    /**
     * beforeを実行した後にafterを実行する {@link Runnable}実装クラスを返します。
     * @param before 先に実行される {@link Runnable}
     * @param after 後に実行される {@link Runnable}
     */
    public static Runnable andThen(Runnable before, Runnable after) {

        return () -> {
            Thread beforeThread = new Thread(before);
            Thread afterThread = new Thread(after);
            //beforeを開始
            beforeThread.start();
            try {
                //終了まで待機
                beforeThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //afterを開始
            afterThread.start();
        };
    }

    /**
     * mainメソッドです。
     * @param args 実行時引数
     */
    public static void main(String[] args) {
        Runnable beforeAfter = andThen(() -> {
            for (int i = 1; i <= 1000; i++) {
                System.out.println("before: count " + i);
            }
        }, () -> {
            for (int i = 1; i <= 1000; i++) {
                System.out.println("after: count " + i);
            }
        });

        Thread thread = new Thread(beforeAfter);
        thread.start();

    }
}
