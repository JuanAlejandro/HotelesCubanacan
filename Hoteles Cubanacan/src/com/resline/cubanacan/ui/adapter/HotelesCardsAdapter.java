package com.resline.cubanacan.ui.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.activities.HotelDetailsActivity;
import com.resline.cubanacan.ui.adapter.api.RecyclerViewCardsAdapter;
import com.resline.cubanacan.ui.model.CardViewBean;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Juan Alejandro on 31/01/2016.
 */
public class HotelesCardsAdapter extends RecyclerViewCardsAdapter {
    public HotelesCardsAdapter(Activity activity, List<CardViewBean> listItemsCard) {
        // fixme: onPause error
        super(activity, listItemsCard);
    }

    @Override
    public HotelesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HotelesViewHolder(mActivity, LayoutInflater.from(parent.getContext())
                .inflate(getCardLayoutRes(), parent, false));
    }

    @Override
    protected int getCardLayoutRes() {
        return R.layout.card_hotel;
    }

    @Override
    protected int getDefaultImage() {
        return R.drawable.icon;
    }

    @Override
    protected Bundle getBundle(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt("my_int", id);
        return bundle;
    }

    @Override
    protected Class<?> getActivityClass() {
        // todo: activity here
        return HotelDetailsActivity.class;
    }

    private class HotelesViewHolder extends ViewHolder {
        public HotelesViewHolder(Activity activity, View itemView) {
            super(activity, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mActivity.startActivity(new Intent(mActivity, getActivityClass()).putExtras(getBundle(id)));
                }
            });
        }
    }
}
