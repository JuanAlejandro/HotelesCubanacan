package com.resline.cubanacan.ui.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.activities.DestinoListActivity;
import com.resline.cubanacan.ui.activities.HotelDetailsActivity;
import com.resline.cubanacan.ui.adapter.api.RecyclerViewCardsAdapter;
import com.resline.cubanacan.ui.model.CardViewBean;
import com.resline.cubanacan.ui.model.CardViewDestino;
import com.resline.cubanacan.ui.model.CardViewHotel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Juan Alejandro on 22/04/2016.
 */
public class DestinosCardAdapter extends RecyclerView.Adapter<DestinosCardAdapter.DestinoViewHolder> {

    protected final List<CardViewBean> mListItemsCard;
    protected Activity mActivity;

    public DestinosCardAdapter(Activity activity, List<CardViewBean> listItemsCard) {
        mListItemsCard = listItemsCard;
        mActivity = activity;
    }

    @Override
    public DestinosCardAdapter.DestinoViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        return new DestinosCardAdapter.DestinoViewHolder(mActivity, LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_destino, parent, false));
    }

    @Override
    public void onBindViewHolder(DestinosCardAdapter.DestinoViewHolder holder, int position) {
        CardViewDestino itemCardView = (CardViewDestino) mListItemsCard.get(position);
        setThumbNailImage(itemCardView.getImgUri(), holder.ivThumbNail);
        holder.itemView.setTag(itemCardView);
        holder.tvTitle.setText(itemCardView.getTitle());
        holder.tvSubtitle.setText(itemCardView.getSubtitle());
        holder.tvSubTitle1.setText(itemCardView.getSubtitle1());
        holder.tvSubTitle2.setText(itemCardView.getSubtitle2());
        holder.id = itemCardView.getId();
    }

    private void setThumbNailImage(Uri imgUri, ImageView img) {
        if(imgUri != null && img != null){
            Picasso.with(mActivity)
                    .load(imgUri.toString())
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.ic_launcher)
                    .into(img);
        }
    }

    @Override
    public int getItemCount() {
        return mListItemsCard.size();
    }

    protected int getCardLayoutRes() {
        return R.layout.card_hotel;
    }

    protected int getDefaultImage() {
        return R.drawable.icon;
    }

    protected Bundle getBundle(Long id) {
        Bundle bundle = new Bundle();
        bundle.putLong("idHotel", id);
        return bundle;
    }

    protected Class<?> getActivityClass() {
        // todo: activity here
        return HotelDetailsActivity.class;
    }

    public class DestinoViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivThumbNail;
        public TextView tvTitle;
        public TextView tvSubtitle;
        public TextView tvSubTitle1;
        public TextView tvSubTitle2;
        public Long id;

        public DestinoViewHolder(Activity activity, View itemView) {
            super(itemView);

            ivThumbNail = (ImageView) itemView.findViewById(R.id.material_com_card_view_image);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvSubtitle = (TextView) itemView.findViewById(R.id.tvSubtitle);
            tvSubTitle1 = (TextView) itemView.findViewById(R.id.tvSubtitle1);
            tvSubTitle2 = (TextView) itemView.findViewById(R.id.tvSubtitle2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mActivity.startActivity(new Intent(mActivity, getActivityClass()).putExtras(getBundle(id)));
                }
            });
        }
    }
}
