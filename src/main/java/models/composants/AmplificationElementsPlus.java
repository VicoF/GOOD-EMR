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
