package models.composants;

import javafx.scene.canvas.GraphicsContext;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InversionAccumulationShape extends EMRShape {
    public InversionAccumulationShape(EMRCategories categorie) {
        super(categorie);
    }

    public InversionAccumulationShape(EMRCategories categorie, double posX, double posY) {
        super(categorie, posX, posY);
    }

    public InversionAccumulationShape(EMRCategories categorie, double dimensionA, double posX, double posY) {
        super(categorie, dimensionA, posX, posY);
    }

    public InversionAccumulationShape(EMRCategories categorie, double dimensionA, int thicknessB, int policeSizeC, double posX, double posY) {
        super(categorie, dimensionA, thicknessB, policeSizeC, posX, posY);
    }

    @Override
    public boolean pointIsInsideShape(double coordX, double coordY) {
        //Transforme le array de double en List de double
        List<Double> xCoords = Arrays.stream(getXCoords()).boxed().collect(Collectors.toList());
        List<Double> yCoords = Arrays.stream(getYCoords()).boxed().collect(Collectors.toList());

        double maxX = Collections.max(xCoords);
        double minX = Collections.min(xCoords);

        double maxY = Collections.max(yCoords);
        double minY = Collections.min(yCoords);

        return(coordX>=minX&&coordX<=maxX&&coordY>=minY&&coordY<=maxY);
    }


    private double[] getXCoords() {
        double x = getPosX();
        double a = getDimensionA();
        return new double[]{x, x +(3*a/4), x + ( a / 2),x, x - a/4,x + ( a / 2)};
    }


    private double[] getYCoords() {
        double y = getPosY();
        double a = getDimensionA();
        return new double[]{y, y, y+a,y, y+a,y+a};
    }

   /* @Override
    public Shape getShape(){
        double[] xCoords = getXCoords();
        double[] yCoords = getYCoords();
        ArrayList<Double> coords = new ArrayList<>();
        for(int i = 0; i < xCoords.length; i++){
            coords.add(xCoords[i]);
            coords.add(yCoords[i]);
        }
        Polygon shape = new Polygon();
        shape.getPoints().addAll(coords);
        shape.setStroke(getCategorie().borderColor);
        shape.setFill(getCategorie().backgroundColor);
        return shape;
    }*/

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getCategorie().backgroundColor);
        gc.setStroke(getCategorie().borderColor);
        double[] xCoords = getXCoords();
        double[] yCoords = getYCoords();
        gc.fillPolygon(xCoords,yCoords,xCoords.length);
        gc.strokePolygon(xCoords,yCoords,xCoords.length);
    }

    @Override
    public EMRShape clone() {
        return new InversionAccumulationShape(getCategorie(),getDimensionA(),getThicknessB(),getPoliceSizeC(),getPosX(),getPosY());
    }
}
