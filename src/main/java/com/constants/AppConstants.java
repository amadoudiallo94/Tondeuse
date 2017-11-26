package com.constants;
import com.enums.OrientationEnum;

import java.util.HashMap;
import java.util.Map;

public class AppConstants {
    public final static String MOVE_G =  "G";
    public final static String MOVE_D =  "D";
    public final static String MOVE_A =  "A";

    public final static String INSTRUCTIONS_SPLIT = "";

    public final static int INC_VALUE = 1;

    public final static int IND_TAB_G = 0;
    public final static int IND_TAB_D = 1;

    public static Map<OrientationEnum, OrientationEnum[]> initialize(){
        Map<OrientationEnum, OrientationEnum[]> map = new HashMap();
        OrientationEnum[][] oo = {
                // G                 // D
                {OrientationEnum.W,OrientationEnum.E},
                {OrientationEnum.N,OrientationEnum.S},
                {OrientationEnum.E,OrientationEnum.W},
                {OrientationEnum.S,OrientationEnum.N}
        };
        map.put(OrientationEnum.N, oo[0]);
        map.put(OrientationEnum.E, oo[1]);
        map.put(OrientationEnum.S, oo[2]);
        map.put(OrientationEnum.W, oo[3]);
        return map;
    }
}
