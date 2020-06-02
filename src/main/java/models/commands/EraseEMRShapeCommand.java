package models.commands;

import models.EMRCanvas;
import models.composants.EMRShape;

public class EraseEMRShapeCommand implements Command {
    EMRShape deadShape;
    EMRCanvas canva;

    public EraseEMRShapeCommand(EMRCanvas canva, EMRShape deadShape) {
        this.canva = canva;
        this.deadShape = deadShape;
    }

    @Override
    public void execute() {
        canva.eraseShape(deadShape);
    }

    @Override
    public void undo() {
        canva.drawShape(deadShape);
    }
}
