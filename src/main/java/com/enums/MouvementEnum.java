package com.enums;

import com.exceptions.MouvementException;

/**
 * Created by amadoudiallo on 09/10/17.
 */
public enum MouvementEnum {
    G, D, A;

    public static MouvementEnum getMouvement(String mouvement) throws MouvementException {
        MouvementEnum m;
        try{
            m = MouvementEnum.valueOf(mouvement);
        }catch (IllegalArgumentException e) {
            throw new MouvementException("Le mouvement " + mouvement + " n'est pas autorisé");
        }
        return m;
    }
}
