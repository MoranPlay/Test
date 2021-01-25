package com.netcracker.edu.inventory.model.impl;

public class Battery extends AbstractDevice {

    protected int chargeVolume;

    public int getChargeVolume() {
        return chargeVolume;
    }

    public void setChargeVolume(int chargeVolume) {
        this.chargeVolume = chargeVolume;
    }

}
