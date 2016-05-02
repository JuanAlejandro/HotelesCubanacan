package com.resline.cubanacan.ui.utils;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Juan Alejandro on 02/05/2016.
 */
public class TextUtils {
    public static void setTextProperties(final TextView textView, final TextView tvVerMas, final String stringVal,
                                         int maxLength) {
        if (stringVal.length() < maxLength) {
            textView.setText(stringVal);
        } else {
            int lastIndex = stringVal.indexOf(" ", maxLength);
            if (lastIndex != -1) {
                String shortDesc = stringVal.substring(0, lastIndex);
                textView.setText(shortDesc + "...");
                if (tvVerMas != null) {
                    tvVerMas.setVisibility(View.VISIBLE);
                    tvVerMas.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            textView.setText(stringVal);
                            tvVerMas.setVisibility(View.GONE);
                        }
                    });
                }
            } else {
                textView.setText(stringVal);
            }
        }
    }

}
