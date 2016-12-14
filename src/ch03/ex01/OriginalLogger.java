/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch03.ex01;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

/**
 * 練習問題03_01
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/12/12
 */
public class OriginalLogger {

    private Logger logger;

    public OriginalLogger() {
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.addHandler(new StreamHandler(){
            {
                setOutputStream(System.out);
            }});
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);

    }

    public void logIf(Level level, BooleanSupplier booleanSupplier, Supplier<String> supplier) {
        if (booleanSupplier.getAsBoolean()) {
            logger.log(level, supplier);
        }
    }

}
