package models.composants;

import javafx.scene.canvas.GraphicsContext;

public class ConversionShapeCouplingSquare extends EMRShape {

    public ConversionShapeCouplingSquare(EMRCategories categorie) {
        super(categorie);
    }

    public ConversionShapeCouplingSquare(EMRCategories categorie, double posx, double posy) {
        super(categorie, posx, posy);
    }

    public ConversionShapeCouplingSquare(EMRCategories categorie, double dimensionA, double posX, double posY) {
        super(categorie, dimensionA, posX, posY);
    }

    public ConversionShapeCouplingSquare(EMRCategories categorie, double dimensionA, int thicknessB, int policeSizeC, double posX, double posY) {
        super(categorie, dimensionA, thicknessB, policeSizeC, posX, posY);
    }

    private double getXCoords2(){
        double x2 = getPosX() + (2*getDimensionA()/3);
        return x2;
    }

    private double getYCoords2(){
        double y2 = getPosY() + (2*getDimensionA()/3);
        return y2;
    }

    @Override
    public boolean pointIsInsideShape(double coordX, double coordY) {
        double maxX = getXCoords2()+getDimensionA();
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
        double xCoords2 = getPosX() + 2*dimA/3;
        double yCoords2 = getPosY() + 2*dimA/3;
        gc.fillRect(xCoords,yCoords, dimA, dimA);
        gc.fillRect(xCoords2,yCoords2, dimA, dimA);
        gc.strokeRect(xCoords,yCoords,dimA,dimA);
        gc.strokeRect(xCoords2,yCoords2,dimA,dimA);

    }

    @Override
    public EMRShape clone() {
        return new ConversionShapeCouplingSquare(getCategorie(),getDimensionA(),getThicknessB(),getPoliceSizeC(),getPosX(),getPosY());
    }
}
