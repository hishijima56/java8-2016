/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch09.ex10;

import java.util.Objects;

/**
 * 練習問題09_10
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/03/12
 */
public class LabeledPoint implements Comparable<LabeledPoint> {

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

    @Override
    public int compareTo(LabeledPoint other) {
        Objects.requireNonNull(other, "other is not null.");
        int result = 0;
        //xを比較する
        result = Integer.compare(this.x, other.x);
        if(result != 0){
            return result;
        }
        //yを比較する
        result = Integer.compare(this.y, other.y);
        //最後にlabelを比較する
        return result != 0 ? result : this.label == null ? 1 : this.label.compareTo(other.label);
    }

}
