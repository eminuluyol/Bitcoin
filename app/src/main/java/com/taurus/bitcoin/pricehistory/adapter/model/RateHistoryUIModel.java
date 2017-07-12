package com.taurus.bitcoin.pricehistory.adapter.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.taurus.bitcoin.baseadapter.model.GenericItem;
import com.taurus.bitcoin.network.model.pricehistory.History;
import com.taurus.bitcoin.util.ListConverter;

import java.util.List;

public class RateHistoryUIModel extends GenericItem implements Parcelable {

    private String time;
    private String average;

    public RateHistoryUIModel() {
    }

    protected RateHistoryUIModel(Parcel in) {
        super(in);
        time = in.readString();
        average = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(time);
        dest.writeString(average);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RateHistoryUIModel> CREATOR = new Creator<RateHistoryUIModel>() {
        @Override
        public RateHistoryUIModel createFromParcel(Parcel in) {
            return new RateHistoryUIModel(in);
        }

        @Override
        public RateHistoryUIModel[] newArray(int size) {
            return new RateHistoryUIModel[size];
        }
    };

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public static List<RateHistoryUIModel> createList(List<History> rateHistoryList) {
        return ListConverter.convert(rateHistoryList, item -> create(item));
    }

    private static RateHistoryUIModel create(History item) {

        final RateHistoryUIModel model = new RateHistoryUIModel();

        model.setAverage(String.valueOf(item.getAverage()));
        model.setTime(item.getTime());

        return model;
    }
}
