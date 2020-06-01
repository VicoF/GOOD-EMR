package models.composants;

import javafx.scene.canvas.GraphicsContext;


public class SignalArrow extends Arrow{
    public SignalArrow(EMRCategories categorie) {
        super(categorie);
    }

    public SignalArrow(EMRCategories categorie, double posX, double posY, double targetPosX, double targetPosY) {
        super(categorie, posX, posY, targetPosX, targetPosY);
    }

    public SignalArrow(EMRCategories categorie, double dimensionA, double posX, double posY, double targetPosX, double targetPosY) {
        super(categorie, dimensionA, posX, posY, targetPosX, targetPosY);
    }

    public SignalArrow(EMRCategories categorie, double dimensionA, int thicknessB, int policeSizeC, double posX, double posY, double targetPosX, double targetPosY) {
        super(categorie, dimensionA, thicknessB, policeSizeC, posX, posY, targetPosX, targetPosY);
    }

    @Override
    public void draw(GraphicsContext gc) {
        final int ARROW_SIZE = 6;
        final double ARROW_ANGLE = Math.PI/6; //30 degrés

        gc.setFill(getCategorie().backgroundColor);
        gc.setStroke(getCategorie().borderColor);
        double x1 = getPosX(), x2=targetPosX, y1=getPosY(),y2=targetPosY;

        double dx = x2 - x1, dy = y2 - y1;
        double angle = Math.atan2(dy, dx) + Math.PI;

        double x3 = x2 + ARROW_SIZE * Math.cos(angle-ARROW_ANGLE);
        double y3 = y2 + ARROW_SIZE * Math.sin(angle-ARROW_ANGLE);
        double x4 = x2 + ARROW_SIZE * Math.cos(angle+ARROW_ANGLE);
        double y4 = y2 + ARROW_SIZE * Math.sin(angle+ARROW_ANGLE);;


        gc.strokeLine(getPosX(), getPosY(), targetPosX, targetPosY);
        gc.strokeLine(x3,y3,x2,y2);
        gc.strokeLine(x4,y4,x2,y2);
    }
}
