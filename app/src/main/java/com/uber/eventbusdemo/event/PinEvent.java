package com.uber.eventbusdemo.event;

public class PinEvent {

    private final String mPin;

    public PinEvent(String pin) {
        mPin = pin;
    }

    public String getPin() {
        return mPin;
    }
}
