package com.netcracker.edu.inventory.model.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by makovetskyi on 05.10.16.
 */
public class WifiRouterTest {

    WifiRouter defaultWifiRouter;

    String securityProtocol = "";

    @Before
    public void before() throws Exception {
        defaultWifiRouter = new WifiRouter();
    }

    @After
    public void after() throws Exception {
        defaultWifiRouter = null;
    }

    @Test
    public void setGetSecurityProtocol() throws Exception {
        defaultWifiRouter.setSecurityProtocol(securityProtocol);
        String result = defaultWifiRouter.getSecurityProtocol();

        assertEquals(securityProtocol, result);
    }

}