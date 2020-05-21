package com.dev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.helpers.AppBaseActivityHelper;

public class DashboardActivity extends AppBaseActivityHelper {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        hideToolbar();
    }
}
