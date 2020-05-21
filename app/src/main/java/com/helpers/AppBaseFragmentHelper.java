package com.helpers;

import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

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
}
