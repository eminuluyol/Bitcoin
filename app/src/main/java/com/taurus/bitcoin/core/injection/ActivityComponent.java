package com.taurus.bitcoin.core.injection;

import com.taurus.bitcoin.core.NoOpPresenter;
import com.taurus.bitcoin.currentprice.CurrentPricePresenter;

import com.taurus.bitcoin.pricehistory.PriceHistoryPresenter;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(NoOpPresenter noOpPresenter);

    void inject(CurrentPricePresenter currentPricePresenter);

    void inject(PriceHistoryPresenter priceHistoryPresenter);

}
