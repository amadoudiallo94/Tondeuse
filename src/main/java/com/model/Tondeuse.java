package com.model;
import com.enums.OrientationEnum;

public class Tondeuse {

    private Coordonnees coordonnees;
    private OrientationEnum oTondeuse;

    public Tondeuse(Tondeuse tondeuse){
        this(tondeuse.getCoordonnees(), tondeuse.getoTondeuse());
    }

    public Tondeuse(Coordonnees coordonnees, OrientationEnum oTondeuse) {
        this.coordonnees = coordonnees;
        this.oTondeuse = oTondeuse;
    }

    public Tondeuse(int x, int y, OrientationEnum oTondeuse) {
        this.coordonnees = new Coordonnees(x, y);
        this.oTondeuse = oTondeuse;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public OrientationEnum getoTondeuse() {
        return oTondeuse;
    }
   public void setoTondeuse(OrientationEnum oTondeuse) {
        this.oTondeuse = oTondeuse;
    }

    @Override
    public String toString() {
        return "Tondeuse{" +
                "coordonnees=" + coordonnees +
                ", oTondeuse=" + oTondeuse +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tondeuse tondeuse = (Tondeuse) o;

        if (coordonnees != null ? !coordonnees.equals(tondeuse.coordonnees) : tondeuse.coordonnees != null)
            return false;
        return oTondeuse == tondeuse.oTondeuse;

    }

    @Override
    public int hashCode() {
        int result = coordonnees != null ? coordonnees.hashCode() : 0;
        result = 31 * result + (oTondeuse != null ? oTondeuse.hashCode() : 0);
        return result;
    }
}
