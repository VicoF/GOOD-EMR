package models.commands;

import models.EMRCanvas;
/**
 *  Cette classe implemente le design pattern "Command Pattern" avec DrawEMRShapeCommand, EraseEMRShapeCommand, MoveEMRShapeCommand
 * @author Williams
 *
 */
public interface Command {
    void execute(EMRCanvas canva);
    void undo(EMRCanvas canva);
}
