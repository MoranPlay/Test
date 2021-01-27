package com.netcracker.edu.inventory.model.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by makovetskyi on 05.10.16.
 */
public class SwitchTest {

    Switch defaultSwitch;

    int numberOfPorts = 0;

    @Before
    public void before() throws Exception {
        defaultSwitch = new Switch();
    }

    @After
    public void after() throws Exception {
        defaultSwitch = null;
    }

    @Test
    public void setGetNumberOfPorts() throws Exception {
        defaultSwitch.setNumberOfPorts(numberOfPorts);
        int result = defaultSwitch.getNumberOfPorts();

        assertEquals(numberOfPorts, result);
    }

}