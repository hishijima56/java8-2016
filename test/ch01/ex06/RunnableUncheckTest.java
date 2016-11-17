/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch01.ex06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 練習問題01_06
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/16
 */
public class RunnableUncheckTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * {@link ch01.ex06.RunnableUncheck#uncheck(ch01.ex06.RunnableEx)} のためのテスト・メソッド。
     */
    @Test
    public void testUncheckRunnableEx() {
        try {
            Thread thread = new Thread(RunnableUncheck.uncheck(() -> {
                System.out.println("Zzz");
                Thread.sleep(1000);
            }));
            thread.start();
            thread.join();
        } catch (RuntimeException e) {
            fail();
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail();
        }
    }


    /**
     * {@link ch01.ex06.RunnableUncheck#uncheck(java.util.concurrent.Callable)} のためのテスト・メソッド。
     */
    @Test
    public void testUncheckCallableOfVoid() {
        try{
        Thread thread = new Thread(RunnableUncheck.uncheck(() -> {
            System.out.println("Zzz");
            Thread.sleep(1000);
            //nullを返す必要がある
            return null;
        }));
        thread.start();
        thread.join();
        }catch(RuntimeException e){
            fail();
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail();
        }
    }

}
