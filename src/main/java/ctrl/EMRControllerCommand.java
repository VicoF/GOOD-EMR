package ctrl;


import models.composants.EMRShape;

public class EMRControllerCommand {

    public enum TypesEvent {
        DRAW, MOVE, ERASE
    }

    TypesEvent event;
    EMRShape oldShape;
    EMRShape newShape;

    public EMRControllerCommand(TypesEvent event, EMRShape oldShape, EMRShape newShape) {
        this.event = event;
        this.oldShape = oldShape;
        this.newShape = newShape;
    }

    public TypesEvent getEvent() {
        return event;
    }

    public void setEvent(TypesEvent event) {
        this.event = event;
    }

    public EMRShape getOldShape() {
        return oldShape;
    }

    public void setOldShape(EMRShape oldShape) {
        this.oldShape = oldShape;
    }

    public EMRShape getNewShape() {
        return newShape;
    }

    public void setNewShape(EMRShape newShape) {
        this.newShape = newShape;
    }



}
