package com.uber.eventbusdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.uber.eventbusdemo.event.DeviceEvent;
import com.uber.eventbusdemo.event.PinEvent;
import com.uber.eventbusdemo.service.MyDeviceService;
import com.uber.eventbusdemo.service.MyPinService;


public class MainActivity extends Activity {

    private Bus mBus = BusProvider.getInstance();
    private MyDeviceService mMyDeviceService = new MyDeviceService();
    private MyPinService mMyPinService = new MyPinService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBus.register(this);
        mMyDeviceService.setDevice("My Device");
    }

    @Subscribe
    public void onDeviceEvent(DeviceEvent event) {
        Log.d("EVENT", "MainActivity.onDeviceEvent " + event.getDevice());
    }

    @Subscribe
    public void onPinEvent(PinEvent event) {
        Log.d("EVENT", "MainActivity.onPinEvent " + event.getPin());
    }
}
