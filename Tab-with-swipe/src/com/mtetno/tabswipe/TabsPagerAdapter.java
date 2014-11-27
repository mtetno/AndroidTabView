package com.mtetno.tabswipe;

import com.mtetno.tabswipe.KCFragment;
import com.mtetno.tabswipe.TestFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
        case 0:
            // Top Rated fragment activity
            return new TestFragment();
        case 1:
            // Games fragment activity
            return new KCFragment();

        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 2;
    }

}