/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch04.ex01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 練習問題04_01
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/12/11
 */
public class Ex01Application extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        Label label = new Label();
        label.setFont(new Font(100));
        TextField text = new TextField();
        label.textProperty().bind(text.textProperty());
        text.setText("Hello, FX");
        pane.add(label, 0, 0);
        pane.add(text, 0, 1);
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("ch04.ex01");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
