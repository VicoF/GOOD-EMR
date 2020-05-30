package models.composants;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class InversionConversionShape extends EMRShape {


    public InversionConversionShape(EMRCategories categorie) {
        super(categorie);
    }

    public InversionConversionShape(EMRCategories categorie, double posX, double posY) {
        super(categorie, posX, posY);
    }

    public InversionConversionShape(EMRCategories categorie, double dimensionA, double posX, double posY) {
        super(categorie, dimensionA, posX, posY);
    }

    public InversionConversionShape(EMRCategories categorie, double dimensionA, int thicknessB, int policeSizeC, double posX, double posY) {
        super(categorie, dimensionA, thicknessB, policeSizeC, posX, posY);
    }



    @Override
    public double[] getXCoords() {
        double x = getPosX();
        double y = getPosY();
        double a = getDimensionA();
        return new double[]{x, x +(3*a/4), x + ( a / 2), x - a/4};
    }

    @Override
    public double[] getYCoords() {
        double x = getPosX();
        double y = getPosY();
        double a = getDimensionA();
        return new double[]{y, y, y+a, y+a};
    }
}
