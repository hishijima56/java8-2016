/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch08.ex06;

import java.awt.geom.Point2D;
import java.util.Comparator;

/**
 * 練習問題08_06
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/14
 */
public class Point2DComparator implements Comparator<Point2D> {

    @Override
    public int compare(Point2D o1, Point2D o2) {
        return Comparator.comparing(Point2D::getX).thenComparing(Point2D::getY).compare(o1, o2);
    }

}
