package login.view;

import application.Main;
import comment.view.CommentController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends AnchorPane implements Initializable {

    /**
     * instance(singleton)
     */
    private static final LoginController INSTANCE;

    /**
     * Scene(singleton)
     */
    private static final Scene SCENE;
    static {
        FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("login_view.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException e) {

            // loggerを使って何かしら出すほうがいいですね。手抜きですみません
            e.printStackTrace();
        }
        Parent parent = fxmlLoader.getRoot();
        Scene s = new Scene(parent);
        // s.setFill(Color.TRANSPARENT);
        SCENE = s;
        INSTANCE = fxmlLoader.getController();
    }

    /**
     * singletonのインスタンスを返す
     * @return instance
     */
    public static LoginController getInstance() {
        return INSTANCE;
    }

    /**
     * 表示する
     */
    public void show() {
        Main.stage.setScene(SCENE);
    }

    @FXML
    public TextField idTextField;

    @FXML
    public TextField passTextField;

    public void okButton(ActionEvent actionEvent) {
        CommentController.getInstance().show();
    }

    public void cancelButton(ActionEvent actionEvent) {
        
    }

    public void onIdKeyPressed(Event event) {
        
    }

    public void onPassKeyPressed(Event event) {

    }

    public void initialize(URL location, ResourceBundle resources) {

    }

}
