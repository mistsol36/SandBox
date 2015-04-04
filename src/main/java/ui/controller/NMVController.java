package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ui.model.NicoMovie;

/**
 * Created by kodama on 2015/04/04.
 */
public class NMVController {

    /** 動画IDフィールド */
    @FXML
    private TextField smNoField;

    /** 動画タイトルフィールド */
    @FXML
    private Label titleField;

    /**
     * Oボタン押下時の動作
     * @param event イベント
     */
    @FXML
    public void handleOK(ActionEvent event) {
        String inputText = smNoField.getText();
        NicoMovie nicoMovie = new NicoMovie(inputText);
        titleField.setText(nicoMovie.title());
    }
}
