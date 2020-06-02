package models.composants;

import javafx.scene.canvas.GraphicsContext;


public class SignalArrow extends Arrow{
    public SignalArrow(EMRCategories categorie) {
        super(categorie);
    }

    @Override
    public boolean pointIsInsideShape(double coordX, double coordY) {
        double maxX = Math.max(getPosX(),targetPosX);
        double minX = Math.min(getPosX(),targetPosX);

        double maxY = Math.max(getPosY(),targetPosY);
        double minY = Math.min(getPosY(),targetPosY);

        return(coordX>=minX&&coordX<=maxX&&coordY>=minY&&coordY<=maxY);
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
        drawArrow(gc,getPosX(),getPosY(),getTargetPosX(),getTargetPosY());
    }

    @Override
    public EMRShape clone() {
        return new SignalArrow(getCategorie(),getDimensionA(),getThicknessB(),getPoliceSizeC(),getPosX(),getPosY(),targetPosX,targetPosY);
    }
}
