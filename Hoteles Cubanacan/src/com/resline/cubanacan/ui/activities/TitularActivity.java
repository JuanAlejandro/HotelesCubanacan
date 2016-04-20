package com.resline.cubanacan.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.activities.api.BaseActivity;
import com.resline.cubanacan.ui.fragments.ConfirmarReservaFragment;
import com.resline.cubanacan.ui.fragments.TitularFragment;

/**
 * Created by Juan Alejandro on 18/04/2016.
 */
public class TitularActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar();
        fragmentTransaction(new TitularFragment());
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
        return R.layout.activity_with_frame;
    }

    @Override
    protected String getTitleToolBar() {
        return "Titular";
    }

    @Override
    protected Toolbar getLayoutResourceToolBar() {
        return (Toolbar) findViewById(R.id.screen_default_toolbar);
    }

    private void fragmentTransaction(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.screen_default_container, fragment)
                    .commit();
        }
    }
}
