package com.resline.cubanacan.ui.activities.api;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import com.resline.cubanacan.R;

/**
 * Created by Juan Alejandro on 23/04/2016.
 */
public abstract class GeneralListActivity extends BaseActivity implements View.OnClickListener {
    protected Button btnPrecio, btnDistancia, btnEstrellas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadViewComponents();

        setToolBar();
    }

    @Override
    protected int getLayoutResourceIdentifier() {
        return R.layout.activity_general_list;
    }

    protected void loadViewComponents() {
        btnPrecio = (Button) findViewById(R.id.btnPrecio);
        btnDistancia = (Button) findViewById(R.id.btnPlusNin);
        btnEstrellas = (Button) findViewById(R.id.btnEstrellas);

        btnPrecio.setOnClickListener(this);
        btnDistancia.setOnClickListener(this);
        btnEstrellas.setOnClickListener(this);

        btnPrecio.setSelected(false);
    }

    private void setToolBar() {
        mActionBar.setDisplayHomeAsUpEnabled(true);

        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected Toolbar getLayoutResourceToolBar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPrecio:
                // cambias el bundle aqui en dependencia del caso
                if (btnPrecio.isSelected())
                    btnPrecio.setSelected(false);
                else
                    btnPrecio.setSelected(true);

                btnDistancia.setSelected(false);
                btnEstrellas.setSelected(false);
                break;
            case R.id.btnPlusNin:
                // cambias el bundle aqui en dependencia del caso
                if (btnDistancia.isSelected())
                    btnDistancia.setSelected(false);
                else
                    btnDistancia.setSelected(true);

                btnPrecio.setSelected(false);
                btnEstrellas.setSelected(false);
                break;
            case R.id.btnEstrellas:
                // cambias el bundle aqui en dependencia del caso
                if (btnEstrellas.isSelected())
                    btnEstrellas.setSelected(false);
                else
                    btnEstrellas.setSelected(true);

                btnDistancia.setSelected(false);
                btnPrecio.setSelected(false);
                break;
        }
    }

    protected void fragmentTransaction(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameList, fragment)
                    .commit();
        }
    }
}
