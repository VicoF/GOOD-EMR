package models.commands;

import models.EMRCanvas;
import models.composants.EMRShape;

public class MoveEMRShapeCommand implements Command {
    EMRShape movedShape;
    EMRShape moveShape;
    EMRCanvas canva;

    public MoveEMRShapeCommand(EMRShape movedShape, EMRCanvas moveShape, EMRCanvas canva) {
        this.canva = canva;
    }

    @Override
    public void execute() {
        canva.eraseShape(movedShape);
        canva.drawShape(moveShape);
    }

    @Override
    public void undo() {
        canva.eraseShape(moveShape);
        canva.drawShape(movedShape);
    }
}
