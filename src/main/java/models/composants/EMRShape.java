package models.composants;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public abstract class EMRShape implements Drawable{

    private EMRCategories categorie;
    private double dimensionA =20;
    private int thicknessB =1;
    private int policeSizeC =10;
    private double posX=0;
    private double posY=0;


    public EMRShape(EMRCategories categorie) {
        this.categorie = categorie;
    }

    public EMRShape(EMRCategories categorie, double posX, double posY) {
        this.categorie = categorie;
        this.posX = posX;
        this.posY = posY;
    }

    public EMRShape(EMRCategories categorie, double dimensionA, double posX, double posY) {
        this.categorie = categorie;
        this.dimensionA = dimensionA;
        this.posX = posX;
        this.posY = posY;
    }

    public EMRShape(EMRCategories categorie, double dimensionA, int thicknessB, int policeSizeC, double posX, double posY) {
        this.categorie = categorie;
        this.dimensionA = dimensionA;
        this.thicknessB = thicknessB;
        this.policeSizeC = policeSizeC;
        this.posX = posX;
        this.posY = posY;
    }


    public abstract boolean pointIsInsideShape(double coordX, double coordY);

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

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    @Override
    public abstract EMRShape clone();
}
