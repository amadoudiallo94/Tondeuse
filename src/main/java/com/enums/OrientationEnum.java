package com.enums;

public enum OrientationEnum {
    N, S, E, W;

    private OrientationEnum gauche;
    private OrientationEnum droit;

    static{
        N.gauche = OrientationEnum.W;
        N.droit = OrientationEnum.E;

        S.gauche = OrientationEnum.E;
        S.droit = OrientationEnum.W;

        E.gauche = OrientationEnum.N;
        E.droit = OrientationEnum.S;

        W.gauche = OrientationEnum.S;
        W.droit = OrientationEnum.N;
    }

    public OrientationEnum getNext(MouvementEnum mouvement){
        return (mouvement == MouvementEnum.G) ? gauche : droit;
    }
}
