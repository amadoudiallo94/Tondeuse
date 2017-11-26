package com.service;
import com.constants.AppConstants;
import com.enums.MouvementEnum;
import com.enums.OrientationEnum;
import com.model.Tondeuse;
import java.util.Arrays;
import java.util.Map;

public class TondeuseUtils {

    private final int sizeXInit = 0, sizeXMax, sizeYInit = 0, sizeYMax;
    private Map<OrientationEnum, OrientationEnum[]> mapOrientation = AppConstants.initialize();

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
     * Affichage des informations initiales de la tondeuse
     * Mouvements de la tondeuse suivant la série d'instructions
     * Affichage des informations finales de la tondeuse
     *
     * @param tondeuse
     * @param instruction
     */
    public void showTondeuse(final Tondeuse tondeuse, String instruction) {
        System.out.println(tondeuse);
        Arrays.asList(instruction.split(AppConstants.INSTRUCTIONS_SPLIT)).forEach(m -> this.moveTondeuse(tondeuse, m));
        System.out.println(tondeuse);
    }

    /**
     * Mise à jour des coordonées ou de l'orientation de la tondeuse
     *
     * @param tondeuse
     * @param mouvement
     */
    private void moveTondeuse(Tondeuse tondeuse, String mouvement) {
        if (mouvement.equals(AppConstants.MOVE_D) || mouvement.equals(AppConstants.MOVE_G)) {
            moveOrientation(tondeuse, mouvement);
        } else if (mouvement.equals(AppConstants.MOVE_A)) {
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
        switch (FonctionsUtils.getEnumByString(MouvementEnum.class, mouvement)) {
            case D: tondeuse.setoTondeuse(this.mapOrientation.get(tondeuse.getoTondeuse())[AppConstants.IND_TAB_D]); break;
            case G: tondeuse.setoTondeuse(this.mapOrientation.get(tondeuse.getoTondeuse())[AppConstants.IND_TAB_G]); break;
            default: break;
        }
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