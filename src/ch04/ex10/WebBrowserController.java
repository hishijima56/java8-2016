/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch04.ex10;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * 練習問題04_10
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/12/14
 */
public class WebBrowserController extends Application implements Initializable {

    private static final String DEFAULT_URL = "http://www.google.com";

    @FXML
    private TextField urlText;

    @FXML
    private Button backButton;

    @FXML
    private WebView webBrowser;

    private WebEngine webEngine;

    private WebHistory history;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("webbrowser.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        webEngine = webBrowser.getEngine();
        history = webEngine.getHistory();
        urlText.textProperty().bind(webEngine.locationProperty());
        webEngine.load(DEFAULT_URL);
    }

    @FXML
    public void onEnter(Event e){
        System.out.println(urlText.getText());
        String url = urlText.getText();
        if(url != null && !url.trim().isEmpty()){
            System.out.println("webEngine load");
            webEngine.load(url);
            urlText.setText(url);
        }

    }

    @FXML
    public void backButtonClicked(Event e){
        System.out.println("backButton clicked");
        if(history != null && history.getEntries().size() > 1){
            System.out.println("here");
            history.go(-1);
        }

    }



}
