package com.taurus.bitcoin.core.injection;

import android.app.Application;

import com.taurus.bitcoin.network.BitCoinApi;
import com.taurus.bitcoin.network.retrofit.RetrofitBitCoinApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public BitCoinApi provideBitCoinApi() {
        return new RetrofitBitCoinApi();
    }

}
