package ctrl;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import models.composants.EMRCategories;
import models.composants.EMRShape;
import models.composants.InversionAccumulationShape;
import models.composants.InversionConversionShape;
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
        shapes.add(new InversionAccumulationShape(EMRCategories.INVERSION_BASED,event.getX(),event.getY()));
        GraphicsContext gc = canva.getGraphicsContext2D();
        for (EMRShape s:shapes) {

            gc.setFill(s.getCategorie().backgroundColor);
            gc.setStroke(s.getCategorie().borderColor);


            gc.fillPolygon(s.getXCoords(),s.getYCoords(),s.getXCoords().length);
            gc.strokePolygon(s.getXCoords(),s.getYCoords(),s.getXCoords().length);
            System.out.println("forme dessinée:");
            for(int i=0;i<s.getYCoords().length;i++){
                System.out.println("("+s.getXCoords()[i]+", "+s.getYCoords()[i]+")");
            }

        }

    }


}
