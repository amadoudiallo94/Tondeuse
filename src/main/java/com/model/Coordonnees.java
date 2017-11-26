package com.model;

/**
 * Created by amadoudiallo on 26/11/17.
 */
public class Coordonnees {
    private int x;
    private int y;

    public Coordonnees(Coordonnees coordonnees){
        this(coordonnees.getX(), coordonnees.getY());
    }

    public Coordonnees(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordonnees that = (Coordonnees) o;

        if (x != that.x) return false;
        return y == that.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
