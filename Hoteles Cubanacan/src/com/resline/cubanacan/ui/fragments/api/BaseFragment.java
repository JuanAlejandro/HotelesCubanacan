package com.resline.cubanacan.ui.fragments.api;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment {
    // TODO: Contexto que se puede usar en cualquier clase?
    protected Context mContext;
    protected Activity mActivity;
    protected Resources mResources;
    protected boolean lowerApi;
    protected String TAG;
    protected Bundle mBundle;

    public BaseFragment() {
        super();
        TAG = this.getClass().getName();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
        this.mContext = mActivity.getApplicationContext();
        this.mResources = mActivity.getResources();

        loadPreferencesAndBundle();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void loadPreferencesAndBundle(){
        this.mBundle = getArguments();
    }
}
