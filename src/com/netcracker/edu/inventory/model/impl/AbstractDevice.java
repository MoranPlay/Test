package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.Device;

import java.util.Date;

public abstract class AbstractDevice implements Device {

    protected int in;
    protected String type, manufacturer, model;
    protected Date productionDate;

    @Override
    public int getIn() {
        return in;
    }

    @Override
    public void setIn(int in) {
        if (getIn() == 0) {
            if (in <= 0) System.err.println("Can't be less or equals 0.");
            else this.in = in;
        } else System.err.println("in is already installed");
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

