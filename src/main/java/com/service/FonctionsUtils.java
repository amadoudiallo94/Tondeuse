package com.service;

import com.enums.OrientationEnum;

/**
 * Created by amadoudiallo on 09/10/17.
 */
public class FonctionsUtils {

    /**
     * Récupérer un enum via un String
     * @param e
     * @param s
     * @param <T>
     * @return
     */
    public static <T extends Enum<T>> T getEnumByString(Class<T> e, String s){
        for (T t : e.getEnumConstants()) {
            if(s.equals(t.name())){
                return t;
            }
        }
        return null;
    }
}
