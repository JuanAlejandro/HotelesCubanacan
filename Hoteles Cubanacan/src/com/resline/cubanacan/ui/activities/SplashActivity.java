package com.resline.cubanacan.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.resline.cubanacan.R;

/**
 * Created by Juan Alejandro on 04/04/2016.
 */
public class SplashActivity extends AppCompatActivity {
    private static long SPLASH_TIME = 2 * 1000;   // 2 segundos
    private boolean splashActiveFlag = true;
    private static String TAG = "SplashActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // ejecuta hilo temporizador - cuenta dos segundos
        executeThread();
    }

    private void executeThread() {
        Thread splashTimer = new Thread() {
            public void run() {
                try {
                    long ms = 0;
                    while (splashActiveFlag && ms < SPLASH_TIME) {
                        sleep(100);
                        ms += 100;
                    }
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));

                } catch (Exception e) {
                    Log.e(TAG, e.toString());
                } finally {
                    finish();
                }
            }
        };
        splashTimer.start();
    }
}
