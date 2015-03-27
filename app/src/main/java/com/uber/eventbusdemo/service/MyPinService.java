package com.uber.eventbusdemo.service;

import android.util.Log;

import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;
import com.uber.eventbusdemo.BusProvider;
import com.uber.eventbusdemo.event.DeviceEvent;
import com.uber.eventbusdemo.event.PinEvent;

public class MyPinService {

    private String mPin;
    private final Bus mBus;

    public MyPinService() {
        mBus = BusProvider.getInstance();
        mBus.register(this);
    }

    @Subscribe
    public void onDeviceEvent(DeviceEvent event) {
        Log.d("EVENT", "MyPinService.onDeviceEvent " + event.getDevice());
        setPin(event.getDevice());
    }

    @Produce
    public PinEvent producePinEvent() {
        if (mPin != null) {
            Log.d("EVENT", "MyPinService.producePinEvent");
            return new PinEvent(mPin);
        }
        return null;
    }

    public void setPin(String pin) {
        mPin = pin;
        Log.d("EVENT", "MyPinService.setPin");
        mBus.post(producePinEvent());
    }
}
