/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch03.ex01;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

/**
 * 練習問題04_01
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/12/12
 */
public class OriginalLoggerText {

    private Logger logger;

    private OriginalLogger originalLogger;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        logger = Logger.getGlobal();
        logger.setLevel(Level.INFO);
        originalLogger = new OriginalLogger(logger);
    }

    /**
     * {@link ch03.ex01.OriginalLogger#logIf(java.util.logging.Level, java.util.function.BooleanSupplier, java.util.function.Supplier)} のためのテスト・メソッド。
     */
    @Test
    public void testLogIf() {
        String[] a = new String[15];
        a[10] = "loggertest:10";
        int i = 10;
        System.out.println("test");
        originalLogger.logIf(Level.INFO, () -> i == 10 , () -> "a[10] = " + a[10]);
    }

}
