package com.service;
import com.constants.AppConstants;
import com.enums.MouvementEnum;
import com.exceptions.MouvementException;
import com.model.Tondeuse;
import java.util.Arrays;

public class TondeuseUtils {

    private final int sizeXInit = 0;
    private final int sizeYInit = 0;
    private final int sizeXMax;
    private final int sizeYMax;

    /**
     *
     * @param sizeXMax
     * @param sizeYMax
     */
    public TondeuseUtils(int sizeXMax, int sizeYMax) {
        this.sizeXMax = sizeXMax;
        this.sizeYMax = sizeYMax;
    }

    /**
     * Mouvements de la tondeuse suivant la série d'instructions
     *
     * @param tondeuse
     * @param instruction
     */
    public void executeInstructions(final Tondeuse tondeuse, String instruction) {
            Arrays.asList(instruction.split(AppConstants.INSTRUCTIONS_SPLIT)).forEach(m -> {
                try {
                    this.moveTondeuse(tondeuse, m);
                } catch (MouvementException e) {
                    System.out.println(e.getMessage());
                }
            });
    }

    /**
     * Mise à jour des coordonées ou de l'orientation de la tondeuse
     *
     * @param tondeuse
     * @param mouvement
     */
    private void moveTondeuse(Tondeuse tondeuse, String mouvement) throws MouvementException {
        MouvementEnum m = MouvementEnum.getMouvement(mouvement);
        if (MouvementEnum.D.equals(m) || MouvementEnum.G.equals(m)) {
            moveOrientation(tondeuse, mouvement);
        } else if (MouvementEnum.A.equals(m)) {
            movePosition(tondeuse);
        }
    }

    /**
     * Changement de l'orientation
     *
     * @param tondeuse
     * @param mouvement
     */
    private void moveOrientation(Tondeuse tondeuse, String mouvement) {
        tondeuse.setoTondeuse(tondeuse.getoTondeuse().getNext(MouvementEnum.valueOf(mouvement)));
    }
    /**
     * Changement de la position
     *
     * @param pTondeuse
     */
    private void movePosition(Tondeuse pTondeuse) {
        switch (pTondeuse.getoTondeuse()) {
            case N: pTondeuse.setyTondeuse(Math.min(pTondeuse.getyTondeuse() + AppConstants.INC_VALUE, this.sizeYMax)); break;
            case S: pTondeuse.setyTondeuse(Math.max(pTondeuse.getyTondeuse() - AppConstants.INC_VALUE, this.sizeYInit)); break;
            case W: pTondeuse.setxTondeuse(Math.max(pTondeuse.getxTondeuse() - AppConstants.INC_VALUE, this.sizeXInit)); break;
            case E: pTondeuse.setxTondeuse(Math.min(pTondeuse.getxTondeuse() + AppConstants.INC_VALUE, this.sizeXMax));break;
            default: break;
        }
    }
}