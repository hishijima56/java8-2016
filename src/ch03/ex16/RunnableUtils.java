/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch03.ex16;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 練習問題03_16
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/28
 */
public class RunnableUtils {

    private RunnableUtils() {
    }

    public static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second, Consumer<Throwable> handler) {

        Thread t = new Thread(() -> {

            Throwable t1 = null;
            T result = null;
            try {
                result = first.get();
            } catch (Throwable e1) {
                t1 = e1;
                try {
                    second.accept(null, e1);
                } catch (Throwable e2) {
                    handler.accept(e2);
                }
            }
            if (t1 == null) {
                try {
                    second.accept(result, null);
                } catch (Throwable e2) {
                    handler.accept(e2);
                }
            }

        });
        t.start();
    }

    public static void main(String[] args) {
        try {
            doInOrderAsync(() -> {
                return "test";
            }, (t, e) -> {
                System.out.println(t);
            }, e -> {
                e.printStackTrace();
            });
            Thread.sleep(1000);
            doInOrderAsync(() -> {
                throw new RuntimeException("first throw exception");
            }, (t, e) -> {
                System.out.println("Exception message : " + e.getMessage());
            }, e -> {
                e.printStackTrace();
            });
            Thread.sleep(1000);
            doInOrderAsync(() -> {
                throw new RuntimeException("first throw exception");
            }, (t, e) -> {
                throw new RuntimeException("second throw exception");
            }, e -> {
                System.out.println(e.getMessage());
            });
            Thread.sleep(1000);
            doInOrderAsync(() -> {
                return "test";
            }, (t, e) -> {
                System.out.println(t);
                throw new RuntimeException("second throw exception");
            }, e -> {
                System.out.println(e.getMessage());
            });
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

}
