package com.resline.cubanacan.ui.fragments;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import com.resline.cubanacan.ui.adapter.DestinosCardAdapter;
import com.resline.cubanacan.ui.fragments.api.RecyclerViewWithFAB;
import com.resline.cubanacan.ui.model.CardViewBean;
import com.resline.cubanacan.ui.model.CardViewGeneral;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan Alejandro on 22/04/2016.
 */
public class DestinosFragment extends RecyclerViewWithFAB {
    @Override
    protected RecyclerView.Adapter getRecyclerViewCardAdapter(Activity mActivity, List<CardViewBean> mListCard) {
        return new DestinosCardAdapter(mActivity, mListCard);
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
        int id;

        for (int i = 0; i < 100; i++) {
            id = i;
            Long iLong= new Long(id);
            listCard.add(new CardViewGeneral(iLong, null, Integer.toString(i), Integer.toString(i)));
        }

        return listCard;
    }
}
