package models.composants;

import java.awt.*;

public abstract class Composant {
    private int posX;
    private int posY;
    private int dimensionX;
    private int dimensionY;
    private Color backgroundColor;
    private Color borderColor;

    public Composant(int posX, int posY, int dimensionX, int dimensionY, Color backgroundColor, Color borderColor) {
        this.posX = posX;
        this.posY = posY;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }


    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getDimensionX() {
        return dimensionX;
    }

    public void setDimensionX(int dimensionX) {
        this.dimensionX = dimensionX;
    }

    public int getDimensionY() {
        return dimensionY;
    }

    public void setDimensionY(int dimensionY) {
        this.dimensionY = dimensionY;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
}
