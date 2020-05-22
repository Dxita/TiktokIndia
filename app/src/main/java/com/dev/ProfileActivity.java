package com.dev;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.appbasehelpers.AppBaseActivityHelper;
import com.fragments.LikedVideosFragment;
import com.fragments.PostsFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppBaseActivityHelper {

    TabLayout tab_layout;
    ViewPager view_pager;

    private int[] icons = {
            R.drawable.your_posts_icon,
            R.drawable.favourite_icon
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        view_pager = findViewById(R.id.view_pager);
        setUpViewPager(view_pager);

        tab_layout = findViewById(R.id.tab_layout);
        tab_layout.setupWithViewPager(view_pager);
        setTabIcons();
    }

    private void setTabIcons() {
        tab_layout.getTabAt(0).setIcon(icons[0]);
        tab_layout.getTabAt(1).setIcon(icons[1]);
    }


    private void setUpViewPager(ViewPager view_pager) {
        ProfileViewPagerAdapter adapter = new ProfileViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PostsFragment());
        adapter.addFragment(new LikedVideosFragment());
        view_pager.setAdapter(adapter);
    }

    public static class ProfileViewPagerAdapter extends FragmentPagerAdapter {

        List<Fragment> fragmentList = new ArrayList<>();

        public ProfileViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void addFragment(Fragment fragment){
            fragmentList.add(fragment);
        }
    }
}
