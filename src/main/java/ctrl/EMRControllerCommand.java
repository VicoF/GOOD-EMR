package ctrl;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.composants.EMRShape;

import java.io.IOException;

public class EMRControllerCommand {
    Stage window;

    public void display() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/test.fxml"));

        window.setTitle("Hello World");
        window.setScene(new Scene(root, 300, 275));
        window.show();
    }



}
