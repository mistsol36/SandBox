package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller  implements Initializable {

    public Label label;

    private ViewModel viewModel;

    public void selectOkButton(ActionEvent actionEvent) {
    viewModel.ok();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.viewModel = new ViewModel();
        label.textProperty().bind(viewModel.getLabelValue());
    }

}
