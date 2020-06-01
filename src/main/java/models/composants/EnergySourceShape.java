package models.composants;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;

public class EnergySourceShape extends EMRShape{


    public EnergySourceShape(EMRCategories categorie) {
        super(categorie);
    }

    public EnergySourceShape(EMRCategories categorie, double posx, double posy) {
        super(categorie, posx, posy);
    }

    public EnergySourceShape(EMRCategories categorie, double dimensionA, double posX, double posY) {
        super(categorie, dimensionA, posX, posY);
    }

    public EnergySourceShape(EMRCategories categorie, double dimensionA, int thicknessB, int policeSizeC, double posX, double posY) {
        super(categorie, dimensionA, thicknessB, policeSizeC, posX, posY);
    }

    @Override
    public boolean pointIsInsideShape(double coordX, double coordY) {
        return false;
    }



    @Override
    public boolean pointIsInsideShape(double coordX, double coordY) {

        double maxX = getPosX()+2*getDimensionA();
        double minX = getPosX();

        double maxY = getPosY()+getDimensionA();
        double minY = getPosY();

        return(coordX>=minX&&coordX<=maxX&&coordY>=minY&&coordY<=maxY);
    }


    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getCategorie().backgroundColor);
        gc.setStroke(getCategorie().borderColor);
        double xCoords = getPosX();
        double yCoords = getPosY();
        double dimA = getDimensionA();
        gc.fillOval(xCoords,yCoords, 2*dimA,dimA);
        gc.strokeOval(xCoords,yCoords,2*dimA,dimA);
        Label label = new Label("Name");
        label.setLayoutX(xCoords);
        label.setLayoutY(yCoords);
    }
}
