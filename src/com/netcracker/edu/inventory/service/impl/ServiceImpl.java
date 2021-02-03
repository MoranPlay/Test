package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.service.Service;

import java.util.Arrays;
import java.util.Comparator;

public class ServiceImpl implements Service {

    @Override
    public void sortByIN(Device[] devices) {
        Arrays.sort(devices, new Comparator<Device>() {
            @Override
            public int compare(Device o1, Device o2) {
                if(o2 == null || (o1 != null && o2.getIn() == 0)) {
                    return -1;
                }
                if(o1 == null || o1.getIn() == 0) {
                    return 1;
                }
                return o1.getIn() - (o2.getIn());
            }
        });
    }

    @Override
    public void sortByProductionDate(Device[] devices) {
        Arrays.sort(devices, new Comparator<Device>() {
            @Override
            public int compare(Device o1, Device o2) {
                if(o2 == null || (o1 != null && o2.getProductionDate() == null)) {
                    return -1;
                }
                if(o1 == null || o1.getProductionDate() == null) {
                    return 1;
                }
                return o1.getProductionDate().compareTo(o2.getProductionDate());
            }
        });
    }

    @Override
    public void filtrateByType(Device[] devices, String type) {
        for (int i = 0; i<devices.length; i++) {
            if (devices[i] != null && type != null) {
                if (devices[i].getType() == null) devices[i] = null;
                else if (!devices[i].getType().equalsIgnoreCase(type)) devices[i] = null;
            }
            if (devices[i] != null && type == null) {
                if (devices[i].getType() != null) devices[i] = null;
            }
        }
    }

    @Override
    public void filtrateByManufacturer(Device[] devices, String manufacturer) {
        for(int i=0; i<devices.length; i++){
            if (devices[i] != null && manufacturer != null){
                if (devices[i].getManufacturer() == null) devices[i] = null;
                else if (!devices[i].getManufacturer().equalsIgnoreCase(manufacturer)) devices[i] = null;
            }
            if (devices[i] != null && manufacturer == null) {
                if (devices[i].getManufacturer() != null) devices[i] = null;
            }
        }
    }

    @Override
    public void filtrateByModel(Device[] devices, String model) {
        for(int i=0; i<devices.length; i++){
            if (devices[i] != null && model != null){
                if (devices[i].getModel() == null) devices[i] = null;
                else if (!devices[i].getModel().equalsIgnoreCase(model)) devices[i] = null;
            }
            if (devices[i] != null && model == null) {
                if (devices[i].getModel() != null) devices[i] = null;
            }
        }
    }

    @Override
    public boolean isValidDeviceForInsertToRack(Device device) {
        if (device == null) return false;
        return  device.getIn() > 0;
    }
}
