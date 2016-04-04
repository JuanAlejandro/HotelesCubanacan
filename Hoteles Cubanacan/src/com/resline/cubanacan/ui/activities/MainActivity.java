package com.resline.cubanacan.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.activities.api.DrawerActivity;
import com.resline.cubanacan.ui.utils.DrawerMenu;

/**
 * Created by Juan Alejandro on 04/04/2016.
 * Actividad principal donde se llaman los fragments de la app según
 * la sección seleccionada en el drawer
 */
public class MainActivity extends DrawerActivity implements DrawerActivity.OnDrawerItemSelected {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set drawer on item click listener
        setDrawerItemSelectedListener(this);

        // your code here
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setToolbar() {
        // in supportv7 toolbar is the action bar
        mToolBar = (Toolbar) findViewById(R.id.screen_default_toolbar);

        mToolBar.setTitle(mResources.getString(R.string.app_name));

        setSupportActionBar(mToolBar);

        mActionBar = getSupportActionBar();
    }

    @Override
    protected String[] getSDITitles() {
        return mResources.getStringArray(R.array.static_nav_drawer_items);
    }

    @Override
    protected IDrawerItem[] getStaticDrawerItem() {
        int selColor = R.color.cubanacan_light_blue;

        IDrawerItem[] drawerItems = new IDrawerItem[navSDITitles.length];

        for(int i = 0; i < DrawerMenu.CANT_SECCIONES; i++){
            drawerItems[i] = new PrimaryDrawerItem()
                    .withName(navSDITitles[i])
                    .withSelectedTextColorRes(selColor)
                    .withSelectedIconColorRes(selColor)
                    .withTag(TAG_ENTRAR_O_REGISTRARSE);
        }

        return drawerItems;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onDrawerItemSelected(Integer tag, String title) {
        /**
         * the sentence prefEditor.putInt(Keys.SP_STATE_SELECTED_POSITION, "position") idk what's for
         * todo: remove checking what's for
         * */
        switch (tag) {
        }

        area = tag;
    }
}
