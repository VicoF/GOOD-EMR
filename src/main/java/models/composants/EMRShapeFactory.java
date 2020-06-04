package models.composants;

/**
 * Factory permetant de générer des composants
 * Cette classe impl�mente le design pattern "Factory Pattern"
 *
 *   @author Williams
 *
 */
public class EMRShapeFactory {

    public enum ComposantType {
        INVERSION_ACCUMULATION,INVERSION_CONVERSION,INVERSION_COUPLING, ENERGY_BASED_CONVERSION_SQUARE,
        ENERGY_BASED_CONVERSION_CIRCLE, ENERGY_BASED_CONVERSION_COUPLING_CIRCLE, ENERGY_BASED_CONVERSION_COUPLING_SQUARE,
        ENERGY_SOURCE_SHAPE
    }

    public enum ArrowType{
        SIGNAL_ARROW,POWER_ARROW
    }


    /**
     * Méthode permettant de recevoir un composant du bon type en lui spécifiant celui-ci
     * @param type Le type de composant
     * @param categorie La categorie de composant
     * @param posX Position en X du coin supérieur gauche du composant
     * @param posY Position en Y du coin supérieur gauche du composant
     * @return La EMRShape générée
     */
   public static EMRShape getComposant(ComposantType type, EMRCategories categorie, double posX, double posY){
        switch (type){
            case INVERSION_ACCUMULATION:
                return new InversionAccumulationShape(categorie,posX, posY);
            case INVERSION_CONVERSION:
                return new InversionConversionShape(categorie,posX, posY);
            case INVERSION_COUPLING:
                return new InversionCouplingShape(categorie,posX, posY);
            case ENERGY_BASED_CONVERSION_SQUARE:
                return new ConversionShapeSquare(categorie,posX,posY);
            case ENERGY_BASED_CONVERSION_CIRCLE:
                return new ConversionShapeCircle(categorie,posX,posY);
            case ENERGY_BASED_CONVERSION_COUPLING_CIRCLE:
                return new ConversionShapeCouplingCircle(categorie,posX,posY);
            case ENERGY_BASED_CONVERSION_COUPLING_SQUARE:
                return new ConversionShapeCouplingSquare(categorie, posX, posY);
            case ENERGY_SOURCE_SHAPE:
                return new EnergySourceShape(categorie, posX, posY);
            default:
                throw new UnsupportedOperationException("Ce type de composant n'est pas pris en charge par la factory");
        }
   }

   public static Arrow getArrow(ArrowType type, EMRCategories categorie, double sourcePosX, double sourcePosY, double targetPosX, double targetPosY){
       switch(type){
           case SIGNAL_ARROW:
               return new SignalArrow(categorie,sourcePosX,sourcePosY,targetPosX,targetPosY);
           case POWER_ARROW:
               return new PowerArrow(categorie,sourcePosX,sourcePosY,targetPosX,targetPosY);
           default:
               throw new UnsupportedOperationException("Ce type de fleche n'est pas pris en charge par la factory");
       }
   }




}
