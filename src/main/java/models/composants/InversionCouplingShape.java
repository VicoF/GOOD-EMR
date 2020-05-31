package models.composants;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import java.util.List;

public class InversionCouplingShape extends EMRShape{
    public InversionCouplingShape(EMRCategories categorie) {
        super(categorie);
    }

    public InversionCouplingShape(EMRCategories categorie, double posX, double posY) {
        super(categorie, posX, posY);
    }

    public InversionCouplingShape(EMRCategories categorie, double dimensionA, double posX, double posY) {
        super(categorie, dimensionA, posX, posY);
    }

    public InversionCouplingShape(EMRCategories categorie, double dimensionA, int thicknessB, int policeSizeC, double posX, double posY) {
        super(categorie, dimensionA, thicknessB, policeSizeC, posX, posY);
    }


    private double[] getXCoords(double startX) {
        double a = getDimensionA();
        return new double[]{startX, startX +(3*a/4), startX + ( a / 2), startX - a/4};
    }


    public double[] getYCoords(double startY) {
        double a = getDimensionA();
        return new double[]{startY, startY, startY+a, startY+a};
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getCategorie().backgroundColor);
        gc.setStroke(getCategorie().borderColor);
        double x= getPosX();
        double y = getPosY();
        double a =getDimensionA();
        double[] xCoords = getXCoords(x);
        double[] yCoords = getYCoords(y);
        //dessine le 1er rectangle
        gc.fillPolygon(xCoords,yCoords,xCoords.length);

        //changement des coordonnées de départ pour le 2e rectangle
        x = (a / 4) + x ;
        y = y + (2 * a / 3);
        double[] xCoords2 = getXCoords(x);
        double[] yCoords2 = getYCoords(y);
        //dessine le 2e rectangle
        gc.fillPolygon(xCoords2,yCoords2,xCoords2.length);
        //Ajout des lignes de contour par la suite, pour qu'elles se superposent
        gc.strokePolygon(xCoords,yCoords,xCoords.length);
        gc.strokePolygon(xCoords2,yCoords2,xCoords2.length);

    }
}
