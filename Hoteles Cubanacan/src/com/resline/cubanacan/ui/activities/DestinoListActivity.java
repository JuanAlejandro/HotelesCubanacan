package com.resline.cubanacan.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.activities.api.GeneralListActivity;
import com.resline.cubanacan.ui.fragments.DestinoListFragment;

/**
 * Created by Juan Alejandro on 22/04/2016.
 * Activity to show list of hotels of a destiny
 */
public class DestinoListActivity extends GeneralListActivity {
    private static final String TAG = "DestinoListActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentTransaction(new DestinoListFragment());
    }

    @Override
    protected String getTitleToolBar() {
        return getString(R.string.destinos_title);
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
