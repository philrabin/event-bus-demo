package com.uber.eventbusdemo.service;

import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import com.uber.eventbusdemo.BusProvider;
import com.uber.eventbusdemo.event.DeviceEvent;

public class MyDeviceService {

    private final Bus mBus;
    private String mDevice;

    public MyDeviceService() {
        mBus = BusProvider.getInstance();
        mBus.register(this);
    }

    @Produce
    public DeviceEvent produceDeviceEvent() {
        if (mDevice != null) {
            return new DeviceEvent(mDevice);
        }
        return null;
    }

    public void setDevice(String device) {
        mDevice = device;
        mBus.post(produceDeviceEvent());
    }
}
