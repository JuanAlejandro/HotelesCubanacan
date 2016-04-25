package com.resline.cubanacan.ui.adapter.api;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.model.CardViewBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Parent class for card adapters
 */
public abstract class RecyclerViewCardsAdapter extends RecyclerView.Adapter<RecyclerViewCardsAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewCards";
    protected final List<CardViewBean> mListItemsCard;
    protected Activity mActivity;
    private int mDrawerCurrentSelectedPos = 0;
    private boolean isInDetailsView = false;
    private boolean isInUserProfile = false;
    private boolean loadRecommendedCardViews = false;

    public RecyclerViewCardsAdapter(Activity activity, List<CardViewBean> listItemsCard) {
        this.mListItemsCard = listItemsCard;
        this.mActivity = activity;
        loadPreferences();
    }

    protected abstract int getCardLayoutRes();

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final CardViewBean itemCardView = mListItemsCard.get(position);

        holder.itemView.setTag(itemCardView);

        holder.position = position;

        holder.stvTitle.setText(itemCardView.getTitle());

        holder.tvSubTitle1.setText(itemCardView.getSubtitle1());
        holder.tvSubTitle2.setText(itemCardView.getSubtitle2());

        holder.tvShortData.setText(itemCardView.getShortData());

        for(int i=0; i<itemCardView.getStars(); i++){
            holder.stars[i].setVisibility(View.VISIBLE);
        }

        setThumbNailImage(itemCardView.getImgUri(), holder.ivThumbNail);

        holder.id = itemCardView.getId();
    }

    private void setThumbNailImage(Uri imgUri, ImageView img) {
        Picasso.with(mActivity)
                .load(imgUri.toString())
                .placeholder(R.drawable.loading)
                .error(R.drawable.ic_launcher)
                .into(img);
    }


    // to get the default image (show this image if the event/artist/place doesn't have one)
    protected abstract int getDefaultImage();

    @Override
    public int getItemCount() {
        return mListItemsCard.size();
    }

    private void loadPreferences() {
        // fixme: onPause error
    }

    public CardViewBean removeItem(int position) {
        final CardViewBean cardViewBean = mListItemsCard.remove(position);
        notifyItemRemoved(position);
        return cardViewBean;
    }

    public void addItem(int position, CardViewBean cardViewBean) {
        mListItemsCard.add(position, cardViewBean);
        notifyItemInserted(position);
    }

    public void animateTo(List<CardViewBean> cardViewBeans) {
        applyAndAnimateRemovals(cardViewBeans);
        applyAndAnimateAdditions(cardViewBeans);
    }

    private void applyAndAnimateRemovals(List<CardViewBean> newCardViewBeans) {
        for (int i = mListItemsCard.size() - 1; i >= 0; i--) {
            final CardViewBean model = mListItemsCard.get(i);
            if (!newCardViewBeans.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<CardViewBean> newCardViewBeans) {
        for (int i = 0, count = newCardViewBeans.size(); i < count; i++) {
            final CardViewBean cardViewBean = newCardViewBeans.get(i);
            if (!mListItemsCard.contains(cardViewBean)) {
                addItem(i, cardViewBean);
            }
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivThumbNail;
        public TextView stvTitle;
        public TextView tvSubTitle1;
        public TextView tvSubTitle2;
        public TextView tvShortData;
        public ImageView[] stars;
        public RelativeLayout rlCard;
        public int position;
        public Long id;
        private Activity mActivity;
        private int tipo;

        public ViewHolder(Activity activity, final View itemView) {
            super(itemView);
            mActivity = activity;
            ivThumbNail = (ImageView) itemView.findViewById(R.id.material_com_card_view_image);
            stvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvShortData = (TextView) itemView.findViewById(R.id.tvShortData);
            tvSubTitle1 = (TextView)itemView.findViewById(R.id.tvSubtitle1);
            tvSubTitle2 = (TextView)itemView.findViewById(R.id.tvSubtitle2);
            rlCard = (RelativeLayout) itemView.findViewById(R.id.rlCardView);

            stars = new ImageView[5];
            stars[0] = (ImageView)itemView.findViewById(R.id.start1);
            stars[1] = (ImageView)itemView.findViewById(R.id.start2);
            stars[2] = (ImageView)itemView.findViewById(R.id.start3);
            stars[3] = (ImageView)itemView.findViewById(R.id.start4);
            stars[4] = (ImageView)itemView.findViewById(R.id.start5);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return false;
                }
            });
        }
    }

    // parameter id is accesible only for this class - todo: change this
    protected abstract Bundle getBundle(Long id);

    protected abstract Class<?> getActivityClass();


}
