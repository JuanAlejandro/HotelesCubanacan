package com.resline.cubanacan.ui.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.resline.cubanacan.ui.adapter.api.ViewPagerAdapter;
import com.resline.cubanacan.ui.fragments.HotelesListFragment;

import java.util.List;

/**
 * Created by Juan Alejandro on 09/02/2016.
 * pager adapter for user profile section
 */
public class UserProfilePagerAdapter extends ViewPagerAdapter {
    private static final int RESERVAS = 0;
    private static final int MIS_DATOS = 1;

    public UserProfilePagerAdapter(FragmentManager fm, List<String> listTitleTabs) {
        super(fm, listTitleTabs);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case RESERVAS:
                break;
            case MIS_DATOS:
            default:
                break;
        }

        return new HotelesListFragment();
    }
}
