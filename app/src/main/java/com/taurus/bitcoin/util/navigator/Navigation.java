package com.taurus.bitcoin.util.navigator;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.AnimRes;
import android.support.annotation.NonNull;
import android.support.v4.util.Pair;

public class Navigation {


    private Activity activity;
    private Intent intent;
    private Pair<Integer, Integer> animationPair;
    private int requestCode;
    private boolean forResult = false;

    Navigation(@NonNull Activity context, @NonNull Intent intent) {
        this.activity = context;
        this.intent = intent;
    }

    public void navigate() {
        if (forResult) {
            activity.startActivityForResult(intent, requestCode);
        } else {
            activity.startActivity(intent);
        }
        if (animationPair != null) {
            activity.overridePendingTransition(animationPair.first, animationPair.second);
        }
    }

    public Navigation forResult(int requestCode) {
        forResult = true;
        this.requestCode = requestCode;
        return this;
    }

    public Navigation clearBackStack() {
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        return this;
    }

    public Navigation singleTop() {
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        return this;
    }

    public Navigation clearTop() {
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return this;
    }

    public Navigation withAnimation(@AnimRes int enterAnim, @AnimRes int exitAnim) {
        animationPair = Pair.create(enterAnim, exitAnim);
        return this;
    }

}
