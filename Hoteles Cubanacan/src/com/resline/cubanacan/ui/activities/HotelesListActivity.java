package com.resline.cubanacan.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.activities.api.BaseActivity;
import com.resline.cubanacan.ui.fragments.HotelesListFragment;

/**
 * Created by Juan Alejandro on 13/04/2016.
 */
public class HotelesListActivity extends BaseActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolBar();

        fragmentTransaction(new HotelesListFragment());
    }

    @Override
    protected int getLayoutResourceIdentifier() {
        return R.layout.activity_hoteles_list;
    }

    @Override
    protected String getTitleToolBar() {
        return mResources.getString(R.string.hoteles_title);
    }

    @Override
    protected Toolbar getLayoutResourceToolBar() {
        return (Toolbar) findViewById(R.id.screen_default_toolbar);
    }

    private void fragmentTransaction(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameList, fragment)
                    .commit();
        }
    }

    private void setToolBar() {
        mActionBar.setDisplayHomeAsUpEnabled(true);

        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = new Fragment();
        Bundle bundle = new Bundle();
        // your arguments here
        bundle.putBoolean("my_boolean", true);
        bundle.putInt("my_int", 0);
        fragment.setArguments(bundle);
        switch (v.getId()){
            case R.id.btnPrecio:
                // cambias el bundle aqui en dependencia del caso
                break;
            case R.id.btnPlusNin:
                // cambias el bundle aqui en dependencia del caso
                break;
            case R.id.btnEstrellas:
                // cambias el bundle aqui en dependencia del caso
                break;
        }


        fragmentTransaction(fragment);
    }
}
