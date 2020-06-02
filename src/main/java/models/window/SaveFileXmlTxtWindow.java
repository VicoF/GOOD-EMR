package models.window;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class SaveFileXmlTxtWindow {
    private String answer;

    public void display(){
        Stage window = new Stage();
        window.setTitle("Choose between Text file or XML file");
        window.setMinWidth(250);
        Label label1 = new Label("Choose between Text file or XML file");

        javafx.scene.control.Button XML = new javafx.scene.control.Button("XML");
        javafx.scene.control.Button txt = new javafx.scene.control.Button("Text");

        VBox layout = new VBox(10);
        layout.getChildren().addAll( XML, txt);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();

        XML.setOnAction(e -> {
            answer = "XML";
            window.close();
        });

        txt.setOnAction(e -> {
            answer = "txt";
            window.close();
        });



        window.show();

    }

    public String getAnswer(){return answer;}
}
