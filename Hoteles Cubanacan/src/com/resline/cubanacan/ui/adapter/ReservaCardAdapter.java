package com.resline.cubanacan.ui.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.adapter.api.RecyclerViewCardsAdapter;
import com.resline.cubanacan.ui.model.CardViewBean;
import com.resline.cubanacan.ui.model.CardViewReserva;
import com.resline.cubanacan.ui.view.GenericDialogs;

import java.util.List;

/**
 * Created by Juan Alejandro on 25/04/2016.
 */
public class ReservaCardAdapter extends RecyclerView.Adapter<ReservaCardAdapter.ReservaViewHolder> {
    protected final List<CardViewBean> mListItemsCard;
    protected Activity mActivity;

    public ReservaCardAdapter(Activity activity, List<CardViewBean> listItemsCard) {
        this.mListItemsCard = listItemsCard;
        this.mActivity = activity;
    }

    @Override
    public ReservaCardAdapter.ReservaViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        return new ReservaViewHolder(mActivity, LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_reserva, parent, false));
    }

    @Override
    public void onBindViewHolder(ReservaViewHolder holder, int position) {
        CardViewReserva itemCardView = (CardViewReserva) mListItemsCard.get(position);
        holder.itemView.setTag(itemCardView);

        holder.id = itemCardView.getId();

        holder.position = position;

        holder.tvTitle.setText(itemCardView.getTitle());

        // recuerda que subtitle es la cantidad de habitaciones
        // CardViewReserva hereda de CardViewBean
        holder.tvCantHab.setText(itemCardView.getSubtitle());
        // lo mismo con shortData
        holder.tvPrecio.setText(itemCardView.getShortData());

        holder.cantNoches.setText(Integer.toString(itemCardView.getCantNoches()));

        holder.dateIn.setText(itemCardView.getDateIn());

        holder.dateOut.setText(itemCardView.getDateOut());

    }

    @Override
    public int getItemCount() {
        return mListItemsCard.size();
    }

    public class ReservaViewHolder extends RecyclerView.ViewHolder {
        // elements of the card
        public TextView tvTitle;
        public TextView tvCantHab;
        public TextView tvPrecio;
        public TextView cantNoches;
        public TextView dateIn;
        public TextView dateOut;
        public Button btnPagar;
        public Button btnCancelar;
        public int id;
        public int position;


        public ReservaViewHolder(Activity activity, final View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvCantHab = (TextView) itemView.findViewById(R.id.rbCategory);
            tvPrecio = (TextView) itemView.findViewById(R.id.tvPrecioCant);
            cantNoches = (TextView) itemView.findViewById(R.id.tvNochesCant);
            dateIn = (TextView) itemView.findViewById(R.id.tvEntrada);
            dateOut = (TextView) itemView.findViewById(R.id.tvSalida);
            btnPagar = (Button) itemView.findViewById(R.id.btnPagar);
            btnCancelar = (Button) itemView.findViewById(R.id.btnCancelar);
            // onClickListeners
            btnPagar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // code to execute when pagar button is touched
                    GenericDialogs.showErrorDialog(mActivity, R.string.error, R.string.content_error, R.string.ok,
                            R.string.report, new MaterialDialog.ButtonCallback() {
                        @Override
                        public void onPositive(MaterialDialog dialog) {
                            super.onPositive(dialog);
                        }

                        @Override
                        public void onNegative(MaterialDialog dialog) {
                            super.onNegative(dialog);
                        }

                        @Override
                        public void onNeutral(MaterialDialog dialog) {
                            super.onNeutral(dialog);
                        }
                    }).show();
                }
            });

            btnCancelar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // code to execute when cancelar button is touched
                    MaterialDialog.Builder progressDialog =
                            GenericDialogs.showProgressDialog(mActivity, R.string.wait_title, R.string.wait_content);
                    progressDialog.show();
                }
            });
        }

    }
}
