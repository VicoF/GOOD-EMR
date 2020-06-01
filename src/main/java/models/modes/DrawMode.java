package models.modes;

import models.EMRCanvas;
import models.composants.EMRShape;

public class DrawMode implements Mode {

    EMRCanvas canva;
    EMRShape firstShape;

    @Override
    public void canvaClicked(double cursorPositionX, double cursorPositionY) {
        EMRShape clickedShape = canva.getShapeOnCoordinate(cursorPositionX,cursorPositionY);
        if(clickedShape!=null){
            if(firstShape==null){
                firstShape=clickedShape;
            }
        }

    }


}
