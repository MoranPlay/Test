package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.exception.DeviceValidationException;
import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.Rack;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RackArrayImpl implements Rack {

    protected static Logger log = Logger.getLogger(RackArrayImpl.class.getName());

    private int size;
    private int freeSize;
    public Device[] devices;

    public RackArrayImpl(int size) {
        if (size > 0) {
            this.size = size;
            devices = new Device[size];
            freeSize = size;
        } else {
            IllegalArgumentException e = new IllegalArgumentException(" Size of rack can not be 0 or less ");
            log.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getFreeSize() {
        return freeSize;
    }

    @Override
    public Device getDevAtSlot(int index) {
        if (checkIndex(index)) return devices[index];
        return null;
    }

    @Override
    public boolean insertDevToSlot(Device device, int index) {
        if (device != null && checkIndex(index)) {
            if (device.getIn() > 0) {
                if (devices[index] == null) {
                    devices[index] = device;
                    freeSize--;

                    return true;
                }
            } else {
                DeviceValidationException e = new DeviceValidationException("Rack.insertDevToSlot", device);
                log.log(Level.SEVERE,e.getMessage(),e);
                throw e;
            }
        }
        return false;
    }

    @Override
    public Device removeDevFromSlot(int index) {
        checkIndex(index);
        if (devices[index] != null) {
            Device temp = devices[index];
            devices[index] = null;
            return temp;
        } else {
            log.log(Level.WARNING, "Can not remove from empty slot " + index);
            return null;
        }
    }

    @Override
    public Device getDevByIN(int in) {
        for (Device device : devices) {
            if (device != null) {
                if (device.getIn() == in) return device;
            }
        }
        return null;
    }

    public boolean checkIndex(int index) {
        if(index >= 0 && index < size) {
            return true;
        } else {
            IndexOutOfBoundsException e = new IndexOutOfBoundsException("Index must be from 0 to " + size + "; current index = " + index);
            log.log(Level.SEVERE,e.getMessage(),e);
            throw e;
        }
    }
}

