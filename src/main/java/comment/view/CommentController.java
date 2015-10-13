package comment.view;

import application.Main;
import comment.viewmodel.CommentViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import login.view.LoginController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by kodama on 2015/10/12.
 */
public class CommentController implements Initializable {

    /**
     * instance(singleton)
     */
    private static final CommentController INSTANCE;

    /**
     * Scene(singleton)
     */
    private static final Scene SCENE;
    static {
        FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("comment_view.fxml"));
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

    @FXML
    public Label label;

    /** ビューモデル */
    private CommentViewModel commentViewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.commentViewModel = new CommentViewModel();
        label.textProperty().bind(commentViewModel.currentTimeStringProperty());
    }

    /**
     * singletonのインスタンスを返す
     * @return instance
     */
    public static CommentController getInstance() {
        return INSTANCE;
    }

    /**
     * 表示する
     */
    public void show() {
        Main.stage.setScene(SCENE);
    }

    public void okButton(ActionEvent actionEvent) {
        commentViewModel.updateCurrentDate();
    }

    public void logoutButton(ActionEvent actionEvent) {
        LoginController.getInstance().show();
    }
}
