package com.resline.cubanacan.ui.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.activities.api.DrawerActivity;

/**
 * Created by Juan Alejandro on 04/04/2016.
 * Actividad principal donde se llaman los fragments de la app según
 * la sección seleccionada en el drawer
 */
public class MainActivity extends DrawerActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void setToolbar() {
        // in supportv7 toolbar is the action bar
        mToolBar = (Toolbar) findViewById(R.id.screen_default_toolbar);

        mToolBar.setTitle(mResources.getString(R.string.app_name));

        setSupportActionBar(mToolBar);

        mActionBar = getSupportActionBar();
    }

    @Override
    protected String[] getSupportDITitles() {
        return new String[0];
    }

    @Override
    protected String[] getSDITitles() {
        return new String[0];
    }

    @Override
    protected Typeface getTypeface() {
        return null;
    }

    @Override
    protected int getColorRes() {
        return 0;
    }

    @Override
    protected IDrawerItem[] getDynamicDrawerItems() {
        return new IDrawerItem[0];
    }

    @Override
    protected IDrawerItem[] getSupportDrawerItem() {
        return new IDrawerItem[0];
    }

    @Override
    protected IDrawerItem[] getStaticDrawerItem() {
        return new IDrawerItem[0];
    }

    @Override
    public void onClick(View v) {

    }
}
