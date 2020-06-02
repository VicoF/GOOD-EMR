package ctrl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;


import models.EMRCanvas;
import models.WriteBehavior;
import models.WriteToTextFileBehavior;
import models.composants.*;
import models.modes.MoveMode;
import models.modes.DrawMode;
import models.modes.EraseMode;
import models.modes.Mode;

import java.io.*;
import java.util.ArrayList;


public class EMRController {

    @FXML
    EMRCanvas canva;
    @FXML
    Pane canvaParent;

    @FXML
    Accordion accordion;

    @FXML
    MenuItem menuSave;
    @FXML
    MenuItem menuOpen;
    @FXML
    MenuItem menuClose;
    @FXML
    MenuItem menuClearAll;

    @FXML
    ComboBox arrowCombo;

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
    Canvas conversionSquareCanva;

    @FXML
    Canvas conversionCircleCanva;

    @FXML
    Canvas conversionCouplingCircleCanva;

    @FXML
    Canvas conversionCouplingSquareCanva;

    @FXML
    Canvas energySourceCanva;

    @FXML
    BorderPane pane;

    @FXML
    Button drawButton;

    @FXML
    Button eraseButton;

    @FXML
    Button moveButton;

    @FXML
    Label modeLabel;



    EMRShape draggedShape = null;
    DrawMode drawMode = new DrawMode(this);
    EraseMode eraseMode = new EraseMode(this);
    MoveMode moveMode = new MoveMode(this);
    Mode mode = drawMode;


    public void initialize() {
        canva.widthProperty().bind(canvaParent.widthProperty());
        canva.heightProperty().bind(canvaParent.heightProperty());


        Canvas currentCanva = inversionAccumulationCanva;
        EMRShape s = EMRShapeFactory.getComposant(EMRShapeFactory.ComposantType.INVERSION_ACCUMULATION, EMRCategories.INVERSION_BASED,
                (int) (currentCanva.getWidth() / 2), (int) (currentCanva.getHeight() / 2));
        s.draw(currentCanva.getGraphicsContext2D());
        currentCanva = inversionConversionCanva;
        s = EMRShapeFactory.getComposant(EMRShapeFactory.ComposantType.INVERSION_CONVERSION, EMRCategories.INVERSION_BASED,
                (int) (currentCanva.getWidth() / 2), (int) (currentCanva.getHeight() / 2));
        s.draw(currentCanva.getGraphicsContext2D());
        currentCanva = inversionCouplingCanva;
        s = EMRShapeFactory.getComposant(EMRShapeFactory.ComposantType.INVERSION_COUPLING, EMRCategories.INVERSION_BASED,
                (int) (currentCanva.getWidth() / 2), (int) (currentCanva.getHeight() / 2));
        s.draw(currentCanva.getGraphicsContext2D());
        currentCanva = conversionCircleCanva;
        s = EMRShapeFactory.getComposant(EMRShapeFactory.ComposantType.ENERGY_BASED_CONVERSION_CIRCLE, EMRCategories.ENERGY_BASED, (int) (currentCanva.getWidth() / 2), (int) (currentCanva.getHeight() / 2));
        s.draw(currentCanva.getGraphicsContext2D());
        currentCanva = conversionSquareCanva;
        s = EMRShapeFactory.getComposant(EMRShapeFactory.ComposantType.ENERGY_BASED_CONVERSION_SQUARE, EMRCategories.ENERGY_BASED, (int) (currentCanva.getWidth() / 2), (int) (currentCanva.getHeight() / 2));
        s.draw(currentCanva.getGraphicsContext2D());
        currentCanva = conversionCouplingSquareCanva;
        s = EMRShapeFactory.getComposant(EMRShapeFactory.ComposantType.ENERGY_BASED_CONVERSION_COUPLING_SQUARE, EMRCategories.ENERGY_BASED, (int) (currentCanva.getWidth() / 2), (int) (currentCanva.getHeight() / 2));
        s.draw(currentCanva.getGraphicsContext2D());
        currentCanva = conversionCouplingCircleCanva;
        s = EMRShapeFactory.getComposant(EMRShapeFactory.ComposantType.ENERGY_BASED_CONVERSION_COUPLING_CIRCLE, EMRCategories.ENERGY_BASED, (int) (currentCanva.getWidth() / 2), (int) (currentCanva.getHeight() / 2));
        s.draw(currentCanva.getGraphicsContext2D());
        currentCanva = energySourceCanva;
        s = EMRShapeFactory.getComposant(EMRShapeFactory.ComposantType.ENERGY_SOURCE_SHAPE, EMRCategories.ENERGY_SOURCE, (int) (currentCanva.getWidth() / 2), (int) (currentCanva.getHeight() / 2));
        s.draw(currentCanva.getGraphicsContext2D());

        //Pour dessiner un flêche quand on drag
        canva.setOnDragDetected(event -> {
            System.out.println("ÇA DRAAAAAAAAAAAAAAAAAAAAGUE");
            String value  = (String) arrowCombo.getValue();
            if (value!=null){
                if (value.equals("Signal arrow")){
                    draggedShape = EMRShapeFactory.getArrow(EMRShapeFactory.ArrowType.SIGNAL_ARROW,EMRCategories.RED_ARROW, event.getX(), event.getY(), event.getX(), event.getY());
                    canva.startFullDrag();
                }else if (value.equals("Power arrow")){
                    draggedShape = EMRShapeFactory.getArrow(EMRShapeFactory.ArrowType.POWER_ARROW,EMRCategories.BLACK_ARROW, event.getX(), event.getY(), event.getX(), event.getY());
                    canva.startFullDrag();
                }

            }

        });

        //Éditer la flêche pendant qu'on drag
        canva.setOnMouseDragOver(event -> {
            System.out.println("onDragOver");

            // On retire la shape que l'on drag du canva
            canva.eraseShape(draggedShape);
            //On met à jour ses données

            ((Arrow) draggedShape).setTargetPosX(event.getX());
            ((Arrow) draggedShape).setTargetPosY(event.getY());

            //On la remet dans le canva
            canva.drawShape(draggedShape);


            event.consume();
        });
        //Dessiner les formes pendant qu'on drag
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

        //Remise à zero de la shape dragged
        canva.setOnDragDropped(event -> draggedShape = null);

    }

