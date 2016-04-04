package com.resline.cubanacan.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.resline.cubanacan.R;

/**
 * Created by Juan Alejandro on 04/04/2016.
 * Actividad principal donde se llaman los fragments de la app según
 * la sección seleccionada en el drawer
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
