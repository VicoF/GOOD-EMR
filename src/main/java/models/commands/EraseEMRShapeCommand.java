package models.commands;

import models.EMRCanvas;
import models.composants.EMRShape;

public class EraseEMRShapeCommand implements Command {
    EMRShape deadShape;


    public EraseEMRShapeCommand( EMRShape deadShape) {
        this.deadShape = deadShape;
    }

    @Override
    public void execute(EMRCanvas canva) {
        canva.eraseShape(deadShape);
    }

    @Override
    public void undo(EMRCanvas canva) {
        canva.drawShape(deadShape);
    }
}
