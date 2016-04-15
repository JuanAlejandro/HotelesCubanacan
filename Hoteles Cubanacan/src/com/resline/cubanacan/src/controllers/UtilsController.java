package com.resline.cubanacan.src.controllers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.resline.cubanacan.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author David
 * @Date 06/04/2016
 * @Description Clase controladora para manejar los utils
 */
public class UtilsController {

    public static String md5(String string) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(string.getBytes());
            byte messageDigest[] = digest.digest();

            StringBuilder hexString = new StringBuilder();

            for (byte msg : messageDigest) {
                String h = Integer.toHexString(0xFF & msg);
                while (h.length() < 2)
                h = "0" + h;
                hexString.append(h);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return string.replaceAll("[.:/,%?#&amp;=]","");
    }

    public static AlertDialog getAlertDialog(Context context, String title, String message, String textButton, DialogInterface.OnClickListener clickListener ){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setIcon(R.drawable.ic_launcher);
        alertDialog.setButton(textButton, clickListener);
        return alertDialog;
    }
}
