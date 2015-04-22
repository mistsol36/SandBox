package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ui.model.NicoMovieInfo;

/**
 * Created by kodama on 2015/04/04.
 */
public class NMVController {

    /** 動画IDフィールド */
    @FXML
    private TextField movieNoField;

    /** 動画タイトルフィールド */
    @FXML
    private Label titleField;

    /**
     * OKボタン押下時の動作
     * @param event イベント
     */
    @FXML
    public void handleOK(ActionEvent event) {
        String inputText = movieNoField.getText();
        NicoMovieInfo nicoMovieInfo = new NicoMovieInfo(inputText);
        titleField.setText(nicoMovieInfo.getTitle());
    }
}
