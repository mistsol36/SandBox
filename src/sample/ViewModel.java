package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by mist36 on 2015/10/14.
 */
public class ViewModel {

    private final StringProperty labelValue;

    public ViewModel(){
        this.labelValue = new SimpleStringProperty("0");
    }

    public StringProperty getLabelValue() {
        return labelValue;
    }

    public void ok(){
        labelValue.set(String.valueOf(Integer.valueOf(labelValue.get())+1));
    }

}
