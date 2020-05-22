package com.appbasehelpers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.dev.AddVideoPostActivity;
import com.dev.DashboardActivity;
import com.dev.NotificationActivity;
import com.dev.ProfileActivity;
import com.dev.SearchActivity;

public class AppBaseFragmentHelper extends Fragment implements View.OnClickListener {

    public AppBaseFragmentHelper getInstance(){
        AppBaseFragmentHelper appBaseFragmentHelper = new AppBaseFragmentHelper();
        return appBaseFragmentHelper;
    }

    public AppBaseFragmentHelper() {
    }

    @Override
    public void onClick(View v) {

    }

    public void showSimpleToast(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    public void goToDashboardActivity(Bundle bundle){
        Intent intent = new Intent(getActivity(), DashboardActivity.class);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        getActivity().startActivity(intent);
    }

    public void goToSearchActivity(Bundle bundle){
        Intent intent = new Intent(getActivity(), SearchActivity.class);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        getActivity().startActivity(intent);
    }

    public void goToAddVideoPostActivity(Bundle bundle){
        Intent intent = new Intent(getActivity(), AddVideoPostActivity.class);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        getActivity().startActivity(intent);
    }

    public void goToNotificationActivity(Bundle bundle){
        Intent intent = new Intent(getActivity(), NotificationActivity.class);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        getActivity().startActivity(intent);
    }

    public void goToProfileActivity(Bundle bundle){
        Intent intent = new Intent(getActivity(), ProfileActivity.class);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        getActivity().startActivity(intent);
    }
}
