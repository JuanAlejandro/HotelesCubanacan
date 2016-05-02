package com.resline.cubanacan.ui.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.activities.HotelDetailsActivity;
import com.resline.cubanacan.ui.adapter.api.RecyclerViewCardsAdapter;
import com.resline.cubanacan.ui.model.CardViewBean;
import com.resline.cubanacan.ui.model.CardViewHotel;
import com.resline.cubanacan.ui.model.CardViewReserva;
import com.resline.cubanacan.ui.view.GenericDialogs;
import com.squareup.picasso.Picasso;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Juan Alejandro on 31/01/2016.
 */
public class HotelesCardsAdapter extends RecyclerView.Adapter<HotelesCardsAdapter.HotelesViewHolder> {

    protected final List<CardViewBean> mListItemsCard;
    protected Activity mActivity;

    public HotelesCardsAdapter(Activity activity, List<CardViewBean> listItemsCard) {
        mListItemsCard = listItemsCard;
        mActivity = activity;
    }

    @Override
    public HotelesCardsAdapter.HotelesViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        return new HotelesCardsAdapter.HotelesViewHolder(mActivity, LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_hotel, parent, false));
    }

    @Override
    public void onBindViewHolder(HotelesCardsAdapter.HotelesViewHolder holder, int position) {
        CardViewHotel itemCardView = (CardViewHotel) mListItemsCard.get(position);
        setThumbNailImage(itemCardView.getImgUri(), holder.ivThumbNail);
        setCategory(itemCardView.getStars(), holder.stars);
        holder.itemView.setTag(itemCardView);
        holder.tvTitle.setText(itemCardView.getTitle());
        holder.tvShortData.setText(itemCardView.getShortData());
        holder.tvSubTitle1.setText(itemCardView.getSubtitle());
        holder.tvSubTitle2.setText(itemCardView.getSubtitle2());
        holder.id = itemCardView.getId();
        holder.position = position;
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

    private void setThumbNailImage(Uri imgUri, ImageView img) {
        if(imgUri != null && img != null){
            Picasso.with(mActivity)
                    .load(imgUri.toString())
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.ic_launcher)
                    .into(img);
        }
    }

    private void setCategory(int countStars, ImageView[] stars){

        for (int i=0; i<countStars; i++)
            stars[i].setVisibility(View.VISIBLE);
    }

    protected Class<?> getActivityClass() {
        return HotelDetailsActivity.class;
    }

    public class HotelesViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivThumbNail;
        public TextView tvTitle;
        public TextView tvShortData;
        public TextView tvSubTitle1;
        public TextView tvSubTitle2;
        public ImageView[] stars;
        public Long id;
        private Activity mActivity;
        int position;

        public HotelesViewHolder(Activity activity, final View itemView) {
            super(itemView);
            mActivity = activity;
            ivThumbNail = (ImageView) itemView.findViewById(R.id.material_com_card_view_image);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvShortData = (TextView) itemView.findViewById(R.id.tvShortData);
            tvSubTitle1 = (TextView) itemView.findViewById(R.id.tvSubtitle1);
            tvSubTitle2 = (TextView) itemView.findViewById(R.id.tvSubtitle2);

            stars = new ImageView[5];
            stars[0] = (ImageView) itemView.findViewById(R.id.start1);
            stars[1] = (ImageView) itemView.findViewById(R.id.start2);
            stars[2] = (ImageView) itemView.findViewById(R.id.start3);
            stars[3] = (ImageView) itemView.findViewById(R.id.start4);
            stars[4] = (ImageView) itemView.findViewById(R.id.start5);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return false;
                }
            });

            itemView.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v) {
                    mActivity.startActivity(new Intent(mActivity, getActivityClass()).putExtras(getBundle(id)));
                }
            });
        }
    }
}
