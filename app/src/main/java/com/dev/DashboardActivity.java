package com.dev;

import android.os.Bundle;

import com.appbasehelpers.AppBaseActivityHelper;

public class DashboardActivity extends AppBaseActivityHelper {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        hideToolbar();
    }
}
