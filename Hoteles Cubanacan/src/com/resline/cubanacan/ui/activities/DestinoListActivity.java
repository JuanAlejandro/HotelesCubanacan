package com.resline.cubanacan.ui.activities;

import android.support.v7.widget.Toolbar;
import com.resline.cubanacan.ui.activities.api.BaseActivity;

/**
 * Created by Juan Alejandro on 22/04/2016.
 * Activity to show list of hotels of a destiny
 */
public class DestinoListActivity extends BaseActivity{
    @Override
    protected int getLayoutResourceIdentifier() {
        return 0;
    }

    @Override
    protected String getTitleToolBar() {
        return null;
    }

    @Override
    protected Toolbar getLayoutResourceToolBar() {
        return null;
    }
}
