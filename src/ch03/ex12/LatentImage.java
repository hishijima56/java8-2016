/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch03.ex12;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 * 練習問題03_12
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/28
 */
public class LatentImage {

    private Image in;

    private List<ColorTransformer> pendingOperations;

    private LatentImage(){
    }

    public static LatentImage from(Image image){
        Objects.requireNonNull(image, "image is not null.");
        LatentImage instance = new LatentImage();
        instance.in = image;
        instance.pendingOperations = new ArrayList<>();
        return instance;
    }

    public LatentImage transform(UnaryOperator<Color> f){
        Objects.requireNonNull(f, "operator is not null.");
        this.pendingOperations.add(ColorTransformer.convertToColorTransformer(f));
        return this;
    }

    public LatentImage transform(ColorTransformer ct){
        Objects.requireNonNull(ct, "ColorTransformer is not null.");
        this.pendingOperations.add(ct);
        return this;
    }

    public Image toImage(){
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for(int x = 0 ; x < width ; x++){
            for(int y = 0 ;y < height ; y++){
                Color c = in.getPixelReader().getColor(x, y);
                for(ColorTransformer ct : pendingOperations){
                    c = ct.apply(x, y, c);
                }
                out.getPixelWriter().setColor(x, y, c);
            }
        }
        return out;
    }


}
