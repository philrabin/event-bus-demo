package com.uber.eventbusdemo.event;

public class DeviceEvent {

    private String mDevice;

    public DeviceEvent(String device) {
        mDevice = device;
    }

    public String getDevice() {
        return mDevice;
    }
}
