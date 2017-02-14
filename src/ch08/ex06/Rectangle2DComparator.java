/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch08.ex06;

import java.awt.geom.Rectangle2D;
import java.util.Comparator;

/**
 * 練習問題08_06
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/14
 */
public class Rectangle2DComparator implements Comparator<Rectangle2D> {

    @Override
    public int compare(Rectangle2D o1, Rectangle2D o2) {
        return Comparator.comparing(Rectangle2D::getX).thenComparing(Rectangle2D::getY).thenComparing(Rectangle2D::getWidth)
                .thenComparing(Rectangle2D::getHeight).compare(o1, o2);
    }

}
