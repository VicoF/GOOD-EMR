package models.composants;

import java.awt.*;

public enum EMRCategories {

    ENERGY_SOURCE(new Color(152,251,152), new Color(0,128,0)),
    ENERGY_BASED(new Color(255,215,0),new Color(255,0,0)),
    MODEL(new Color(238,130,238),new Color(0,0,255)),
    INVERSION_BASED(new Color(135,206,235),new Color(0,0,255)),
    STRATEGY(new Color(0,0,255), new Color(0,0,255));


    public Color backgroundColor;
    public Color borderColor;


    EMRCategories(Color backgroundColor, Color borderColor ){
        this.backgroundColor=backgroundColor;
        this.borderColor=borderColor;

    }
}
