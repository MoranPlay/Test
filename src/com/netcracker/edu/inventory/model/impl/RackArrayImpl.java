package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.Rack;

public class RackArrayImpl implements Rack {

    private int size;
    private int freeSize = 0;
    public Device[] devices;

    public RackArrayImpl(int size) {
        if (size > 0) {
            this.size = size;
            devices = new Device[size];
            freeSize = size;
        } else {
            System.err.println("Размер не может быть меньше 0");
            devices = new Device[0];
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
        else {
            System.err.println("В массиве нет такого индекса");
            return null;
        }
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
                System.err.println("Device IN less or equals 0");
            }
        }
        System.err.println("Index out of bounds or device = null");
        return false;
    }

    @Override
    public Device removeDevFromSlot(int index) {
        if (checkIndex(index) && devices[index] != null) {
            Device temp = devices[index];
            devices[index] = null;
            return temp;
        } else {
            System.err.println("В массиве нет такого индекса или устроиства не существует");
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
        return index >= 0 && index < size;
    }
}

