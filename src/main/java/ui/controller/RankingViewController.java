package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ui.model.CommentTableModel;
import ui.model.NicoLiveInfo;
import ui.model.NicoLiveRanking;
import ui.model.NicoMovieInfo;

import java.util.List;

/**
 * Created by mist on 2015/08/19.
 */
public class RankingViewController {

    /** 画像1 */
    @FXML
    private ImageView image1;

    /** 画像1 */
    @FXML
    private ImageView image2;

    /** 画像1 */
    @FXML
    private ImageView image3;

    /** 画像1 */
    @FXML
    private ImageView image4;

    /** 画像1 */
    @FXML
    private ImageView image5;

    /** タイトル1 */
    @FXML
    private Hyperlink title1;

    /** タイトル2 */
    @FXML
    private Hyperlink title2;

    /** タイトル3 */
    @FXML
    private Hyperlink title3;

    /** タイトル4 */
    @FXML
    private Hyperlink title4;

    /** タイトル5 */
    @FXML
    private Hyperlink title5;

    /**
     * OKボタン押下時の動作
     * @param event イベント
     */
    @FXML
    public void handleUpdate(ActionEvent event) {
        List<NicoLiveInfo> list = new NicoLiveRanking().javaList();

        NicoLiveInfo nicoLiveInfo1 = list.get(0);
        title1.setText(nicoLiveInfo1.title());
        image1.setImage(new Image(nicoLiveInfo1.thumbnailSmallUrl()));

        NicoLiveInfo nicoLiveInfo2 = list.get(1);
        title2.setText(nicoLiveInfo2.title());
        image2.setImage(new Image(nicoLiveInfo2.thumbnailSmallUrl()));

        NicoLiveInfo nicoLiveInfo3 = list.get(2);
        title3.setText(nicoLiveInfo3.title());
        image3.setImage(new Image(nicoLiveInfo3.thumbnailSmallUrl()));

        NicoLiveInfo nicoLiveInfo4 = list.get(3);
        title4.setText(nicoLiveInfo4.title());
        image4.setImage(new Image(nicoLiveInfo4.thumbnailSmallUrl()));

        NicoLiveInfo nicoLiveInfo5 = list.get(4);
        title5.setText(nicoLiveInfo5.title());
        image5.setImage(new Image(nicoLiveInfo5.thumbnailSmallUrl()));
    }

}
