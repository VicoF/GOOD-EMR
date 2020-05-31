package models.composants;

import javafx.scene.canvas.GraphicsContext;

public class InversionAccumulationShape extends EMRShape {
    public InversionAccumulationShape(EMRCategories categorie) {
        super(categorie);
    }

    public InversionAccumulationShape(EMRCategories categorie, double posX, double posY) {
        super(categorie, posX, posY);
    }

    public InversionAccumulationShape(EMRCategories categorie, double dimensionA, double posX, double posY) {
        super(categorie, dimensionA, posX, posY);
    }

    public InversionAccumulationShape(EMRCategories categorie, double dimensionA, int thicknessB, int policeSizeC, double posX, double posY) {
        super(categorie, dimensionA, thicknessB, policeSizeC, posX, posY);
    }


    public double[] getXCoords() {
        double x = getPosX();
        double a = getDimensionA();
        return new double[]{x, x +(3*a/4), x + ( a / 2),x, x - a/4,x + ( a / 2)};
    }


    public double[] getYCoords() {
        double y = getPosY();
        double a = getDimensionA();
        return new double[]{y, y, y+a,y, y+a,y+a};
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getCategorie().backgroundColor);
        gc.setStroke(getCategorie().borderColor);
        double[] xCoords = getXCoords();
        double[] yCoords = getYCoords();
        gc.fillPolygon(xCoords,yCoords,xCoords.length);
        gc.strokePolygon(xCoords,yCoords,xCoords.length);
    }
}
