package com.resline.cubanacan.ui.fragments.api;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.model.CardViewBean;

import java.util.List;

/**
 * Created by Juan Alejandro on 30/01/2016.
 * Use for those fragments that use RecyclerView (#rv) and card views as content
 * Note: includes set a layout when there's no data... thanks again :)
 * P.S.: the no data layout has to be included in mViewRecyclerCardsView
 */
public abstract class RecyclerViewFragment extends BaseFragment {
    protected RecyclerView mRecyclerView;

    protected RecyclerView.Adapter adapter;

    protected View mViewRecyclerCardsView;

    protected ViewGroup noDataLayout;

    protected List<CardViewBean> mListCard;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        boolean result;

        mViewRecyclerCardsView = getRecyclerViewCardsRes(inflater, container);

        loadViewComponents();

        result = loadInfoView();

        if (result) {
            // set adapter
            adapter = getRecyclerViewCardAdapter(mActivity, mListCard);

            mRecyclerView.setAdapter(adapter);

            return mViewRecyclerCardsView;
        }

        // if continues show noDataLayout
        noDataLayout.setVisibility(View.VISIBLE);

        return mViewRecyclerCardsView;
    }

    protected abstract RecyclerView.Adapter getRecyclerViewCardAdapter(Activity mActivity,
                                                                       List<CardViewBean> mListCard);

    protected boolean loadInfoView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(layoutManager);

        mListCard = getContentInCards();

        return mListCard.size() > 0;
    }

    protected abstract List<CardViewBean> getContentInCards();

    public void loadViewComponents() {
        noDataLayout = getNoDataLayoutRes();

        mRecyclerView = getRecyclerViewRes();
    }

    protected View getRecyclerViewCardsRes(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    protected RecyclerView getRecyclerViewRes() {
        return (RecyclerView) mViewRecyclerCardsView.findViewById(R.id.fragment_recyler_view_content_main);
    }

    protected ViewGroup getNoDataLayoutRes() {
        return (LinearLayout) mViewRecyclerCardsView.findViewById(R.id.llNoData);
    }
}
