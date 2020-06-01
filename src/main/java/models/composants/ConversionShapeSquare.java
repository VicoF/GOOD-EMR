package models.composants;

import javafx.scene.canvas.GraphicsContext;

public class ConversionShapeSquare extends EMRShape {

    public ConversionShapeSquare(EMRCategories categorie) {
        super(categorie);
    }

    public ConversionShapeSquare(EMRCategories categorie, double posx, double posy) {
        super(categorie, posx, posy);
    }

    public ConversionShapeSquare(EMRCategories categorie, double dimensionA, double posX, double posY) {
        super(categorie, dimensionA, posX, posY);
    }

    public ConversionShapeSquare(EMRCategories categorie, double dimensionA, int thicknessB, int policeSizeC, double posX, double posY) {
        super(categorie, dimensionA, thicknessB, policeSizeC, posX, posY);
    }

    @Override
    public boolean pointIsInsideShape(double coordX, double coordY) {
        return false;
    }



    @Override
    public boolean pointIsInsideShape(double coordX, double coordY) {
        double maxX = getPosX()+getDimensionA();
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
        gc.fillRect(xCoords,yCoords, dimA,dimA);
        gc.strokeRect(xCoords,yCoords,dimA,dimA);

    }

}
