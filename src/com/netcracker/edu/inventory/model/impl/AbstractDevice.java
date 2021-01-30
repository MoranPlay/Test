package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.Device;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class AbstractDevice implements Device {

    protected int in;
    protected String type;
    protected String manufacturer;
    protected String model;
    protected Date productionDate;

    protected static Logger log = Logger.getLogger(AbstractDevice.class.getName());


    @Override
    public int getIn() {
        return in;
    }

    @Override
    public void setIn(int in) {
        if (getIn() == 0) {
            if (in <= 0) {
                IllegalArgumentException e = new IllegalArgumentException("In can not be negative");
                log.log(Level.SEVERE, e.getMessage(), e);
                throw e;
            }
            else this.in = in;
        } else {
            log.log(Level.WARNING,"Inventory number can not be reset");
        }
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public Date getProductionDate() {
        return productionDate;
    }

    @Override
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }
}

