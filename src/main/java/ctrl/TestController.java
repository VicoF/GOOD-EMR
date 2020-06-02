package ctrl;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TestController {
    @FXML
    ComboBox comboButton;
    @FXML
    Button submitButton;

    Stage window;

    public void submitButtononaction(){
        window.close();
    }



}
