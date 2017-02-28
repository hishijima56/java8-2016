/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch04.ex02;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 練習問題04_02
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/28
 */
public class GreetingEx extends Application {

    private String text;

    private StringProperty textProperty;

    public GreetingEx() {
        this.text = null;
        this.textProperty = null;
    }

    public final StringProperty textProperty(){
        if(this.textProperty == null){
            this.textProperty = new SimpleStringProperty();
        }
        this.textProperty.set(text);
        return this.textProperty;
    }

    public final void setText(String text){
        this.text = text;
    }

    public final String getText(){
        return this.text;
    }

    /**
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        GreetingEx instance = new GreetingEx();
        instance.setText("test text");
        GridPane pane = new GridPane();
        Label label = new Label();
        label.setFont(new Font(50));
        TextField text = new TextField();

        System.out.println("textProperty is null ? : " + (instance.textProperty == null));

        label.textProperty().bind(instance.textProperty());

        System.out.println("textProperty is null ? : " + (instance.textProperty == null));

        pane.add(label, 0, 0);
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("ch04.ex02");
        primaryStage.show();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        launch(args);

    }

}
