/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch03.ex12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 練習問題03_12
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/27
 */
public class ImageTransformView extends Application {

    public static ColorTransformer createColorTransform(Image image, int width, int height, Color color){
        return (x, y, c) -> x < width || x > image.getWidth() - width || y < height || y > image.getHeight() - height ? color : c;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try (FileInputStream fi = new FileInputStream(new File(".\\src\\ch03\\ex12\\Jellyfish.jpg"))) {
            Image image = new Image(fi);
            Image transformedImage = LatentImage.from(image).transform(Color::brighter).transform(createColorTransform(image, 10, 10, Color.GRAY)).toImage();
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
