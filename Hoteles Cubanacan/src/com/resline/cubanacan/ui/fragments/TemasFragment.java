package com.resline.cubanacan.ui.fragments;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import com.resline.cubanacan.ui.adapter.TemasCardAdapter;
import com.resline.cubanacan.ui.fragments.api.RecyclerViewWithFAB;
import com.resline.cubanacan.ui.model.CardViewBean;

import java.util.List;

/**
 * Created by Juan Alejandro on 23/04/2016.
 */
public class TemasFragment extends RecyclerViewWithFAB {

    @Override
    protected RecyclerView.Adapter getRecyclerViewCardAdapter(Activity mActivity, List<CardViewBean> mListCard) {
        return new TemasCardAdapter(mActivity, mListCard);
    }

    @Override
    protected List<CardViewBean> getContentInCards() {
        return null;
    }
}
