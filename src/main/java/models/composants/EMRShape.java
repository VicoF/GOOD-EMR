package models.composants;

import javafx.scene.shape.Shape;

import java.awt.*;

public abstract class EMRShape {

    private EMRCategories categorie;
    private double dimensionA =0.7;
    private int thicknessB =1;
    private int policeSizeC =10;

    public EMRShape(EMRCategories categorie) {
        this.categorie = categorie;
    }

    public EMRShape(EMRCategories categorie, double dimensionA, int thicknessB, int policeSizeC) {
        this.categorie = categorie;
        this.dimensionA = dimensionA;
        this.thicknessB = thicknessB;
        this.policeSizeC = policeSizeC;
    }


    public abstract Shape getShape();

    public EMRCategories getCategorie() {
        return categorie;
    }

    public void setCategorie(EMRCategories categorie) {
        this.categorie = categorie;
    }

    public double getDimensionA() {
        return dimensionA;
    }

    public void setDimensionA(double dimensionA) {
        this.dimensionA = dimensionA;
    }

    public int getThicknessB() {
        return thicknessB;
    }

    public void setThicknessB(int thicknessB) {
        this.thicknessB = thicknessB;
    }

    public int getPoliceSizeC() {
        return policeSizeC;
    }

    public void setPoliceSizeC(int policeSizeC) {
        this.policeSizeC = policeSizeC;
    }
}
