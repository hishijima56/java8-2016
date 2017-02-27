/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch03.ex06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.function.BiFunction;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 練習問題03_06
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/27
 */
public class ImageTransform extends Application {

    public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();

        WritableImage wi = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                wi.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y), arg));
            }
        }
        return wi;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try (FileInputStream fi = new FileInputStream(new File(".\\src\\ch03\\ex06\\Jellyfish.jpg"))) {
            Image image = new Image(fi);
            Image transformedImage = transform(image, (c,factor) -> c.deriveColor(0.0, 1.0, factor, 1.0), 1.2);
            primaryStage.setScene(new Scene(new Pane(new ImageView(transformedImage))));
            primaryStage.show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
