package models.composants;

import java.awt.*;

/**
 * Factory permetant de générer des composants
 */
public class ComposantFactory {

    private enum CategorieComposant {
        CONTROL, ARROW
    }
    /**
     * Enum decrivant les différents types de composant pouvant exister ainsi que leur couleur associé
     */
    public enum TypeComposant{

        ENERGY_SOURCE(new Color(152,251,152), new Color(0,128,0), CategorieComposant.CONTROL),
        ENERGY_BASED(new Color(255,215,0),new Color(255,0,0), CategorieComposant.CONTROL),
        MODEL(new Color(238,130,238),new Color(0,0,255), CategorieComposant.CONTROL),
        INVERSION_BASED(new Color(135,206,235),new Color(0,0,255), CategorieComposant.CONTROL),
        STRATEGY(new Color(0,0,255), new Color(0,0,255), CategorieComposant.CONTROL),
        BLACK_ARROW(new Color(0,0,0),new Color(0,0,0), CategorieComposant.ARROW),
        RED_ARROW(new Color(255,0,0),new Color(255,0,0), CategorieComposant.ARROW);

        public Color backgroundColor;
        public Color borderColor;
        public CategorieComposant categorieComposant;

        TypeComposant(Color backgroundColor, Color borderColor, CategorieComposant categorieComposant) {
            this.backgroundColor=backgroundColor;
            this.borderColor=borderColor;
            this.categorieComposant = categorieComposant;
        }
    }

    /**
     * Méthode permettant de recevoir un composant du bon type en lui spécifiant celui-ci
     * @param type Le type de composant
     * @param posX Position en X du coin supérieur gauche du composant
     * @param posY Position en Y du coin supérieur gauche du composant
     * @param dimensionX Largeur du composant
     * @param dimensionY Hauteur du composant
     * @return Le composant généré
     */
   public static Composant getComposant(TypeComposant type,int posX, int posY, int dimensionX, int dimensionY){
        switch (type.categorieComposant){
            case CONTROL:
                return new Control(posX, posY, dimensionX, dimensionY, type.backgroundColor,type.borderColor);
            case ARROW:
                return new Arrow(posX, posY, dimensionX, dimensionY, type.backgroundColor,type.borderColor);
            default:
                throw new UnsupportedOperationException("Ce type de composant n'est pas pris en charge par la factory");
        }
   }




}
