package models.commands;

import models.EMRCanvas;
import models.composants.EMRShape;

public class DrawEMRShapeCommand implements Command{
    EMRCanvas canva;
    EMRShape drawShape;

    public DrawEMRShapeCommand(EMRCanvas canva, EMRShape drawShape) {
        this.canva = canva;
        this.drawShape = drawShape;
    }

    @Override
    public void execute() {
        canva.drawShape(drawShape);
    }

    @Override
    public void undo() {
        canva.eraseShape(drawShape);
    }
}
