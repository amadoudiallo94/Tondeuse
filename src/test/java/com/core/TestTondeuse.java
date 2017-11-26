package com.core;

import com.enums.OrientationEnum;
import com.model.Tondeuse;
import com.service.TondeuseUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestTondeuse {

    private TondeuseUtils tondeuseUtils;
    private Tondeuse tondeuse;

    @Before
    public void beforeTest(){
        tondeuseUtils = new TondeuseUtils(5, 5);
    }

    @Test
    public void test1(){
        tondeuse = new Tondeuse(1, 2, OrientationEnum.valueOf("N"));
        tondeuseUtils.executeInstructions(tondeuse, "GAGAGAGAA");
        Tondeuse result = new Tondeuse(1, 3, OrientationEnum.N);
        Assert.assertEquals(true, result.equals(tondeuse));
    }

    @Test
    public void test2(){
        tondeuse = new Tondeuse(3, 3, OrientationEnum.valueOf("E"));
        tondeuseUtils.executeInstructions(tondeuse, "AADAADADDA");
        Tondeuse result = new Tondeuse(5, 1, OrientationEnum.E);
        Assert.assertEquals(true, result.equals(tondeuse));
    }
}
