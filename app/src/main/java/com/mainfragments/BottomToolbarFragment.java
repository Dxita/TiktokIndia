package com.mainfragments;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dev.DashboardActivity;
import com.dev.NotificationActivity;
import com.dev.ProfileActivity;
import com.dev.R;
import com.dev.SearchActivity;
import com.appbasehelpers.AppBaseFragmentHelper;

public class BottomToolbarFragment extends AppBaseFragmentHelper {

    RelativeLayout home_rl, search_rl, add_rl, notification_rl, profile_rl;
    LinearLayout horizontal_ll;
    ImageView home_iv, search_iv, notification_iv, profile_iv;
    TextView home_tv, search_tv, notification_tv, profile_tv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.include_bottom_toolbar, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeComponents();
    }

    public void initializeComponents() {
        home_rl = getView().findViewById(R.id.home_rl);
        search_rl = getView().findViewById(R.id.search_rl);
        add_rl = getView().findViewById(R.id.add_rl);
        notification_rl = getView().findViewById(R.id.notification_rl);
        profile_rl = getView().findViewById(R.id.profile_rl);
        horizontal_ll = getView().findViewById(R.id.horizontal_ll);

        home_iv = getView().findViewById(R.id.home_iv);
        search_iv = getView().findViewById(R.id.search_iv);
        notification_iv = getView().findViewById(R.id.notification_iv);
        profile_iv = getView().findViewById(R.id.profile_iv);

        home_tv = getView().findViewById(R.id.home_tv);
        search_tv = getView().findViewById(R.id.search_tv);
        notification_tv = getView().findViewById(R.id.notification_tv);
        profile_tv = getView().findViewById(R.id.profile_tv);

        home_rl.setOnClickListener(this);
        search_rl.setOnClickListener(this);
        add_rl.setOnClickListener(this);
        notification_rl.setOnClickListener(this);
        profile_rl.setOnClickListener(this);

        setBottomToolbarView();
    }

    private void setBottomToolbarView() {
        if (getActivity() != null && getActivity() instanceof DashboardActivity) {
            horizontal_ll.setBackgroundColor(Color.TRANSPARENT);
        } else if (getActivity() != null && getActivity() instanceof SearchActivity) {
            horizontal_ll.setBackgroundColor(Color.WHITE);
            search_iv.setColorFilter(R.color.clr_black, PorterDuff.Mode.SRC_ATOP);
            home_iv.setColorFilter(R.color.clr_app_gray, PorterDuff.Mode.SRC_ATOP);
            notification_iv.setColorFilter(R.color.clr_app_gray, PorterDuff.Mode.SRC_ATOP);
            profile_iv.setColorFilter(R.color.clr_app_gray, PorterDuff.Mode.SRC_ATOP);

            search_tv.setTextColor(Color.BLACK);
            home_tv.setTextColor(getResources().getColor(R.color.clr_app_gray));
            notification_tv.setTextColor(getResources().getColor(R.color.clr_app_gray));
            profile_tv.setTextColor(getResources().getColor(R.color.clr_app_gray));
        } else if (getActivity() != null && getActivity() instanceof NotificationActivity) {
            horizontal_ll.setBackgroundColor(Color.WHITE);
            notification_iv.setColorFilter(R.color.clr_black, PorterDuff.Mode.SRC_ATOP);
            home_iv.setColorFilter(R.color.clr_app_gray, PorterDuff.Mode.SRC_ATOP);
            search_iv.setColorFilter(R.color.clr_app_gray, PorterDuff.Mode.SRC_ATOP);
            profile_iv.setColorFilter(R.color.clr_app_gray, PorterDuff.Mode.SRC_ATOP);

            notification_tv.setTextColor(Color.BLACK);
            home_tv.setTextColor(getResources().getColor(R.color.clr_app_gray));
            search_tv.setTextColor(getResources().getColor(R.color.clr_app_gray));
            profile_tv.setTextColor(getResources().getColor(R.color.clr_app_gray));
        } else if (getActivity() != null && getActivity() instanceof ProfileActivity) {
            horizontal_ll.setBackgroundColor(Color.WHITE);
            profile_iv.setColorFilter(R.color.clr_black, PorterDuff.Mode.SRC_ATOP);
            home_iv.setColorFilter(R.color.clr_app_gray, PorterDuff.Mode.SRC_ATOP);
            search_iv.setColorFilter(R.color.clr_app_gray, PorterDuff.Mode.SRC_ATOP);
            notification_iv.setColorFilter(R.color.clr_app_gray, PorterDuff.Mode.SRC_ATOP);

            profile_tv.setTextColor(Color.BLACK);
            home_tv.setTextColor(getResources().getColor(R.color.clr_app_gray));
            search_tv.setTextColor(getResources().getColor(R.color.clr_app_gray));
            notification_tv.setTextColor(getResources().getColor(R.color.clr_app_gray));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_rl:
                goToDashboardActivity(null);
                break;
            case R.id.search_rl:
                goToSearchActivity(null);
                break;
            case R.id.add_rl:
                goToAddVideoPostActivity(null);
                break;
            case R.id.notification_rl:
                goToNotificationActivity(null);
                break;
            case R.id.profile_rl:
                goToProfileActivity(null);
                break;
        }
    }
}
