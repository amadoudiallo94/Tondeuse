package com.core;

import com.enums.OrientationEnum;
import com.model.Grille;
import com.model.Tondeuse;
import com.service.TondeuseUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestTondeuse {

    private TondeuseUtils tondeuseUtils;
    private Tondeuse tondeuse;
    private Grille grille;

    @Before
    public void beforeTest(){
        tondeuseUtils = new TondeuseUtils();
        grille = new Grille(5, 5);
    }

    @Test
    public void test1(){
        tondeuse = new Tondeuse(1, 2, OrientationEnum.valueOf("N"));
        Tondeuse resultExpected = new Tondeuse(1, 3, OrientationEnum.N);
        Tondeuse result = tondeuseUtils.executeInstructions(tondeuse, grille, "GAGAGAGAA");
        Assert.assertEquals(resultExpected, result);
    }

    @Test
    public void test2(){
        tondeuse = new Tondeuse(3, 3, OrientationEnum.valueOf("E"));
        Tondeuse resultExpected = new Tondeuse(5, 1, OrientationEnum.E);
        Tondeuse result = tondeuseUtils.executeInstructions(tondeuse, grille, "AADAADADDA");
        Assert.assertEquals(resultExpected, result);
    }
}
