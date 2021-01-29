package com.netcracker.edu.inventory.exception;

import com.netcracker.edu.inventory.model.Device;

public class DeviceValidationException extends RuntimeException {
    Device device;
    protected static final String DEFAULT_MESSAGE = "Device is not valid for operation";
    public Device getDevice (){
        return device;
    }
    public DeviceValidationException(){
        super();
    }
    public DeviceValidationException(String operation){
        super(operation != null ? (DEFAULT_MESSAGE + " " + operation) : (DEFAULT_MESSAGE));
    }
    public DeviceValidationException(String operation, Device device){
        this(operation);
        this.device = device;
    }

}