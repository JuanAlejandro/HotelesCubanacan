/*
 * Copyright (C) 2014 Antonio Leiva Gordillo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.resline.cubanacan.ui.activities.api;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.utils.DrawerMenu;

public abstract class DrawerActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int TAG_ENTRAR_O_REGISTRARSE = 0;
    public static final int TAG_RESERVAR = 1;
    public static final int TAG_DESTINOS = 2;
    public static final int TAG_HOTELES = 3;
    public static final int TAG_TEMAS = 4;
    public static final int TAG_OFERTAS_ESPECIALES = 5;
    public static final int TAG_RECIENTES = 6;
    public static final int TAG_VALORAR_Y_COMPARTIR = 7;
    public static final int TAG_TERMINOS_DE_USO = 8;
    public static final int TAG_CONTACTENOS = 9;
    public static final int TAG_CONFIGURACION = 10;

    private static final String TAG = "DrawerActivity";

    // navigation drawer components
    // static drawer items (#sdi)
    protected String[] navSDITitles;         // static titles of menu drawer navigator

    protected String[] supportDITitles;         // static titles of menu drawer navigator

    // style
    protected int selColorRes;

    // current area
    protected int area = DrawerMenu.ENTRAR_O_REGISTRARSE;

    // new drawer
    public Drawer drawer = null;

    // on drawer item selected listener
    private OnDrawerItemSelected listener;

    // toolbar
    protected Toolbar mToolBar;
    // action bar
    protected ActionBar mActionBar;
    // resources
    protected Resources mResources;
    // activity
    protected Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        mResources = getResources();
        // set toolbar
        setToolbar();
        // load view components (drawer, toolbar, etc.)
        loadViewComponents();
    }

    protected abstract void setToolbar();

    protected void setDrawerItemSelectedListener(OnDrawerItemSelected listener) {
        this.listener = listener;
    }

    // Load visual components of drawer and toolbar
    private void loadViewComponents() {
        // Init drawer menu titles
        navSDITitles = getSDITitles();        // Get the array of titles of the menu

        supportDITitles = getSupportDITitles();

        // Load drawer
        loadDrawer();

        // Show the hamberguer icon
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(false);
        }

        drawer.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
    }

    protected abstract String[] getSupportDITitles();

    protected abstract String[] getSDITitles();

    // load drawer
    protected void loadDrawer() {
        // init profile item
        selColorRes = getColorRes();

        drawer = new DrawerBuilder()
                .withActivity(mActivity)
                .withToolbar(mToolBar)
                .withDrawerWidthRes(R.dimen.drawer_menu_width)
                .withHeaderDivider(false)
                .withHeaderClickable(true)
                .addDrawerItems(getStaticDrawerItem())
                .withOnDrawerItemClickListener(new OnDrawerItemClick()).build();

        // add grand events (if there's at least one)
        drawer.addItems(getDynamicDrawerItems());
        Log.d(TAG, "dynamic drawer items added");

        // and later add the support elements
        drawer.addItems(getSupportDrawerItem());
        Log.d(TAG, "support drawer items added");
    }

    protected void refreshDrawer(){
        drawer.removeAllItems();
        drawer.addItems(getStaticDrawerItem());
        drawer.addItems(getDynamicDrawerItems());
        drawer.addItems(getSupportDrawerItem());
        drawer.setOnDrawerItemClickListener(new OnDrawerItemClick());
    }

    protected class OnDrawerItemClick implements Drawer.OnDrawerItemClickListener{
        @Override
        public boolean onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
            if (drawerItem instanceof Nameable) {
                listener.onDrawerItemSelected((Integer) drawerItem.getTag(),
                        ((Nameable) drawerItem).getName());
            }
            return false;
        }
    }

    protected abstract Typeface getTypeface();

    protected abstract int getColorRes();

    protected abstract IDrawerItem[] getDynamicDrawerItems();

    protected abstract IDrawerItem[] getSupportDrawerItem();

    protected abstract IDrawerItem[] getStaticDrawerItem();

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (drawer != null && drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public String getItemTitle(int position) {
        return navSDITitles[position];
    }

    public interface OnDrawerItemSelected {
        void onDrawerItemSelected(Integer tag, String title);
    }
}
