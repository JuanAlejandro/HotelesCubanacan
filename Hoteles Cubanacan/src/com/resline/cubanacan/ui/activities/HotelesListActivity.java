package com.resline.cubanacan.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.activities.api.BaseActivity;
import com.resline.cubanacan.ui.fragments.HotelesListFragment;

/**
 * Created by Juan Alejandro on 13/04/2016.
 */
public class HotelesListActivity extends BaseActivity implements View.OnClickListener {

    enum Filter{PRICE_FILTER, NAME_FILTER, CATEGORY_FILTER};
    Filter filter = Filter.PRICE_FILTER;

    Button btnCategory, btnName, btnPrice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnCategory = (Button)findViewById(R.id.btnCategory);
        btnCategory.setOnClickListener(this);

        btnName = (Button)findViewById(R.id.btnName);
        btnName.setOnClickListener(this);

        btnPrice = (Button)findViewById(R.id.btnPrice);
        btnPrice.setOnClickListener(this);

        btnPrice.setSelected(true);


        setToolBar();

        sendFragmentTransaction();
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

    private void setFilterList(Filter newFilter){
        filter = newFilter;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = new Fragment();
        Bundle bundle = new Bundle();
        // your arguments here
        bundle.putBoolean("my_boolean", true);
        bundle.putInt("my_int", 0);
        fragment.setArguments(bundle);
        switch (v.getId()) {
            case R.id.btnPrice:
                if (!btnPrice.isSelected())
                    btnPrice.setSelected(true);

                btnName.setSelected(false);
                btnCategory.setSelected(false);
                break;
            case R.id.btnName:
                // cambias el bundle aqui en dependencia del caso
                if (!btnName.isSelected())
                    btnName.setSelected(true);

                btnPrice.setSelected(false);
                btnCategory.setSelected(false);
                break;
            case R.id.btnCategory:
                // cambias el bundle aqui en dependencia del caso
                if (!btnCategory.isSelected())
                    btnCategory.setSelected(true);

                btnName.setSelected(false);
                btnPrice.setSelected(false);
                break;
        }


        fragmentTransaction(fragment);
    }

    private void sendFragmentTransaction(){
        Fragment fragment = new HotelesListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("filter", filter.ordinal());
        fragment.setArguments(bundle);
        fragmentTransaction(fragment);
    }

    private class OnNameFilterClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            setFilterList(Filter.NAME_FILTER);
            sendFragmentTransaction();
        }
    }

    private class OnPriceFilterClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            setFilterList(Filter.PRICE_FILTER);
            sendFragmentTransaction();
        }
    }

    private class OnCategoryFilterClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            setFilterList(Filter.CATEGORY_FILTER);
            sendFragmentTransaction();
        }
    }
}
