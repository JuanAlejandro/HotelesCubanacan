package com.resline.cubanacan.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.activities.RegistrarseActivity;
import com.resline.cubanacan.ui.fragments.api.BaseFragment;

/**
 * Created by Juan Alejandro on 23/04/2016.
 */
public class LoginFragment extends BaseFragment implements View.OnClickListener {
    private Button ok;
    private Button signUp;
    private EditText etUser;
    private EditText etPassword;

    private View mViewFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewFragment = inflater.inflate(R.layout.fragment_login, container, false);

        loadViews();

        return mViewFragment;
    }

    private void loadViews() {
        ok = (Button) mViewFragment.findViewById(R.id.ok_button);
        signUp = (Button) mViewFragment.findViewById(R.id.sign_up);
        etUser = (EditText) mViewFragment.findViewById(R.id.etUser);
        etPassword = (EditText) mViewFragment.findViewById(R.id.etPassword);

        ok.setOnClickListener(this);
        signUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ok_button:
                break;
            case R.id.sign_up:
                startActivity(new Intent(mActivity, RegistrarseActivity.class));
                break;
        }
    }
}
