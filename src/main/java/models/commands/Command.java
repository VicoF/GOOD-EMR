package models.commands;

import models.EMRCanvas;

public interface Command {
    void execute(EMRCanvas canva);
    void undo(EMRCanvas canva);
}
