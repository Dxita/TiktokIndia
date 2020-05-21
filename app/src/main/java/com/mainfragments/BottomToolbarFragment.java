package com.mainfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dev.DashboardActivity;
import com.dev.R;
import com.helpers.AppBaseFragmentHelper;

public class BottomToolbarFragment extends AppBaseFragmentHelper {

    RelativeLayout home_rl,search_rl,add_rl,notification_rl,profile_rl;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.include_bottom_toolbar,container,false);
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

        home_rl.setOnClickListener(this);
        search_rl.setOnClickListener(this);
        add_rl.setOnClickListener(this);
        notification_rl.setOnClickListener(this);
        profile_rl.setOnClickListener(this);

        setBottomToolbarView();
    }

    private void setBottomToolbarView(){

    }

    @Override
    public void onClick(View view) {
        if (getActivity() != null && getActivity() instanceof DashboardActivity){
            switch (view.getId()){
                case R.id.home_rl:
                    showSimpleToast("Home Clicked");
                    break;
                case R.id.search_rl:
                    showSimpleToast("Search Clicked");
                    break;
                case R.id.add_rl:
                    showSimpleToast("Add Clicked");
                    break;
                case R.id.notification_rl:
                    showSimpleToast("Notification Clicked");
                    break;
                case R.id.profile_rl:
                    showSimpleToast("Profile Clicked");
                    break;
            }
        }
    }
}
