package com.resline.cubanacan.ui.adapter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.resline.cubanacan.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GalleryAdapter extends PagerAdapter {
    Activity mActivity;
    List<File> mGalleryFiles;

    public GalleryAdapter(Activity mActivity) {
        this.mActivity = mActivity;
        // aqui iria una lista de imagenes
        this.mGalleryFiles = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mGalleryFiles.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return o == view;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mActivity.getLayoutInflater().inflate(R.layout.activity_gallery_screen,
                container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.ivGaleria);
        Picasso.with(mActivity)
                .load(mGalleryFiles.get(position))
                .into(imageView);
        // Add the newly created View to the ViewPager
        container.addView(view);
        if (position < 0 || position > mGalleryFiles.size())
            if (mGalleryFiles.size() < 1)
                throw new IllegalStateException("El indice de la HelpScreen activa no es valido.");

        // Return the View
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public List<File> getmGalleryFiles() {
        return mGalleryFiles;
    }
}
