/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch03.ex10;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 * 練習問題03_10
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/27
 */
public class Answer {

    /**
     * mainメソッド.
     * @param args 実行時引数
     */
    public static void main(String[] args) {
        try (FileInputStream fi = new FileInputStream(new File(".\\src\\ch03\\ex05\\Jellyfish.jpg"))) {
            Image image = new Image(fi);
            UnaryOperator<Color> op = Color::brighter;

            /*
             * Q) 下記が呼び出せないのはなぜか？
             * A) op.composeの戻り値型が Function<Color,Color>であるため、tramsformメソッドの引数の型と合わない
             *    Javaは関数合成に関してノミナル型である
             */
//            Image finalImage = transform(image, op.compose(Color::grayscale));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image transform(Image in, UnaryOperator<Color> ct) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();

        WritableImage wi = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                wi.getPixelWriter().setColor(x, y, ct.apply(in.getPixelReader().getColor(x, y)));
            }
        }
        return wi;
    }

}
