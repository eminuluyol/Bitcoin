package com.taurus.bitcoin.baseadapter;

import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate;
import com.taurus.bitcoin.baseadapter.viewholder.BaseViewHolder;
import com.taurus.bitcoin.listener.OnItemClickListener;

public abstract class BaseAdapterDelegate<I extends T, T, VH extends BaseViewHolder>
        extends AbsListItemAdapterDelegate<I, T, VH> {

    private OnItemClickListener onItemClickListener;

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

}
