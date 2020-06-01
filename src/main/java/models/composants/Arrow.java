package models.composants;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Shape;

public abstract class Arrow extends EMRShape {

    double targetPosX;
    double targetPosY;

    public Arrow(EMRCategories categorie) {
        super(categorie);
    }

    public Arrow(EMRCategories categorie, double posX, double posY, double targetPosX, double targetPosY) {
        super(categorie, posX, posY);
        this.targetPosX=targetPosX;
        this.targetPosY=targetPosY;
    }

    public Arrow(EMRCategories categorie, double dimensionA, double posX, double posY,double targetPosX, double targetPosY) {
        super(categorie, dimensionA, posX, posY);
        this.targetPosX=targetPosX;
        this.targetPosY=targetPosY;
    }

    public Arrow(EMRCategories categorie, double dimensionA, int thicknessB, int policeSizeC, double posX, double posY,double targetPosX, double targetPosY) {
        super(categorie, dimensionA, thicknessB, policeSizeC, posX, posY);
        this.targetPosX=targetPosX;
        this.targetPosY=targetPosY;
    }
}
