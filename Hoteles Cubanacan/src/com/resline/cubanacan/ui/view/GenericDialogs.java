package com.resline.cubanacan.ui.view;

import android.app.Activity;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.resline.cubanacan.R;

/**
 * Created by Juan Alejandro on 15/11/2015.
 */
public class GenericDialogs {
    public static MaterialDialog.Builder showErrorDialog(Activity mActivity,
                                                         int titleResId, int contentResId, int positiveTextResId,
                                                         int neutralTextResId, int negativeTextResId,
                                                         MaterialDialog.ButtonCallback callback) {
        MaterialDialog.Builder materialDialogBuilder = getMaterialDialogBuilder(mActivity);
        return materialDialogBuilder.title(titleResId)
                .content(contentResId)
                .positiveText(positiveTextResId)
                .neutralText(neutralTextResId)
                .negativeText(negativeTextResId)
                .callback(callback);
    }

    public static MaterialDialog.Builder showErrorDialog(Activity mActivity,
                                                         int titleResId, int contentResId, int positiveTextResId,
                                                         int negativeTextResId,
                                                         MaterialDialog.ButtonCallback callback) {
        MaterialDialog.Builder materialDialogBuilder = getMaterialDialogBuilder(mActivity);
        return materialDialogBuilder.title(titleResId)
                .content(contentResId)
                .positiveText(positiveTextResId)
                .negativeText(negativeTextResId)
                .callback(callback);
    }

    public static MaterialDialog.Builder getMaterialDialogBuilder(Activity mActivity){
        return new MaterialDialog.Builder(mActivity)
                .theme(Theme.LIGHT)
                .negativeColorRes(android.R.color.black)
                .neutralColorRes(android.R.color.black);
    }

    public static MaterialDialog.Builder showProgressDialog(Activity mActivity, int titleRes, int contentRes){
        return getMaterialDialogBuilder(mActivity)
                .title(titleRes)
                .content(contentRes)
                .progress(true, 100)
                .cancelable(false);
    }

    public static MaterialDialog.Builder showProgressDialog(Activity mActivity, String title, String content){
        return getMaterialDialogBuilder(mActivity)
                .title(title)
                .content(content)
                .progress(true, 100)
                .cancelable(false);
    }
}
