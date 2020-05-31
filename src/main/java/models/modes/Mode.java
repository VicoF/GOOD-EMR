package models.modes;

import models.composants.EMRShape;

public interface Mode {
    public void composantClicked(EMRShape shape);
    public void composantGlisse(EMRShape shape);
}
