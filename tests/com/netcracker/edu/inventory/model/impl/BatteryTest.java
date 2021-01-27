package com.netcracker.edu.inventory.model.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by makovetskyi on 05.10.16.
 */
public class BatteryTest {

    Battery defaultBattery;

    int chargeVolume = 5;

    @Before
    public void before() throws Exception {
        defaultBattery = new Battery();
    }

    @After
    public void after() throws Exception {
        defaultBattery = null;
    }

    @Test
    public void setGetChargeVolume() throws Exception {
        defaultBattery.setChargeVolume(chargeVolume);
        int result = defaultBattery.getChargeVolume();

        assertEquals(chargeVolume, result);
    }

}