/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch04.ex07;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 練習問題04_07
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/28
 */
public class BorderDemo extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane pane = new GridPane();
        Label label = new Label("text label");
        Button button = new Button("button");
        TextField text = new TextField();
        label.setFont(new Font(30));
        button.setBorder(new Border(new BorderStroke(Paint.valueOf("green"),BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        pane.add(label, 0,0);
        pane.add(button, 0,1);
        pane.add(text, 0,2);

        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setHalignment(label, HPos.CENTER);

        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("ch04.ex07");
        primaryStage.show();

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}
