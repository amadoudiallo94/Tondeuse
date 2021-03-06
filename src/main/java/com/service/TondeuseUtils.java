package com.service;
import com.constants.AppConstants;
import com.enums.MouvementEnum;
import com.enums.OrientationEnum;
import com.exceptions.MouvementException;
import com.model.Coordonnees;
import com.model.Grille;
import com.model.Tondeuse;
import java.util.Arrays;

public class TondeuseUtils {

    public TondeuseUtils() {}

    /**
     * Mouvements de la tondeuse suivant la série d'instructions
     *
     * @param tondeuse
     * @param instruction
     */
    public Tondeuse executeInstructions(Tondeuse tondeuse, Grille grille, String instruction) {
            Tondeuse vTondeuse = new Tondeuse(tondeuse);
            Arrays.asList(instruction.split(AppConstants.INSTRUCTIONS_SPLIT)).forEach(m -> {
                try {
                    this.moveTondeuse(vTondeuse, grille, m);
                } catch (MouvementException e) {
                    System.out.println(e.getMessage());
                }
            });
            return vTondeuse;
    }

    /**
     * Mise à jour des coordonées ou de l'orientation de la tondeuse
     *
     * @param tondeuse
     * @param mouvement
     */
    private void moveTondeuse(Tondeuse tondeuse, Grille grille, String mouvement) throws MouvementException {
        MouvementEnum m = MouvementEnum.getMouvement(mouvement);
        if (MouvementEnum.D.equals(m) || MouvementEnum.G.equals(m)) {
            tondeuse.setoTondeuse(moveOrientation(tondeuse.getoTondeuse(), mouvement));
        } else if (MouvementEnum.A.equals(m)) {
            tondeuse.setCoordonnees(movePosition(tondeuse.getCoordonnees(), grille, tondeuse.getoTondeuse()));
        }
    }

    /**
     * Changement de l'orientation
     *
     * @param mouvement
     */
    public OrientationEnum moveOrientation(OrientationEnum orientation, String mouvement) {
        return orientation.getNext(MouvementEnum.valueOf(mouvement));
    }

    /**
     * Changement de la position
     *
     */
    public Coordonnees movePosition(Coordonnees coordonnees, Grille grille, OrientationEnum orientation) {
        Coordonnees vCoordonnees = new Coordonnees(coordonnees);
        switch (orientation) {
            case N: vCoordonnees.setY(Math.min(coordonnees.getY() + AppConstants.INC_VALUE, grille.getSizeYMax())); break;
            case S: vCoordonnees.setY(Math.max(coordonnees.getY() - AppConstants.INC_VALUE, grille.getSizeYInit())); break;
            case W: vCoordonnees.setX(Math.max(coordonnees.getX() - AppConstants.INC_VALUE, grille.getSizeXInit())); break;
            case E: vCoordonnees.setX(Math.min(coordonnees.getX() + AppConstants.INC_VALUE, grille.getSizeXMax()));break;
            default: break;
        }
        return vCoordonnees;
    }
}