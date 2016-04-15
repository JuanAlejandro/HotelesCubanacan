package com.resline.cubanacan.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.activities.api.BaseActivity;

/**
 * Created by Juan Alejandro on 13/04/2016.
 */
public class HotelDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // to set back arrow in toolbar
        setToolbar();
    }

    private void setToolbar() {
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected int getLayoutResourceIdentifier() {
        return R.layout.activity_details;
    }

    @Override
    protected String getTitleToolBar() {
        return "";
    }

    @Override
    protected Toolbar getLayoutResourceToolBar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }
}
