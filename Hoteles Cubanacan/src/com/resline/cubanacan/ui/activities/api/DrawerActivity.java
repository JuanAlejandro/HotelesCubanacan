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

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import labsoft.promo.kehaypahoy.ui.activities.UserProfileActivity;
import labsoft.promo.kehaypahoy.utils.constants.DrawerMenu;
import labsoft.promo.kehaypahoy.utils.constants.Fonts;
import labsoft.promo.kehaypahoy.utils.constants.Keys;
import labsoft.promo.kehaypahoy.utils.*;
import labsoft.promo.kehaypahoy.R;

public abstract class DrawerActivity extends BaseActivity implements View.OnClickListener {
    public static final int TAG_EVENTOS = 0;
    public static final int TAG_ARTISTAS = 1;
    public static final int TAG_LUGARES = 2;
    public static final int TAG_INFORMACION = 3;
    public static final int TAG_AYUDA = 4;
    public static final int TAG_SUMATE = 5;
    public static final int TAG_AMIGOS = 6;

    // this is temporal
    public static final Integer TAG_CUSTOM = DrawerMenu.CUSTOM_EVENT;
    private static final String TAG = "DrawerActivity";

    // navigation drawer components
    // static drawer items (#sdi)
    protected String[] navSDITitles;         // static titles of menu drawer navigator

    protected String[] supportDITitles;         // static titles of menu drawer navigator

    // style
    protected int selColorRes;

    // current area
    protected int area = DrawerMenu.EVENTOS;

    // exit var
    boolean doubleBackToExitPressedOnce = false;

    // to load view again when the user preferences change in user profile
    protected boolean loadAgain = false;

    // new drawer
    public Drawer drawer = null;

    // typeface for drawer elements
    protected Typeface typeface;

    private ImageView imageHeader;
    private TextView nameHeader;

    private String userName;
    private String imgProfilePath;

    // on drawer item selected listener
    private OnDrawerItemSelected listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // load view components (drawer, toolbar, etc.)
        loadViewComponents();
    }

    protected void setDrawerItemSelectedListener(OnDrawerItemSelected listener) {
        this.listener = listener;
    }

    // Load visual components of drawer and toolbar
    private void loadViewComponents() {
        // init user data
        typeface = Typeface.createFromAsset(getApplicationContext().getAssets(), Fonts.CUSTOM_FONT_REGULAR);

        // Init drawer menu titles
        navSDITitles = getSDITitles();        // Get the array of titles of the menu

        supportDITitles = getSupportDITitles();

        // Load drawer
        loadDrawer();

        // load header drawer
        loadHeaderDrawer();

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
        // set typeface
        typeface = getTypeface();
        // get header with profile initializated
        selColorRes = getColorRes();

        drawer = new DrawerBuilder()
                .withActivity(mActivity)
                .withToolbar(mToolBar)
                .withDrawerWidthRes(R.dimen.drawer_menu_width)
                .withHeader(R.layout.drawer_header)
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

    // load header of the drawer
    private void loadHeaderDrawer() {
        View headerDrawer = drawer.getHeader();
        // Set profile image
        imageHeader = (ImageView) headerDrawer.findViewById(R.id.ivProfile);
        imgProfilePath = prefEditor.getString(Keys.SP_PROFILE_IMAGE_PATH, "");
        if (!imgProfilePath.equals(""))
            ImageUtils.loadScaledImageInto(mActivity, imgProfilePath, imageHeader, 100, 100);
        findViewById(R.id.tvSeeUserProfile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DrawerActivity.this, UserProfileActivity.class));
            }
        });
        // Set name to textview
        nameHeader = (TextView) headerDrawer.findViewById(R.id.tvUserName);
        userName = prefEditor.getString(Keys.SP_PROFILE_NAME, mResources.getString(R.string.user_name));
        nameHeader.setText(userName);
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (drawer != null && drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;

            Toast.makeText(this, R.string.exit_msg, Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
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
        if (prefEditor.getBoolean(Keys.PREF_USER_PHOTO_CHANGE, false)) {
            imgProfilePath = prefEditor.getString(Keys.SP_PROFILE_IMAGE_PATH, "");
            if (!imgProfilePath.equals(""))
                ImageUtils.loadScaledImageInto(mActivity, imgProfilePath, imageHeader, 100, 100);
            prefEditor.putBoolean(Keys.PREF_USER_PHOTO_CHANGE, false);
        }

        if (prefEditor.getBoolean(Keys.PREF_USER_NAME_CHANGE, false)) {
            userName = prefEditor.getString(Keys.SP_PROFILE_NAME, mResources.getString(R.string.user_name));
            nameHeader.setText(userName);
            prefEditor.putBoolean(Keys.PREF_USER_NAME_CHANGE, false);
        }
    }

    public String getItemTitle(int position) {
        return navSDITitles[position];
    }

    public interface OnDrawerItemSelected {
        void onDrawerItemSelected(Integer tag, String title);
    }
}
