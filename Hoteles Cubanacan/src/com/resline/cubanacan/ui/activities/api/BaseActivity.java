package com.resline.cubanacan.ui.activities.api;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Juan Alejandro on 20/1/2016.
 * Base activity for those activities that inherits from AppCompatActivity
 */
public abstract class BaseActivity extends AppCompatActivity {
    // context
    protected Context mContext;
    // activity
    protected Activity mActivity;
    // resources
    protected Resources mResources;
    // toolbar
    protected Toolbar mToolBar;
    // action bar
    protected ActionBar mActionBar;

    // mBundle
    protected Bundle mBundle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutResourceIdentifier());

        mContext = getApplicationContext();

        mActivity = this;

        mResources = getResources();

        // in supportv7 toolbar is the action bar
        mToolBar = getLayoutResourceToolBar();

        mToolBar.setTitle(getTitleToolBar());

        setSupportActionBar(mToolBar);

        mActionBar = getSupportActionBar();

        // init prefEditor and bundle
        loadPreferencesAndBundle();
    }

    protected abstract int getLayoutResourceIdentifier();

    protected abstract String getTitleToolBar();

    protected abstract Toolbar getLayoutResourceToolBar();

    public void loadPreferencesAndBundle() {
        mBundle = (getIntent() != null) ? getIntent().getExtras() : new Bundle();
    }
}
