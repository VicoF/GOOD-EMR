package models.modes;


import ctrl.EMRController;
import models.commands.EraseEMRShapeCommand;
import models.composants.Arrow;
import models.composants.EMRShape;

public class EraseMode implements Mode {

    EMRController ctrl;


    public EraseMode(EMRController ctrl) {
        this.ctrl = ctrl;
    }
    @Override
    public void canvaClicked(double cursorPositionX, double cursorPositionY) {
        System.out.println("CLICKÉ ERASE");
        EMRShape clickedShape = ctrl.getCanva().getShapeOnCoordinate(cursorPositionX,cursorPositionY);
        EraseEMRShapeCommand eraseShape = new EraseEMRShapeCommand( ctrl.getCanva(), clickedShape);
        ctrl.getUndoCommands().add(eraseShape);
        eraseShape.execute();

    }
}
