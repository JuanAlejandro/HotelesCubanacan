package com.resline.cubanacan.ui.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;
import com.resline.cubanacan.ui.activities.ElegirHabitacionActivity;

import static android.R.id.message;

/**
 * Created by David on 27/04/2016.
 */
public class MealPlanDialogFragment extends DialogFragment {

    public MealPlanDialogFragment() {
        // Empty constructor required for DialogFragment
    }

    public static MealPlanDialogFragment newInstance(long[] ids, final String[] options, double[] prices, String title,
                                                     int positionRoom, int positionRoomType) {

        MealPlanDialogFragment frag = new MealPlanDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putLongArray("ids", ids);
        args.putStringArray("options", options);
        args.putDoubleArray("prices", prices);
        args.putInt("positionRoom", positionRoom);
        args.putInt("positionRoomType", positionRoomType);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final String title = getArguments().getString("title");
        final String[] options = getArguments().getStringArray("options");
        final long[] ids = getArguments().getLongArray("ids");
        final double[] prices = getArguments().getDoubleArray("prices");
        final int positionRoom = getArguments().getInt("positionRoom");
        final int positionRoomType = getArguments().getInt("positionRoomType");
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ((ElegirHabitacionActivity)getActivity()).selectedMealPlan(positionRoom, positionRoomType, ids[which],
                                                                           options[which], prices[which]);
            }
        });
        alertDialogBuilder.setTitle(title);
        return alertDialogBuilder.create();
    }
}
