package models.composants;


import javafx.scene.paint.Color;
/**
 * Définis les diverses catégories de formes et les couleurs qui leur sont associées
 * @author Victor
 *
 */
public enum EMRCategories {

    ENERGY_SOURCE( Color.rgb(152,251,152), Color.rgb(0,128,0)),
    ENERGY_BASED(Color.rgb(255,215,0),Color.rgb(255,0,0)),
    MODEL(Color.rgb(238,130,238),Color.rgb(0,0,255)),
    INVERSION_BASED(Color.rgb(135,206,235),Color.rgb(0,0,255)),
    STRATEGY(Color.rgb(0,0,255), Color.rgb(0,0,255)),
    BLACK_ARROW(Color.BLACK,Color.BLACK),
    RED_ARROW(Color.RED,Color.RED);;


    public Color backgroundColor;
    public Color borderColor;


    EMRCategories(Color backgroundColor, Color borderColor ){
        this.backgroundColor=backgroundColor;
        this.borderColor=borderColor;

    }
}
