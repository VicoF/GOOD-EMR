package models.composants;

import javafx.scene.canvas.GraphicsContext;

public class ConversionShapeCouplingCircle extends EMRShape {

    public ConversionShapeCouplingCircle(EMRCategories categorie) {
        super(categorie);
    }

    public ConversionShapeCouplingCircle(EMRCategories categorie, double posx, double posy) {
        super(categorie, posx, posy);
    }

    public ConversionShapeCouplingCircle(EMRCategories categorie, double dimensionA, double posX, double posY) {
        super(categorie, dimensionA, posX, posY);
    }

    public ConversionShapeCouplingCircle(EMRCategories categorie, double dimensionA, int thicknessB, int policeSizeC, double posX, double posY) {
        super(categorie, dimensionA, thicknessB, policeSizeC, posX, posY);
    }


    private double getYCoords2(){
        double y2 = getPosY() + (2*getDimensionA()/3);
        return y2;
    }

    @Override
    public boolean pointIsInsideShape(double coordX, double coordY) {
        double maxX = getPosX()+getDimensionA();
        double minX = getPosX();

        double maxY = getYCoords2()+getDimensionA();
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
        double y2Coords = getPosY() + (2*dimA/3);
        gc.fillOval(xCoords,yCoords, dimA,dimA);
        gc.fillOval(xCoords,y2Coords, dimA,dimA);
        gc.strokeOval(xCoords,yCoords,dimA,dimA);
        gc.strokeOval(xCoords,y2Coords,dimA,dimA);

    }


}
