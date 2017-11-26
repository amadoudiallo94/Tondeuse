package com.model;
import com.enums.OrientationEnum;

public class Tondeuse {
    private int xTondeuse;
    private int yTondeuse;
    private OrientationEnum oTondeuse;

    public Tondeuse(int xTondeuse, int yTondeuse, OrientationEnum oTondeuse) {
        this.xTondeuse = xTondeuse;
        this.yTondeuse = yTondeuse;
        this.oTondeuse = oTondeuse;
    }

    public int getxTondeuse() {
        return xTondeuse;
    }
    public void setxTondeuse(int xTondeuse) {
        this.xTondeuse = xTondeuse;
    }
    public int getyTondeuse() {
        return yTondeuse;
    }
    public void setyTondeuse(int yTondeuse) {
        this.yTondeuse = yTondeuse;
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
                "xTondeuse=" + xTondeuse +
                ", yTondeuse=" + yTondeuse +
                ", oTondeuse=" + oTondeuse +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if(o != null && o instanceof Tondeuse) {
            Tondeuse t = (Tondeuse) o;
            return (this.getxTondeuse() == t.getxTondeuse())
                    &&
                    (this.getyTondeuse() == t.getyTondeuse())
                    &&
                    (this.getoTondeuse() == t.getoTondeuse());
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.xTondeuse + this.yTondeuse + this.oTondeuse.hashCode();
    }
}
