package models.modes;

import ctrl.EMRController;
import models.composants.EMRShape;
/**
 * Cette classe implémente le design pattern "State Pattern" avec les classes DrawMode, EraseMode et MoveMode
 * 
 * @author Victor
 *
 */
public interface Mode {



     void canvaClicked(double cursorPositionX, double cursorPositionY);
   //  void composantGlisse(EMRShape shape);
}
