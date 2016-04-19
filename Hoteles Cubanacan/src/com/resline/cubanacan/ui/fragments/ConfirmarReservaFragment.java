package com.resline.cubanacan.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.fragments.api.BaseFragment;

/**
 * Created by Juan Alejandro on 18/04/2016.
 */
public class ConfirmarReservaFragment extends BaseFragment {
    private View mViewInfoFragment;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewInfoFragment = inflater.inflate(R.layout.fragment_confirm_reserva, container, false);

        return mViewInfoFragment;
    }
}
