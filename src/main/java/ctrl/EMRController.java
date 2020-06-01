package ctrl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.*;


import models.EMRCanvas;
import models.composants.*;
import models.modes.DragMode;
import models.modes.DrawMode;
import models.modes.EraseMode;
import models.modes.Mode;


public class EMRController {

    @FXML
    EMRCanvas canva;
    @FXML
    Pane canvaParent;

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

    @FXML
    Button drawButton;

    @FXML
    Button eraseButton;

    @FXML
    Button dragButton;

    @FXML
    Label modeLabel;



    EMRShape draggedShape = null;

    Mode mode = new DrawMode();




    public void initialize() {
       canva.widthProperty().bind(canvaParent.widthProperty());
       canva.heightProperty().bind(canvaParent.heightProperty());


        Canvas currentCanva = inversionAccumulationCanva;
        EMRShape s = EMRShapeFactory.getComposant(EMRShapeFactory.EMRShapeType.INVERSION_ACCUMULATION,EMRCategories.INVERSION_BASED, (int) (currentCanva.getWidth()/2),(int) (currentCanva.getHeight()/2));
        s.draw(currentCanva.getGraphicsContext2D());
        currentCanva = inversionConversionCanva;
        s = EMRShapeFactory.getComposant(EMRShapeFactory.EMRShapeType.INVERSION_CONVERSION,EMRCategories.INVERSION_BASED,(int) (currentCanva.getWidth()/2),(int) (currentCanva.getHeight()/2));
        s.draw(currentCanva.getGraphicsContext2D());
        currentCanva = inversionCouplingCanva;
        s = EMRShapeFactory.getComposant(EMRShapeFactory.EMRShapeType.INVERSION_COUPLING,EMRCategories.INVERSION_BASED,(int) (currentCanva.getWidth()/2),(int) (currentCanva.getHeight()/2));
        s.draw(currentCanva.getGraphicsContext2D());


        canva.setOnDragOver(event -> {
            /* data is dragged over the target */
            System.out.println("onDragOver");
            // On retire la shape que l'on drag du canva
            canva.eraseShape(draggedShape);
            //On met à jour ses données
            draggedShape.setPosX(event.getX());
            draggedShape.setPosY(event.getY());
            //On la remet dans le canva
            canva.drawShape(draggedShape);


            event.consume();
        });

        canva.setOnDragDropped(event -> draggedShape=null);

    }

    @FXML
    public void onMenuCanvaDragged(MouseEvent event){
        /* drag was detected, start drag-and-drop gesture*/
        System.out.println("onDragDetected");

        /* allow any transfer mode */
        Dragboard db = inversionCouplingCanva.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putString("Allo");
        db.setContent(content);

       if(event.getSource().equals(inversionCouplingCanva)) {
           draggedShape = EMRShapeFactory.getComposant(EMRShapeFactory.EMRShapeType.INVERSION_COUPLING, EMRCategories.INVERSION_BASED, 0, 0);
       }else if (event.getSource().equals(inversionAccumulationCanva)){
           draggedShape = EMRShapeFactory.getComposant(EMRShapeFactory.EMRShapeType.INVERSION_ACCUMULATION, EMRCategories.INVERSION_BASED, 0, 0);
       }else if (event.getSource().equals(inversionConversionCanva)){
           draggedShape = EMRShapeFactory.getComposant(EMRShapeFactory.EMRShapeType.INVERSION_CONVERSION, EMRCategories.INVERSION_BASED, 0, 0);
       }

        event.consume();
    }


    @FXML
    public void onToolBarButtonClicked(ActionEvent event){
        modeLabel.setText("Bouton cliqué");
        if(event.getSource().equals(drawButton)){
            mode = new DrawMode();
            modeLabel.setText("Outil de dessin selectionne, glissez sur le canva pour dessiner une fleche");
        }else if(event.getSource().equals(eraseButton)){
            mode = new EraseMode();
            modeLabel.setText("Outil efface selectionne, appuyez sur une forme pour l'effacer");
        }else if(event.getSource().equals(dragButton)){
            mode = new DragMode();
            modeLabel.setText("Outil de glissement selectionne, glissez sur le canva pour dessiner deplacer les formes");
        }
    }

    @FXML
    public void onCanvaClicked(MouseEvent event) {
        switch (event.getButton()) {
            case PRIMARY:
                canva.drawShape(new SignalArrow(EMRCategories.RED_ARROW, event.getX(), event.getY(), event.getX()-10,event.getY()+20));
                break;
            case SECONDARY:
                canva.drawShape(new InversionAccumulationShape(EMRCategories.INVERSION_BASED, event.getX(), event.getY()));
                break;
            case MIDDLE:
                canva.drawShape(new InversionConversionShape(EMRCategories.INVERSION_BASED, event.getX(), event.getY()));
                break;
        }

    }



}
