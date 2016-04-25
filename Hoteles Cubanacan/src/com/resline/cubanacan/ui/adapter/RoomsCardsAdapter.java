package com.resline.cubanacan.ui.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.activities.ElegirHabitacionActivity;
import com.resline.cubanacan.ui.activities.HotelDetailsActivity;
import com.resline.cubanacan.ui.adapter.api.RecyclerViewCardsAdapter;
import com.resline.cubanacan.ui.adapter.api.RoomCardsAdapter;
import com.resline.cubanacan.ui.model.CardViewBean;
import com.resline.cubanacan.ui.model.RoomViewBean;

import java.util.List;

/**
 * Created by David on 23/04/2016.
 */
public class RoomsCardsAdapter extends RoomCardsAdapter {
    public RoomsCardsAdapter(Activity activity, List<RoomViewBean> listItemsCard) {
        // fixme: onPause error
        super(activity, listItemsCard);
    }

    @Override
    public RoomsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RoomsViewHolder(mActivity, LayoutInflater.from(parent.getContext())
                .inflate(getCardLayoutRes(), parent, false));
    }

    @Override
    protected int getCardLayoutRes() {
        return R.layout.card_room;
    }

    @Override
    protected Bundle getBundle(Long id) {
        Bundle bundle = new Bundle();
        //bundle.putLong("idHotel", id);
        return bundle;
    }

    @Override
    protected Class<?> getActivityClass() {
        return ElegirHabitacionActivity.class;
    }

    private class RoomsViewHolder extends ViewHolder {
        public RoomsViewHolder(Activity activity, final View itemView) {
            super(activity, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //mActivity.startActivity(new Intent(mActivity, getActivityClass()).putExtras(getBundle(id)));
                }
            });
        }
    }
}
