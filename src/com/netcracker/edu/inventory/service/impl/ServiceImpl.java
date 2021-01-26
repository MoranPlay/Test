package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.service.Service;

public class ServiceImpl implements Service {

    @Override
    public void sortByIN(Device[] devices) {
        for (int i = 0; i < devices.length - 1; i++) {
            for (int j = 0; j < devices.length - i - 1; j++) {
                if (devices[j + 1] != null
                        && (devices[j] == null
                        || (devices[j + 1].getIn() != 0
                        && (devices[j].getIn() == 0
                        || (devices[j].getIn() > devices[j + 1].getIn()))))) {
                    Device temp = devices[j];
                    devices[j] = devices[j + 1];
                    devices[j + 1] = temp;
                }
            }
        }
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
}
