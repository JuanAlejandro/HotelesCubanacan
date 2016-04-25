package com.resline.cubanacan.ui.activities.api;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import com.astuetz.PagerSlidingTabStrip;
import com.resline.cubanacan.ui.view.PagerSlidingTabStripStyling;

import java.util.List;

/**
 * Created by Juan Alejandro on 30/01/2016.
 * Implemented for those activities that use #psts
 */
public abstract class PSTSActivity extends BaseActivity {
    protected ViewPager mViewPager;
    protected PagerSlidingTabStrip mPagerSlidingTabStrip;     // this is the #psts
    protected List<String> mlistTitleTabs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mlistTitleTabs = getListTitleTabsArray();

        loadViewComponents();
    }

    protected abstract List<String> getListTitleTabsArray();

    private void loadViewComponents() {
        mViewPager = getLayoutResourceViewPager();

        mViewPager.setAdapter(getViewPagerAdapter());

        mPagerSlidingTabStrip = getLayoutResourcePSTS();

        mPagerSlidingTabStrip.setViewPager(mViewPager);

        // set colors to the #psts
        PagerSlidingTabStripStyling.coloredPSTS(mPagerSlidingTabStrip, mResources);

        // set style to the #psts
        PagerSlidingTabStripStyling.stylePSTS(mPagerSlidingTabStrip);

        // set on page change listener
        mPagerSlidingTabStrip.setOnPageChangeListener(getOnPageChangeListener());
    }

    protected abstract PagerAdapter getViewPagerAdapter();

    protected abstract ViewPager.OnPageChangeListener getOnPageChangeListener();

    protected abstract ViewPager getLayoutResourceViewPager();

    protected abstract PagerSlidingTabStrip getLayoutResourcePSTS();
}
