package models.commands;

import models.EMRCanvas;
import models.composants.EMRShape;
/**
 *  Cette classe implemente le design pattern "Command Pattern" avec DrawEMRShapeCommand, EraseEMRShapeCommand, MoveEMRShapeCommand
 * @author Williams
 *
 */
public class DrawEMRShapeCommand implements Command{

    EMRShape drawShape;

    public DrawEMRShapeCommand(EMRShape drawShape) {
        this.drawShape = drawShape;
    }

    @Override
    public void execute(EMRCanvas canva) {
        canva.drawShape(drawShape);
    }

    @Override
    public void undo(EMRCanvas canva) {
        canva.eraseShape(drawShape);
    }
}
