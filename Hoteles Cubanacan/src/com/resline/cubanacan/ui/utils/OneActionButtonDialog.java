package com.resline.cubanacan.ui.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.resline.cubanacan.R;

/**
 * Created by David on 08/04/2016.
 */
public class OneActionButtonDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Error")
                .setIcon(getResources().getDrawable(R.drawable.ic_launcher))
                .setMessage("Por favor, comprueba tu conexión")
                .setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        return builder.create();
    }
}
