package com.resline.cubanacan.ui.activities;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.activities.api.GeneralListActivity;

/**
 * Created by Juan Alejandro on 22/04/2016.
 * Activity to show list of hotels of a destiny
 */
public class TemaListActivity extends GeneralListActivity {
    private static final String TAG = "TemaListActivity";

    @Override
    protected String getTitleToolBar() {
        return "Tema";
    }

    @Override
    protected Toolbar getLayoutResourceToolBar() {
        return (Toolbar) findViewById(R.id.screen_default_toolbar);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btnPrecio:
                Log.d(TAG, "btnPrecio touched");
                break;
            case R.id.btnPlusNin:
                Log.d(TAG, "btnPlusNin touched");
                break;
            case R.id.btnEstrellas:
                Log.d(TAG, "btnEstrellas touched");
                break;
        }
    }
}
