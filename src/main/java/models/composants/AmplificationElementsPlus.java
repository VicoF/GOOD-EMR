package models.composants;

import javafx.scene.canvas.GraphicsContext;

public class AmplificationElementsPlus extends EMRShape{
    public AmplificationElementsPlus(EMRCategories categorie) {
        super(categorie);
    }

    public AmplificationElementsPlus(EMRCategories categorie, double posx, double posy) {
        super(categorie, posx, posy);
    }

    public AmplificationElementsPlus(EMRCategories categorie, double dimensionA, double posX, double posY) {
        super(categorie, dimensionA, posX, posY);
    }

    public AmplificationElementsPlus(EMRCategories categorie, double dimensionA, int thicknessB, int policeSizeC, double posX, double posY) {
        super(categorie, dimensionA, thicknessB, policeSizeC, posX, posY);
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


    @Override
    public EMRShape clone() {
        return new AmplificationElementsPlus(getCategorie(),getDimensionA(),getThicknessB(),getPoliceSizeC(),getPosX(),getPosY());
    }

}
