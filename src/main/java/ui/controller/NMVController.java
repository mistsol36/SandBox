package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.model.CommentTableModel;
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
    private TextField titleField;

    /** コメントテーブル */
    @FXML
    private TableView<CommentTableModel> commentTable;

    /** UserId */
    @FXML
    private TableColumn userIdColumn;

    /** Comment */
    @FXML
    private TableColumn commentColumn;

    /**
     * OKボタン押下時の動作
     * @param event イベント
     */
    @FXML
    public void handleOK(ActionEvent event) {
        String inputText = movieNoField.getText();
        NicoMovieInfo nicoMovieInfo = new NicoMovieInfo(inputText);

        // 動画タイトル
        titleField.setText(nicoMovieInfo.getTitle());

        // コメントテーブル、使い方は以下サイトを参考
        // ref. http://www.02.246.ne.jp/~torutk/javafx2/table/tableview-memo.html
        userIdColumn.setCellValueFactory(new PropertyValueFactory<CommentTableModel, String>("userId"));
        commentColumn.setCellValueFactory(new PropertyValueFactory<CommentTableModel, String>("comment"));

        // 仮実装
        commentTable.getItems().add(new CommentTableModel("userId1","comment1"));
    }
}