    @FXML
    public void onMenuCanvaDragged(MouseEvent event) {
        /* drag was detected, start drag-and-drop gesture*/
        System.out.println("onDragDetected");

        /* allow any transfer mode */
        Dragboard db = inversionCouplingCanva.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putString("Allo");
        db.setContent(content);

        if (event.getSource().equals(inversionCouplingCanva)) {
            draggedShape = EMRShapeFactory.getComposant(EMRShapeFactory.ComposantType.INVERSION_COUPLING, EMRCategories.INVERSION_BASED, 0, 0);
        } else if (event.getSource().equals(inversionAccumulationCanva)) {
            draggedShape = EMRShapeFactory.getComposant(EMRShapeFactory.ComposantType.INVERSION_ACCUMULATION, EMRCategories.INVERSION_BASED, 0, 0);
        } else if (event.getSource().equals(inversionConversionCanva)) {
            draggedShape = EMRShapeFactory.getComposant(EMRShapeFactory.ComposantType.INVERSION_CONVERSION, EMRCategories.INVERSION_BASED, 0, 0);
        }else if (event.getSource().equals(conversionSquareCanva)){
            draggedShape = EMRShapeFactory.getComposant(EMRShapeFactory.ComposantType.ENERGY_BASED_CONVERSION_SQUARE, EMRCategories.ENERGY_BASED, 0, 0);
        }else if (event.getSource().equals(conversionCircleCanva)){
            draggedShape = EMRShapeFactory.getComposant(EMRShapeFactory.ComposantType.ENERGY_BASED_CONVERSION_CIRCLE, EMRCategories.ENERGY_BASED, 0, 0);
        }else if (event.getSource().equals(conversionCouplingSquareCanva)){
            draggedShape = EMRShapeFactory.getComposant(EMRShapeFactory.ComposantType.ENERGY_BASED_CONVERSION_COUPLING_SQUARE, EMRCategories.ENERGY_BASED, 0, 0);
        }else if (event.getSource().equals(conversionCouplingCircleCanva)){
            draggedShape = EMRShapeFactory.getComposant(EMRShapeFactory.ComposantType.ENERGY_BASED_CONVERSION_COUPLING_CIRCLE, EMRCategories.ENERGY_BASED, 0, 0);
        }else if (event.getSource().equals(energySourceCanva)){
            draggedShape = EMRShapeFactory.getComposant(EMRShapeFactory.ComposantType.ENERGY_SOURCE_SHAPE, EMRCategories.ENERGY_SOURCE, 0, 0);
        }


        event.consume();
    }


    @FXML
    public void onToolBarButtonClicked(ActionEvent event) {
        modeLabel.setText("Bouton cliqué");
        if (event.getSource().equals(drawButton)) {
            mode = drawMode;
            modeLabel.setText("Outil de dessin selectionne, glissez sur le canva pour dessiner une fleche");
        } else if (event.getSource().equals(eraseButton)) {
            mode = eraseMode;
            modeLabel.setText("Outil efface selectionne, appuyez sur une forme pour l'effacer");
        } else if (event.getSource().equals(moveButton)) {
            mode = moveMode;
            modeLabel.setText("Outil de glissement selectionne, glissez sur le canva pour dessiner deplacer les formes");
        }
    }

    @FXML
    public void onCanvaClicked(MouseEvent event) {
      /*  switch (event.getButton()) {
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
*/

        mode.canvaClicked(event.getX(),event.getY());
    }



    public void onMenuButtonClick(ActionEvent event){
        Object source = event.getSource();

        if (source.equals(menuClearAll)){
                modeLabel.setText("Clear");
                canva.clear();
        }else if (source.equals(menuClose)){
            modeLabel.setText("Fermer la fenêtre");
        }else if(source.equals(menuOpen)){
            modeLabel.setText("Ouvrir un fichier sauvegardé");

            try {
                canva.load("C:/Users/julie/Desktop/WRITEDCANVA.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else if(source.equals(menuSave)){
            modeLabel.setText("Sauvegarder le canva courant");
            try {
                canva.save("C:/Users/julie/Desktop/WRITEDCANVA.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            modeLabel.setText("Option non pris en charge");

        }

    }

    public Arrow getSelectedArrow(){
        String value  = (String) arrowCombo.getValue();
        if (value!=null){
            if (value.equals("Signal arrow")){
                return EMRShapeFactory.getArrow(EMRShapeFactory.ArrowType.SIGNAL_ARROW,EMRCategories.RED_ARROW,0,0,0,0);
            }else if (value.equals("Power arrow")){
                return EMRShapeFactory.getArrow(EMRShapeFactory.ArrowType.POWER_ARROW,EMRCategories.BLACK_ARROW,0,0,0,0);
            }
        }
        return null;
    }

    public EMRCanvas getCanva() {
        return canva;
    }
}
