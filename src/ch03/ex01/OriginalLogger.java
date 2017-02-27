/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch03.ex01;

import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 練習問題03_01
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/12/12
 */
public class OriginalLogger {

    /**
     * logger
     */
    private Logger logger;

    /**
     * コンストラクタ
     *
     * @param logger logger
     */
    public OriginalLogger(Logger logger) {
        this.logger = Objects.requireNonNull(logger, "logger is not null");
    }

    /**
     * logIf。
     * @param level
     * @param booleanSupplier
     * @param supplier
     */
    public void logIf(Level level, BooleanSupplier booleanSupplier, Supplier<String> supplier) {
        Objects.requireNonNull(level, "level is not null.");
        Objects.requireNonNull(booleanSupplier, "booleanSupplier is not null.");
        Objects.requireNonNull(supplier, "level is not null.");
        if (!booleanSupplier.getAsBoolean()) {
            return;
        }
        if (logger.isLoggable(level)) {
            logger.log(level, supplier);
        }
    }

}
