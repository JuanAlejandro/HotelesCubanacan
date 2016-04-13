package com.resline.cubanacan.ui.fragments;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import com.resline.cubanacan.ui.fragments.api.RecyclerViewFragment;
import com.resline.cubanacan.ui.model.CardViewBean;

import java.util.List;

/**
 * Created by Juan Alejandro on 13/04/2016.
 */
public class HotelesListFragment extends RecyclerViewFragment {
    @Override
    protected RecyclerView.Adapter getRecyclerViewCardAdapter(Activity mActivity, List<CardViewBean> mListCard) {
        return null;
    }

    @Override
    protected List<CardViewBean> getContentInCards() {
        return null;
    }
}
