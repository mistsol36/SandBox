package comment.viewmodel;

import comment.model.CurrentTimeModel;
import javafx.beans.property.StringProperty;

/**
 * Created by kodama on 2015/10/12.
 */
public class CommentViewModel {

    private CurrentTimeModel currentTimeModel;

    public CommentViewModel(){
        this.currentTimeModel = new CurrentTimeModel();
    }

    public StringProperty currentTimeStringProperty() {
        return currentTimeModel.getCurrentTimeString();
    }

    public void updateCurrentDate() {
        currentTimeModel.update();
    }
}
