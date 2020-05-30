package models.composants;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class InversionConversionShape extends EMRShape {

    public InversionConversionShape(EMRCategories categorie) {
        super(categorie);
    }

    public InversionConversionShape(EMRCategories categorie, double dimensionA) {
        super(categorie, dimensionA);
    }

    public InversionConversionShape(EMRCategories categorie, double dimensionA, int thicknessB, int policeSizeC) {
        super(categorie, dimensionA, thicknessB, policeSizeC);
    }

    @Override
    public Shape getShape() {
        Polygon parallelogram = new Polygon();
        //parallelogram.getPoints().addAll()
        return new Polygon();
    }
}
