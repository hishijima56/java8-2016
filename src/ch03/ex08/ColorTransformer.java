/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch03.ex08;

import javafx.scene.paint.Color;

/**
 * 練習問題03_08
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/27
 */
@FunctionalInterface
public interface ColorTransformer {

    /**
     * apply.
     * @param x
     * @param y
     * @param color
     * @return
     */
    public Color apply(int x, int y, Color color);

}
