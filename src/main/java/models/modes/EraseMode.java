package models.modes;


import ctrl.EMRController;
import models.composants.Arrow;
import models.composants.EMRShape;
/**
 *  Cette classe impl�mente le design pattern "State Pattern" avec les classes Mode, EraseMode et MoveMode
 * @author Victor
 *
 */
public class EraseMode implements Mode {

    EMRController ctrl;


    public EraseMode(EMRController ctrl) {
        this.ctrl = ctrl;
    }
    @Override
    public void canvaClicked(double cursorPositionX, double cursorPositionY) {
        System.out.println("CLICKÉ ERASE");
        EMRShape clickedShape = ctrl.getCanva().getShapeOnCoordinate(cursorPositionX,cursorPositionY);
        ctrl.getCanva().eraseShape(clickedShape);
    }
}
