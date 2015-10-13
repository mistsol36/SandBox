package comment.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kodama on 2015/10/14.
 */
public class CurrentTimeModel {

    /**
     * 日付のフォーマッター
     */
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

    /**
     * 現在時刻の文字列
     */
    private final StringProperty currentTimeString;

    /**
     * 時刻
     */
    private Date date;

    /**
     * デフォルトコンストラクタ
     */
    public CurrentTimeModel() {
        this.currentTimeString = new SimpleStringProperty();
    }

    /**
     * 時刻を最新化する
     */
    public void update(){
        date = new Date();
        currentTimeString.set(simpleDateFormat.format(date));
    }


    public StringProperty getCurrentTimeString(){
        return  currentTimeString;
    }

}
