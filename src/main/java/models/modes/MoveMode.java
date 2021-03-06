package models.modes;

import ctrl.EMRController;
import models.composants.EMRShape;

public class MoveMode implements Mode {

    EMRController ctrl;
    EMRShape selectedShape;

    public MoveMode(EMRController ctrl) {
        this.ctrl = ctrl;
    }
    @Override
    public void canvaClicked(double cursorPositionX, double cursorPositionY) {
        System.out.println("CLICKÉ MOVE");
        if(selectedShape ==null){
           selectedShape = ctrl.getCanva().getShapeOnCoordinate(cursorPositionX,cursorPositionY);
        }else{
            ctrl.getCanva().eraseShape(selectedShape);
            selectedShape.setPosX(cursorPositionX);
            selectedShape.setPosY(cursorPositionY);
            ctrl.getCanva().drawShape(selectedShape);
            selectedShape=null;
        }
    }
}
