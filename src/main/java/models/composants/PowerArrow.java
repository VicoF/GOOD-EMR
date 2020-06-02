package models.composants;

import javafx.scene.canvas.GraphicsContext;

import static java.lang.Math.cos;

public class PowerArrow extends Arrow {
    public PowerArrow(EMRCategories categorie) {
        super(categorie);
    }

    @Override
    public boolean pointIsInsideShape(double coordX, double coordY) {
        double x1 = getPosX(), x2=targetPosX, y1=getPosY(),y2=targetPosY;
        double dx = targetPosX-getPosX(), dy = targetPosY-getPosY();
        double angle = Math.atan2(dx,dy);
        double xOffset = Math.cos(angle)*getDimensionA()/2;
        double yOffset = Math.sin(angle)*getDimensionA()/2;
        double x3=x2-xOffset, x4=x1-xOffset,y3=y2+yOffset,y4=y1+yOffset;
        
        double maxX = Math.max(x1,Math.max(x2,Math.max(x3,x4)));
        double minX = Math.min(x1,Math.min(x2,Math.min(x3,x4)));

        double maxY = Math.max(y1,Math.max(y2,Math.max(y3,y4)));
        double minY = Math.min(y1,Math.min(y2,Math.min(y3,y4)));

        return(coordX>=minX&&coordX<=maxX&&coordY>=minY&&coordY<=maxY);
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
    @Override
    public EMRShape clone() {
        return new PowerArrow(getCategorie(),getDimensionA(),getThicknessB(),getPoliceSizeC(),getPosX(),getPosY(),targetPosX,targetPosY);
    }
}
