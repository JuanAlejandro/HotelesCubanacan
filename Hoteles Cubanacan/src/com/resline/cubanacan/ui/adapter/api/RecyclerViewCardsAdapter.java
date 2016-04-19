package com.resline.cubanacan.ui.adapter.api;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.model.CardViewBean;

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

        holder.tvTitle.setText(itemCardView.getTitle());

        holder.tvSubTitle.setText(itemCardView.getSubtitle());

        setThumbNailImage(itemCardView.getImgUri(), holder.ivThumbNail);
    }

    private void setThumbNailImage(Uri imgUri, ImageView img) {
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
        public TextView tvTitle;
        public TextView tvSubTitle;
        public RelativeLayout rlCard;
        public int position;
        public int id;
        private Activity mActivity;
        private int tipo;

        public ViewHolder(Activity activity, final View itemView) {
            super(itemView);
            mActivity = activity;
            ivThumbNail = (ImageView) itemView.findViewById(R.id.material_com_card_view_image);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvSubTitle = (TextView) itemView.findViewById(R.id.rbCategory);
            rlCard = (RelativeLayout) itemView.findViewById(R.id.rlCardView);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return false;
                }
            });
        }
    }

    // parameter id is accesible only for this class - todo: change this
    protected abstract Bundle getBundle(int id);

    protected abstract Class<?> getActivityClass();


}
