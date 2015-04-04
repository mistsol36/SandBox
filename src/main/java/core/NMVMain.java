package core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by kodama on 2015/04/04.
 */
public class NMVMain extends Application {

    /**
     * main
     *
     * @param args 引数
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("NicoMovieViewer");

        AnchorPane root = FXMLLoader.load(getClass().getResource("../ui/view/nico_movie_viewer.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }
}
