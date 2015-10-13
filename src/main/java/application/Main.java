package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import login.view.LoginController;

/**
 * 参考：http://qiita.com/mix/items/7c797eccad0a5e3a43c3
 */
public class Main extends Application {

    public static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.stage = primaryStage;

        // タイトル
        stage.setTitle("Sample");

        // sceneの作成(nullですので中身ないです)
        Scene scene = new Scene(new Pane());
        stage.setScene(scene);

        // 最初の画面
        LoginController.getInstance().show();

        // 表示
        stage.show();
    }

}
