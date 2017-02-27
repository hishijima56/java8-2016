/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch03.ex02;

import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 練習問題03_02
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/22
 */
public class ReentrantLockEx {

    private ReentrantLockEx(){
    }

    public static void withLock(ReentrantLock myLock, Runnable runnable){
        Objects.requireNonNull(myLock, "myLock is not null.");
        Objects.requireNonNull(runnable, "runnable is not null.");

        if(myLock.isLocked()){
            throw new IllegalStateException("already locked.");
        }

        myLock.lock();
        try{
        runnable.run();
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            myLock.unlock();
        }
    }
}
