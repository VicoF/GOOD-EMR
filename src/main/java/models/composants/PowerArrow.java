package models.composants;

import javafx.scene.canvas.GraphicsContext;

import static java.lang.Math.cos;

public class PowerArrow extends Arrow {
    public PowerArrow(EMRCategories categorie) {
        super(categorie);
    }

    public PowerArrow(EMRCategories categorie, double posX, double posY, double targetPosX, double targetPosY) {
        super(categorie, posX, posY, targetPosX, targetPosY);
    }

    public PowerArrow(EMRCategories categorie, double dimensionA, double posX, double posY, double targetPosX, double targetPosY) {
        super(categorie, dimensionA, posX, posY, targetPosX, targetPosY);
    }

    public PowerArrow(EMRCategories categorie, double dimensionA, int thicknessB, int policeSizeC, double posX, double posY, double targetPosX, double targetPosY) {
        super(categorie, dimensionA, thicknessB, policeSizeC, posX, posY, targetPosX, targetPosY);
    }

    @Override
    public void draw(GraphicsContext gc) {
        drawArrow(gc,getPosX(),getPosY(),getTargetPosX(),getTargetPosY());
        double dx = targetPosX-getPosX(), dy = targetPosY-getPosY();
        double angle = Math.atan2(dx,dy);
        double xOffset = Math.cos(angle)*getDimensionA()/2;
        double yOffset = Math.sin(angle)*getDimensionA()/2;
        drawArrow(gc,getTargetPosX()-xOffset,getTargetPosY()+yOffset,getPosX()-xOffset,getPosY()+yOffset);
    }
}
