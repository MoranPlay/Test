package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.exception.DeviceValidationException;
import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.Rack;
import com.netcracker.edu.inventory.service.impl.ServiceImpl;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RackArrayImpl implements Rack {

    protected static final Logger log = Logger.getLogger(RackArrayImpl.class.getName());

    protected ServiceImpl services = new ServiceImpl();

    private int size;
    private int freeSize;
    private Device[] devices;
    private final Class type;

    public RackArrayImpl(int size) {
        this(size, Device.class);
    }

    public RackArrayImpl(int size, Class clazz) {
        if(size > 0) {
            this.size = size;
        }
        else {
            this.devices = new Device[0];
            IllegalArgumentException e = new IllegalArgumentException("Size of rack can not be 0 or less.");
            log.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
        if(clazz == null || !Device.class.isAssignableFrom(clazz)) {
            IllegalArgumentException e = new IllegalArgumentException("Type can't be null or not 'Device'");
            log.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
        this.devices = new Device[size];
        this.freeSize = size;
        this.type = clazz;
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
    public Class getTypeOfDevices() {
        return type;
    }

    @Override
    public Device getDevAtSlot(int index) {
        if (checkIndex(index)) return devices[index];
        return null;
    }

    @Override
    public boolean insertDevToSlot(Device device, int index) {
        checkIndex(index);
        if (services.isValidDeviceForInsertToRack(device)) {
            if (checkValid(device)) {
                if (devices[index] == null) {
                    devices[index] = device;
                    freeSize--;

                    return true;
                }
            }
        } else {
            DeviceValidationException e = new DeviceValidationException("Rack.insertDevToSlot", device);
            log.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        } return false;
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

    @Override
    public Device[] getAllDeviceAsArray() {
        int countNullCell = 0;
        for (Device device : devices) {
            if (device == null) countNullCell++;
        }
        Device[] allDevices = new Device[size-countNullCell];
        int j = 0;
        for (Device device : devices) {
            if (device != null) {
                allDevices[j] = device;
                j++;
            }
        }
        return allDevices;
    }

    public boolean checkValid(Device device) {
        if (type == null) return true;
        if(type.isAssignableFrom(device.getClass())) return true;
        IllegalArgumentException e = new IllegalArgumentException("Type is incompatible");
        log.log(Level.SEVERE, e.getMessage(), e);
        throw e;
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

