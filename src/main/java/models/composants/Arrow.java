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

    public double getTargetPosX() {
        return targetPosX;
    }

    public void setTargetPosX(double targetPosX) {
        this.targetPosX = targetPosX;
    }

    public double getTargetPosY() {
        return targetPosY;
    }

    public void setTargetPosY(double targetPosY) {
        this.targetPosY = targetPosY;
    }

    public void drawArrow(GraphicsContext gc, double x1, double y1, double x2, double y2){
        final int ARROW_SIZE = 6;
        final double ARROW_ANGLE = Math.PI/6; //30 degrés

        gc.setFill(getCategorie().backgroundColor);
        gc.setStroke(getCategorie().borderColor);

        double dx = x2 - x1, dy = y2 - y1;
        double angle = Math.atan2(dy, dx) + Math.PI;

        double x3 = x2 + ARROW_SIZE * Math.cos(angle-ARROW_ANGLE);
        double y3 = y2 + ARROW_SIZE * Math.sin(angle-ARROW_ANGLE);
        double x4 = x2 + ARROW_SIZE * Math.cos(angle+ARROW_ANGLE);
        double y4 = y2 + ARROW_SIZE * Math.sin(angle+ARROW_ANGLE);;


        gc.strokeLine(x1, y1, x2, y2);
        gc.strokeLine(x3,y3,x2,y2);
        gc.strokeLine(x4,y4,x2,y2);
    }

    @Override
    public String toString() {
        return this.getClass()+"{" +
                "categorie=" + getCategorie() +
                ", posX=" + getPosX() +
                ", posY=" + getPosY() +
                ", targetPosX=" + targetPosX +
                ", targetPosY=" + targetPosY +
                '}';
    }
}
