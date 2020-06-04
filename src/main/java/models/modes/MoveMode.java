package models.modes;

import ctrl.EMRController;
import models.composants.EMRShape;
/**
 *  Cette classe impl�mente le design pattern "State Pattern" avec les classes Mode, EraseMode et MoveMode
 * @author Victor
 *
 */
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
