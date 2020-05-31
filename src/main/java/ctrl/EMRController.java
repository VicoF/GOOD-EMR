package ctrl;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

import javafx.scene.paint.Color;
import models.composants.EMRCategories;
import models.composants.EMRShape;
import models.composants.EMRShapeFactory;
import models.composants.InversionAccumulationShape;
import models.composants.InversionConversionShape;
import models.composants.InversionCouplingShape;


import java.util.ArrayList;


public class EMRController {

    @FXML
    Canvas canva;

    @FXML
    Accordion accordion;

    @FXML
    FlowPane energyBasedPane;
    @FXML
    FlowPane inversionBasedPane;
    @FXML
    FlowPane strategyBasedPane;
    @FXML
    FlowPane estimatorBasedPane;

    @FXML
    Canvas inversionAccumulationCanva;

    @FXML
    Canvas inversionCouplingCanva;

    @FXML
    Canvas inversionConversionCanva;

    @FXML
    BorderPane pane;

    ArrayList<EMRShape> shapes;

    EMRShape draggedShape = null;

    public EMRController() {
        shapes = new ArrayList<>();
    }


    public void initialize() {
        GraphicsContext gc = canva.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canva.getWidth(), canva.getHeight());
        Canvas currentCanva = inversionAccumulationCanva;
        EMRShape s = EMRShapeFactory.getComposant(EMRShapeFactory.EMRShapeType.INVERSION_ACCUMULATION,EMRCategories.INVERSION_BASED, (int) (currentCanva.getWidth()/2),(int) (currentCanva.getHeight()/2));
        s.draw(currentCanva.getGraphicsContext2D());
        currentCanva = inversionConversionCanva;
        s = EMRShapeFactory.getComposant(EMRShapeFactory.EMRShapeType.INVERSION_CONVERSION,EMRCategories.INVERSION_BASED,(int) (currentCanva.getWidth()/2),(int) (currentCanva.getHeight()/2));
        s.draw(currentCanva.getGraphicsContext2D());
        currentCanva = inversionCouplingCanva;
        s = EMRShapeFactory.getComposant(EMRShapeFactory.EMRShapeType.INVERSION_COUPLING,EMRCategories.INVERSION_BASED,(int) (currentCanva.getWidth()/2),(int) (currentCanva.getHeight()/2));
        s.draw(currentCanva.getGraphicsContext2D());

        inversionCouplingCanva.setOnDragDetected(event->{
            /* drag was detected, start drag-and-drop gesture*/
            System.out.println("onDragDetected");

            /* allow any transfer mode */
            Dragboard db = inversionCouplingCanva.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString("COOL:)");
            db.setContent(content);
            draggedShape = EMRShapeFactory.getComposant(EMRShapeFactory.EMRShapeType.INVERSION_COUPLING,EMRCategories.INVERSION_BASED,0,0);


            event.consume();
        });


        canva.setOnDragOver(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* data is dragged over the target */
                System.out.println("onDragOver");
                // On retire la shape que l'on drag de la liste
                shapes.remove(draggedShape);
                //On met à jour ses données
                draggedShape.setPosX(event.getX());
                draggedShape.setPosY(event.getY());
                //On la remet dans la liste
                shapes.add(draggedShape);
                // On redessine
               redrawCanva();

                event.consume();
            }
        });



    }

    @FXML
    public void onTitledPaneClicked(MouseEvent event) {
        System.out.println("allooo");
        TitledPane expandedPane = accordion.getExpandedPane();

        if (expandedPane != null) {
            FlowPane currentPane = (FlowPane) expandedPane.getContent();
           energyBasedPane.getChildren().add(EMRShapeFactory.getComposant(EMRShapeFactory.EMRShapeType.INVERSION_ACCUMULATION,EMRCategories.INVERSION_BASED,0,0).getShape());
            }
        }



    @FXML
    public void onCanvaClicked(MouseEvent event) {
        switch (event.getButton()) {
            case PRIMARY:
                shapes.add(new InversionCouplingShape(EMRCategories.INVERSION_BASED, event.getX(), event.getY()));
                break;
            case SECONDARY:
                shapes.add(new InversionAccumulationShape(EMRCategories.INVERSION_BASED, event.getX(), event.getY()));
                break;
            case MIDDLE:
                shapes.add(new InversionConversionShape(EMRCategories.INVERSION_BASED, event.getX(), event.getY()));
                break;
        }
        GraphicsContext gc = canva.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillText("Forme", 0, 0);
        for (EMRShape s : shapes) {

            s.draw(gc);

        }

    }

    /**
     * Permet de redessiner le canva à l'aide de la liste de forme du controleur
     */
    private void redrawCanva(){
    GraphicsContext gc = canva.getGraphicsContext2D();
    gc.setFill(Color.WHITE);
    gc.fillRect(0, 0, canva.getWidth(), canva.getHeight());
    for(EMRShape shape:shapes){
        shape.draw(gc);
    }
}
}
