package com.model;

/**
 * Created by amadoudiallo on 26/11/17.
 */
public class Grille {

    private final int sizeXInit = 0;
    private final int sizeYInit = 0;
    private int sizeXMax;
    private int sizeYMax;

    public Grille(int sizeXMax, int sizeYMax) {
        this.sizeXMax = sizeXMax;
        this.sizeYMax = sizeYMax;
    }

    public int getSizeXInit() {
        return sizeXInit;
    }

    public int getSizeYInit() {
        return sizeYInit;
    }

    public int getSizeXMax() {
        return sizeXMax;
    }

    public void setSizeXMax(int sizeXMax) {
        this.sizeXMax = sizeXMax;
    }

    public int getSizeYMax() {
        return sizeYMax;
    }

    public void setSizeYMax(int sizeYMax) {
        this.sizeYMax = sizeYMax;
    }
}
