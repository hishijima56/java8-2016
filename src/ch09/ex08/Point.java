/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch09.ex08;

import java.util.Objects;

/**
 * 練習問題09_08
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/03/12
 */
public class Point implements Comparable<Point> {

    private int x;

    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point other) {
        Objects.requireNonNull(other);

        if(this.x < other.x){
            return -1;
        }else if (this.x > other.x){
            return 1;
        }

        if(this.y < other.y){
            return -1;
        }else if(this.y > other.y){
            return 1;
        }

        return 0;
    }

}
