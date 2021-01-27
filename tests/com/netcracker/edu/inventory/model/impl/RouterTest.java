package com.netcracker.edu.inventory.model.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oleksandr on 05.10.16.
 */
public class RouterTest {

    Router defaultRouter;

    int dataRate = 0;

    @Before
    public void before() throws Exception {
        defaultRouter = new Router();
    }

    @After
    public void after() throws Exception {
        defaultRouter = null;
    }

    @Test
    public void setGetDataRate() throws Exception {
        defaultRouter.setDataRate(dataRate);
        int result = defaultRouter.getDataRate();

        assertEquals(dataRate, result);
    }

}