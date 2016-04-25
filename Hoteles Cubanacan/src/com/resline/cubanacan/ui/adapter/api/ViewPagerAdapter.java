package com.resline.cubanacan.ui.adapter.api;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Juan Alejandro on 26/01/2016.
 */
public abstract class ViewPagerAdapter extends FragmentPagerAdapter {

    protected List<String> mListTitleTabs;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public ViewPagerAdapter(FragmentManager fm, List<String> listTitleTabs) {
        super(fm);
        this.mListTitleTabs = listTitleTabs;
    }

    // important method: get the fragment according to the position of the #psts
    // where i is teh position
    @Override
    public abstract Fragment getItem(int i);

    @Override
    public CharSequence getPageTitle(int position) {
        if (mListTitleTabs == null || mListTitleTabs.isEmpty()) {
            return "";
        }
        return mListTitleTabs.get(position);
    }

    @Override
    public int getCount() {
        if (mListTitleTabs == null || mListTitleTabs.isEmpty()) {
            return 0;
        }
        return mListTitleTabs.size();
    }
}
