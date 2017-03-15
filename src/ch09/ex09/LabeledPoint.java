/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch09.ex09;

import java.util.Objects;

/**
 * 練習問題09_09
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/03/12
 */
public class LabeledPoint {

    private String label;

    private int x;

    private int y;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof LabeledPoint)) {
            return false;
        }
        LabeledPoint other = (LabeledPoint) obj;
        return Objects.equals(this.label, other.label) && Objects.equals(this.x, other.x) && Objects.equals(this.y, other.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label,x,y);
    }

}
