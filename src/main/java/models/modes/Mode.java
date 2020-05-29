package models.modes;

import models.composants.Composant;

public interface Mode {
    public void composantClicked(Composant composant);
    public void composantGlisse(Composant composant);
}
