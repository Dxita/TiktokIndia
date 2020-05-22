package com.mainfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.appbasehelpers.AppBaseFragmentHelper;
import com.dev.NotificationActivity;
import com.dev.ProfileActivity;
import com.dev.R;

public class ToolbarFragment extends AppBaseFragmentHelper {

    ImageView message_iv;
    LinearLayout notification_ll,profile_toolbar_ll;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.include_toolbar,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeComponents();
    }

    public void initializeComponents() {
        if (getView() == null)return;
        notification_ll = getView().findViewById(R.id.notification_ll);
        profile_toolbar_ll = getView().findViewById(R.id.profile_toolbar_ll);
        message_iv = getView().findViewById(R.id.message_iv);

        message_iv.setOnClickListener(this);

        setToolbarView();
    }

    private void setToolbarView(){
        if (getActivity() != null && getActivity() instanceof NotificationActivity){
            notification_ll.setVisibility(View.VISIBLE);
            profile_toolbar_ll.setVisibility(View.GONE);
        } else if (getActivity() != null && getActivity() instanceof ProfileActivity){
            notification_ll.setVisibility(View.GONE);
            profile_toolbar_ll.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
