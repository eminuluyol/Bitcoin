package com.taurus.bitcoin.core;

import android.app.Application;

import net.danlew.android.joda.JodaTimeAndroid;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Injector.getInstance().createApplicationScope(this);

        JodaTimeAndroid.init(this);

    }
}
