/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch03.ex12;

import java.util.function.UnaryOperator;

import javafx.scene.paint.Color;

/**
 * 練習問題03_12
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

    public static ColorTransformer compose(ColorTransformer ct1, ColorTransformer ct2){
        return (x,y,c) -> ct2.apply(x, y, ct2.apply(x, y, c));
    }

    public static ColorTransformer convertToColorTransformer(UnaryOperator<Color> uop){
        return (x,y,c) -> uop.apply(c);
    }

}
