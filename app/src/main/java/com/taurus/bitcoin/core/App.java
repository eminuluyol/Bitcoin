package com.taurus.bitcoin.core;

import android.app.Application;

import com.taurus.bitcoin.core.injection.Injector;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Injector.getInstance().createApplicationScope(this);

    }
}
