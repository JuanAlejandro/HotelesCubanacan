package com.resline.cubanacan.ui.activities;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.adapter.GalleryAdapter;

/**
 * Actividad de la galería
 */
public class GalleryActivity extends Activity {
    static TextView mDotsText[];
    private int mDotsCount;
    private LinearLayout mDotsLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gallery);

        Bundle bundle = getIntent().getExtras();

        ViewPager mViewPager = (ViewPager) findViewById(R.id.gallery);

        GalleryAdapter mGalleryAdapter;

        mGalleryAdapter = new GalleryAdapter(this);

        mViewPager.setAdapter(mGalleryAdapter);

        mDotsLayout = (LinearLayout) findViewById(R.id.image_count);

        //here we count the number of images we have to know how many dots we need
        mDotsCount = mViewPager.getAdapter().getCount();

        //here we create the dots
        //as you can see the dots are nothing but "." of large size
        mDotsText = new TextView[mDotsCount];

        //here we set the dots
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(5, 5, 5, 5);

        for (int i = 0; i < mDotsCount; i++) {
            mDotsText[i] = new TextView(this);
            mDotsText[i].setText(".");
            mDotsText[i].setTextSize(50);
            mDotsText[i].setTextColor(Color.GRAY);
            mDotsLayout.addView(mDotsText[i], layoutParams);
        }

        if (mDotsCount != 0) {
            mDotsText[0].setTextColor(Color.WHITE);
            mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                @Override
                public void onPageSelected(int position) {
                    for (int i = 0; i < mDotsCount; i++) {
                        GalleryActivity.mDotsText[i]
                                .setTextColor(Color.GRAY);
                    }
                    GalleryActivity.mDotsText[position]
                            .setTextColor(Color.WHITE);
                }
            });
            mViewPager.setCurrentItem(0);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
