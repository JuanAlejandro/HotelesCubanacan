package com.resline.cubanacan.ui.view;

import android.content.res.Resources;
import com.astuetz.PagerSlidingTabStrip;
import com.resline.cubanacan.R;

/**
 * Created by Juan Alejandro on 16/11/2015.
 */
public class PagerSlidingTabStripStyling {
    public static void stylePSTS(PagerSlidingTabStrip psts){
        psts.setShouldExpand(true);
        psts.setTabPaddingLeftRight(32);
        psts.setIndicatorColorResource(R.color.cubanacan_dark_blue);
    }

    public static void coloredPSTS(PagerSlidingTabStrip psts, Resources mResources){
        psts.setTextColor(mResources.getColor(android.R.color.black));
        psts.setIndicatorColorResource(R.color.cubanacan_dark_blue);
        psts.setDividerColor(mResources.getColor(R.color.half_black_transparency));
    }
}
