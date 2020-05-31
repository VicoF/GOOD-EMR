package ctrl;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import models.composants.*;
import javafx.scene.paint.Color;



import java.util.ArrayList;

public class EMRController {

    @FXML
    Canvas canva;

    @FXML
    BorderPane pane;

    ArrayList<EMRShape> shapes;

    public EMRController() {
        shapes = new ArrayList<>();
    }

    @FXML
    public void initialize(){
        GraphicsContext gc = canva.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,canva.getWidth(),canva.getHeight());
    }

    @FXML
    public void onCanvaClicked(MouseEvent event){
        switch(event.getButton()) {
            case PRIMARY:
                shapes.add(new InversionCouplingShape(EMRCategories.INVERSION_BASED,event.getX(),event.getY()));
                break;
            case SECONDARY:
                shapes.add(new InversionAccumulationShape(EMRCategories.INVERSION_BASED,event.getX(),event.getY()));
                break;
            case MIDDLE:
                shapes.add(new InversionConversionShape(EMRCategories.INVERSION_BASED,event.getX(),event.getY()));
                break;
        }
        GraphicsContext gc = canva.getGraphicsContext2D();
        for (EMRShape s:shapes) {

            s.draw(gc);

        }

    }


}
