package com.resline.cubanacan.ui.fragments;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import com.resline.cubanacan.ui.adapter.ReservaCardAdapter;
import com.resline.cubanacan.ui.fragments.api.RecyclerViewFragment;
import com.resline.cubanacan.ui.model.CardViewBean;
import com.resline.cubanacan.ui.model.CardViewGeneral;
import com.resline.cubanacan.ui.model.CardViewReserva;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan Alejandro on 25/04/2016.
 */
public class ReservasListFragment extends RecyclerViewFragment {
    @Override
    protected RecyclerView.Adapter getRecyclerViewCardAdapter(Activity mActivity, List<CardViewBean> mListCard) {
        return new ReservaCardAdapter(mActivity, mListCard);
    }

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
            listCard.add(new CardViewReserva(id, "Hotel Sevilla", Integer.toString(i), Integer.toString(i), i,
                    "1/1/1990", "1/1/1990"));
        }

        return listCard;
    }
}
