/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch04.ex06;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 練習問題04_06
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/12/13
 */
public class BorderPaneSceneEx extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane borderPane = new BorderPane();

        Button topButton = new Button("Top");
        Button leftButton = new Button("Left");
        Button centerButton = new Button("Center");
        Button rightButton = new Button("Right");
        Button buttomButton = new Button("Buttom");

        borderPane.setTop(topButton);
        borderPane.setLeft(leftButton);
        borderPane.setCenter(centerButton);
        borderPane.setRight(rightButton);
        borderPane.setBottom(buttomButton);

        //位置合わせを行う
        BorderPane.setAlignment(topButton, Pos.CENTER);
        BorderPane.setAlignment(buttomButton, Pos.CENTER);
        BorderPane.setAlignment(leftButton, Pos.CENTER_LEFT);
        BorderPane.setAlignment(rightButton, Pos.CENTER_RIGHT);

        primaryStage.setScene(new Scene(borderPane));

        primaryStage.setTitle("ButtonCenter");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
