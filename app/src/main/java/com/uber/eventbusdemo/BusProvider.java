package com.uber.eventbusdemo;

import com.squareup.otto.Bus;

public class BusProvider {

    private static Bus sBus;

    public static Bus getInstance() {
        if (sBus == null) {
            sBus = new Bus();
        }
        return sBus;
    }
}
