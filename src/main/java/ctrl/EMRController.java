package ctrl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.*;
import javafx.scene.layout.*;


import javafx.stage.Stage;
import models.EMRCanvas;
import models.commands.Command;
import models.commands.DrawEMRShapeCommand;
import models.commands.EraseEMRShapeCommand;
import models.composants.*;
import models.modes.MoveMode;
import models.modes.DrawMode;
import models.modes.EraseMode;
import models.modes.Mode;
import models.window.SaveFileXmlTxtWindow;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;


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

    @FXML
    Button undoButton;

    @FXML
    Button redoButton;


    EMRShape draggedShape = null;
    DrawMode drawMode = new DrawMode(this);
    EraseMode eraseMode = new EraseMode(this);
    MoveMode moveMode = new MoveMode(this);
    Mode mode = drawMode;
    Stack<Command> undoCommands = new Stack<>();
    Stack<Command> redoCommands = new Stack<>();


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
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);

            event.consume();
        });

        //Remise à zero de la shape dragged
        canva.setOnDragDropped(event -> {//Command cmd = new DrawEMRShapeCommand(canva,draggedShape);
            System.out.println("Package launched");
            canva.eraseShape(draggedShape);
            Command cmd = new DrawEMRShapeCommand(draggedShape.clone());
            cmd.execute(canva);
            undoCommands.add(cmd);
            draggedShape = null;
            event.setDropCompleted(true);
        });

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
        }else if (event.getSource().equals(undoButton)) {
            if(!undoCommands.empty()){
            Command cmd = undoCommands.pop();
                redoCommands.add(cmd);
                cmd.undo(canva);
            }
            modeLabel.setText("undoMode");

        }
        else if (event.getSource().equals(redoButton)) {
            if(!redoCommands.empty()){
                Command cmd = redoCommands.pop();
                undoCommands.add(cmd);
                cmd.execute(canva);
            }
            modeLabel.setText("redoMode");
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
        }else if(source.equals(menuSave)){
            SaveFileXmlTxtWindow sac = new SaveFileXmlTxtWindow();
            sac.display();
            
            modeLabel.setText("Sauvegarder le canva courant");
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

    public Stack<Command> getUndoCommands(){return undoCommands;}

    public Stack<Command> getRedoCommands(){return redoCommands;}


}
