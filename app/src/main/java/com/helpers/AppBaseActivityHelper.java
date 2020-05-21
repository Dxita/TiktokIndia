package com.helpers;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.dev.AddVideoPostActivity;
import com.dev.DashboardActivity;
import com.dev.NotificationActivity;
import com.dev.ProfileActivity;
import com.dev.R;
import com.dev.SearchActivity;
import com.dev.SelectYourGenderActivity;
import com.dev.SelectYourLanguageActivity;
import com.mainfragments.BottomToolbarFragment;

public class AppBaseActivityHelper extends AppCompatActivity implements View.OnClickListener {

    BottomToolbarFragment bottomToolbarFragment;

    public AppBaseActivityHelper getInstance(){
        AppBaseActivityHelper appBaseActivityHelper = new AppBaseActivityHelper();
        return appBaseActivityHelper;
    }

    public AppBaseActivityHelper() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideToolbar();
        setStatusBarColor();

        Fragment bottom_fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_bottom_toolbar_id);
        if (bottom_fragment instanceof Fragment){
            bottomToolbarFragment = (BottomToolbarFragment)bottom_fragment;
            bottomToolbarFragment.initializeComponents();
        }
    }

    public void hideToolbar(){
        getSupportActionBar().hide();
    }

    public void setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.clr_app_gray));
        }
    }

    public void setSplashScreenBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.clr_white));
        }
    }

    @Override
    public void onClick(View v) {

    }

    public void goToDashboardActivity(Bundle bundle){
        Intent intent = new Intent(this, DashboardActivity.class);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void goToSearchActivity(Bundle bundle){
        Intent intent = new Intent(this, SearchActivity.class);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void goToAddVideoPostActivity(Bundle bundle){
        Intent intent = new Intent(this, AddVideoPostActivity.class);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void goToNotificationActivity(Bundle bundle){
        Intent intent = new Intent(this, NotificationActivity.class);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void goToProfileActivity(Bundle bundle){
        Intent intent = new Intent(this, ProfileActivity.class);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void goToSelectYourLanguageActivity(Bundle bundle){
        Intent intent = new Intent(this, SelectYourLanguageActivity.class);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void goToSelectYourGenderActivity(Bundle bundle){
        Intent intent = new Intent(this, SelectYourGenderActivity.class);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
}
