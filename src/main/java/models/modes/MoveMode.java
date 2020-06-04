package models.modes;

import ctrl.EMRController;
import models.commands.EraseEMRShapeCommand;
import models.commands.MoveEMRShapeCommand;
import models.composants.EMRShape;
/**
 *  Cette classe impl�mente le design pattern "State Pattern" avec les classes DrawMode, EraseMode et Mode
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
            EMRShape newShape = selectedShape.clone();
            newShape.setPosY(cursorPositionY);
            newShape.setPosX(cursorPositionX);
            MoveEMRShapeCommand cmd = new MoveEMRShapeCommand(selectedShape,newShape);
            ctrl.getUndoCommands().add(cmd);
            cmd.execute(ctrl.getCanva());
            selectedShape=null;
        }
    }
}
