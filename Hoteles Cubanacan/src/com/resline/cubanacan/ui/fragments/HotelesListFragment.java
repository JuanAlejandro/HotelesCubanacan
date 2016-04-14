package com.resline.cubanacan.ui.fragments;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import com.resline.cubanacan.ui.adapter.HotelesCardsAdapter;
import com.resline.cubanacan.ui.fragments.api.RecyclerViewFragment;
import com.resline.cubanacan.ui.model.CardViewBean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan Alejandro on 13/04/2016.
 */
public class HotelesListFragment extends RecyclerViewFragment {
    @Override
    protected RecyclerView.Adapter getRecyclerViewCardAdapter(Activity mActivity, List<CardViewBean> mListCard) {
        return new HotelesCardsAdapter(mActivity, mListCard);
    }

    @Override
    protected List<CardViewBean> getContentInCards() {
        List<CardViewBean> temp = new ArrayList<>();
        // todo: get the content
        temp = populateList();
        return temp;
    }

    private List<CardViewBean> populateList() {
        List<CardViewBean> listCard = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            listCard.add(new CardViewBean(null, Integer.toString(i), Integer.toString(i), Integer.toString(i)));
        }

        return listCard;
    }
}
