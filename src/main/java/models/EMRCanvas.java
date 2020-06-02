package models;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import models.composants.EMRShape;
import models.strategies.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;

public class EMRCanvas extends Canvas {

    ArrayList<EMRShape> shapes;
    EMRCanvaToFileStrategy writeStrategy = new EMRCanvaToXMLFileStrategy();
    FileToEMRCanvaStrategy readStrategy = new XMLFileToEMRCanvaStrategy();

    public EMRCanvas() {
        shapes = new ArrayList<>();
        // Redraw canvas when size changes.
        widthProperty().addListener(evt -> redrawCanva());
        heightProperty().addListener(evt -> redrawCanva());
    }


    @Override
    public boolean isResizable() {
        return true;
    }

    @Override
    public double prefWidth(double height) {
        return getWidth();
    }

    @Override
    public double prefHeight(double width) {
        return getHeight();
    }


    /**
     * Permet de redessiner le canva à l'aide de la liste de formes
     */
    private void redrawCanva() {
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, getWidth(), getHeight());
        for (EMRShape shape : shapes) {
            shape.draw(gc);
        }
    }

    public ArrayList<EMRShape> getShapes() {
        return shapes;
    }

    public void setShapes(ArrayList<EMRShape> shapes) {
        this.shapes = shapes;
        redrawCanva();
    }

    public void clear(){
        shapes.clear();
        redrawCanva();
    }

    public void drawShape(EMRShape shape){
        shapes.add(shape);
        redrawCanva();
    }

    public void eraseShape(EMRShape shape){
        shapes.remove(shape);
        redrawCanva();
    }

    public EMRShape getShapeOnCoordinate(double coordX, double coordY){
        for (EMRShape shape:shapes
             ) {
            if (shape.pointIsInsideShape(coordX,coordY)){
                return shape;
            }
        }
        return null; //Si aucune forme trouvée
    }

    public void save(String path) throws IOException, TransformerException, ParserConfigurationException {
        writeStrategy.write(path, this);
    }

    public void load(String path) throws IOException {

        readStrategy.read(path, this);
    }


}
