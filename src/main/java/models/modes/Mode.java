package models.modes;

import ctrl.EMRController;
import models.composants.EMRShape;
/**
 * Cette classe impl�mente le design pattern "State Pattern" avec les classes DrawMode, EraseMode et MoveMode
 *
 * @author Victor
 *
 */
public interface Mode {



    public void canvaClicked(double cursorPositionX, double cursorPositionY);
   // public void composantGlisse(EMRShape shape);
}
