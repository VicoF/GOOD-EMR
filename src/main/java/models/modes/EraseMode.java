package models.modes;


import ctrl.EMRController;
import models.commands.EraseEMRShapeCommand;
import models.composants.Arrow;
import models.composants.EMRShape;
/**
 *  Cette classe impl�mente le design pattern "State Pattern" avec les classes DrawMode, Mode et MoveMode
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
        EraseEMRShapeCommand eraseShape = new EraseEMRShapeCommand( clickedShape);
        ctrl.getUndoCommands().add(eraseShape);
        eraseShape.execute(ctrl.getCanva());

    }
}
