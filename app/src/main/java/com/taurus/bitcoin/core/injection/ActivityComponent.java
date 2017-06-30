package com.taurus.bitcoin.core.injection;

import com.taurus.bitcoin.core.NoOpPresenter;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(NoOpPresenter noOpPresenter);

}
