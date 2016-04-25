package com.resline.cubanacan.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.astuetz.PagerSlidingTabStrip;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.activities.api.PSTSActivity;
import com.resline.cubanacan.ui.adapter.UserProfilePagerAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Juan Alejandro on 23-Jul-15.
 * activity for user profile
 */
public class UserProfileActivity extends PSTSActivity {
    // Visual elements
    private ImageView imgProfile;
    private ImageView imgProfileBg;
    private TextView etUserName;
    private String name;
    private int currentScreen = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initialization
        setToolBar();

        loadViewComponents();

        loadViewPagerComponents();
    }

    @Override
    protected List<String> getListTitleTabsArray() {
        return Arrays.asList(getResources()
                .getStringArray(R.array.fragment_user_profile_sections_tabs_title));
    }

    @Override
    protected int getLayoutResourceIdentifier() {
        return R.layout.activity_user_profile;
    }

    @Override
    protected String getTitleToolBar() {
        return "";
    }

    @Override
    protected Toolbar getLayoutResourceToolBar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }

    private void loadViewComponents() {
        imgProfile = (ImageView) findViewById(R.id.ivProfile);

        imgProfileBg = (ImageView) findViewById(R.id.ivUserProfileBg);

        etUserName = (TextView) findViewById(R.id.etUserName);
    }

    @Override
    protected PagerAdapter getViewPagerAdapter() {
        return new UserProfilePagerAdapter(
                getSupportFragmentManager(),
                mlistTitleTabs);
    }

    @Override
    protected ViewPager.OnPageChangeListener getOnPageChangeListener() {
        return new OnUserProfilePageListener();
    }

    @Override
    protected ViewPager getLayoutResourceViewPager() {
        return (ViewPager) findViewById(R.id.vpDetails);
    }

    @Override
    protected PagerSlidingTabStrip getLayoutResourcePSTS() {
        return (PagerSlidingTabStrip) findViewById(R.id.pstsDetails);
    }

    private void setToolBar() {
        mActionBar.setDisplayHomeAsUpEnabled(true);

        // Toolbar onMenuItemClickListener
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mToolBar.setBackgroundColor(ScrollUtils.getColorWithAlpha(0,
                getResources().getColor(R.color.cubanacan_light_blue)));
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void loadViewPagerComponents() {
        mViewPager.setCurrentItem(currentScreen);
    }

    public class OnUserProfilePageListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }
}
