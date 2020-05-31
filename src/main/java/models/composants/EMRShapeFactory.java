package models.composants;

import java.awt.*;

/**
 * Factory permetant de générer des composants
 */
public class EMRShapeFactory {

    public enum EMRShapeType {
        INVERSION_ACCUMULATION,INVERSION_CONVERSION,INVERSION_COUPLING
    }


    /**
     * Méthode permettant de recevoir un composant du bon type en lui spécifiant celui-ci
     * @param type Le type de composant
     * @param categorie La categorie de composant
     * @param posX Position en X du coin supérieur gauche du composant
     * @param posY Position en Y du coin supérieur gauche du composant
     * @return La EMRShape générée
     */
   public static EMRShape getComposant(EMRShapeType type, EMRCategories categorie, double posX, double posY){
        switch (type){
            case INVERSION_ACCUMULATION:
                return new InversionAccumulationShape(categorie,posX, posY);
            case INVERSION_CONVERSION:
                return new InversionConversionShape(categorie,posX, posY);
            case INVERSION_COUPLING:
                return new InversionCouplingShape(categorie,posX, posY);
            default:
                throw new UnsupportedOperationException("Ce type de composant n'est pas pris en charge par la factory");
        }
   }




}
