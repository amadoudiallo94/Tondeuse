package com.core;
import com.enums.OrientationEnum;
import com.model.Tondeuse;
import com.service.FonctionsUtils;
import com.service.TondeuseUtils;

public class App {
    public static void main(String... args){
        // Initialisation de la grille
        TondeuseUtils tu = new TondeuseUtils(5, 5);
        // Première tondeuse
        Tondeuse t1 = new Tondeuse(1, 2, FonctionsUtils.getEnumByString(OrientationEnum.class, "N"));
        tu.showTondeuse(t1, "GAGAGAGAA");
        // Deuxième tondeuse
        Tondeuse t2 = new Tondeuse(3, 3, FonctionsUtils.getEnumByString(OrientationEnum.class, "E"));
        tu.showTondeuse(t2, "AADAADADDA");
    }
}
