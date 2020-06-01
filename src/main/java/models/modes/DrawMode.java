package models.modes;

import ctrl.EMRController;
import models.EMRCanvas;
import models.composants.Arrow;
import models.composants.EMRCategories;
import models.composants.EMRShape;
import models.composants.EMRShapeFactory;

public class DrawMode implements Mode {

    EMRController ctrl;
    EMRShape firstShape;

    public DrawMode(EMRController ctrl) {
        this.ctrl = ctrl;
    }

    @Override
    public void canvaClicked(double cursorPositionX, double cursorPositionY) {
        System.out.println("CLICKÉ DRAW");
        EMRShape clickedShape = ctrl.getCanva().getShapeOnCoordinate(cursorPositionX,cursorPositionY);
        Arrow ar = ctrl.getSelectedArrow();
        if(clickedShape!=null && clickedShape!=firstShape &&ar!=null){
            if(firstShape==null){
                firstShape=clickedShape;
            }else{
                ar.setPosX(firstShape.getPosX());
                ar.setPosY(firstShape.getPosY());
                ar.setTargetPosX(clickedShape.getPosX());
                ar.setTargetPosY(clickedShape.getPosY());
                ctrl.getCanva().drawShape(ar);
                firstShape=null;
            }
        }
    }


}
