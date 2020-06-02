package models.commands;

import models.EMRCanvas;
import models.composants.EMRCategories;
import models.composants.EMRShape;

public class MoveEMRShapeCommand implements Command {
    EMRShape oldShape;
    EMRShape newShape;


    public MoveEMRShapeCommand(EMRShape oldShape, EMRShape newShape) {
        this.newShape=newShape;
        this.oldShape=oldShape;
    }

    @Override
    public void execute(EMRCanvas canva) {
        canva.eraseShape(oldShape);

        canva.drawShape(newShape);
    }

    @Override
    public void undo(EMRCanvas canva) {
        canva.eraseShape(newShape);
        canva.drawShape(oldShape);
    }
}
