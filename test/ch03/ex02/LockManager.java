/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch03.ex02;

import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

/**
 * 練習問題03_02
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/12/12
 */
public class LockManager {

    public static void withLock(ReentrantLock lock, Consumer<?> consumer){
        lock.lock();
        try{
            consumer.accept(null);
        }finally{
            lock.unlock();
        }
    }

}
