package models.composants;

import javafx.scene.canvas.GraphicsContext;

public class ConversionShapeCircle extends EMRShape {

    public ConversionShapeCircle(EMRCategories categorie) {
        super(categorie);
    }

    public ConversionShapeCircle(EMRCategories categorie, double posx, double posy) {
        super(categorie, posx, posy);
    }

    public ConversionShapeCircle(EMRCategories categorie, double dimensionA, double posX, double posY) {
        super(categorie, dimensionA, posX, posY);
    }

    public ConversionShapeCircle(EMRCategories categorie, double dimensionA, int thicknessB, int policeSizeC, double posX, double posY) {
        super(categorie, dimensionA, thicknessB, policeSizeC, posX, posY);
    }


    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getCategorie().backgroundColor);
        gc.setStroke(getCategorie().borderColor);
        double xCoords = getPosX();
        double yCoords = getPosY();
        double dimA = getDimensionA();
        gc.fillOval(xCoords,yCoords, dimA,dimA);
        gc.strokeOval(xCoords,yCoords,dimA,dimA);

    }

}
