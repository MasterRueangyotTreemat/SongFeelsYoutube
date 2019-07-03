package com.noomnim.songfeelsyoutube.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.noomnim.songfeelsyoutube.fragments.ChannelFragment;
import com.noomnim.songfeelsyoutube.fragments.LiveFragment;
import com.noomnim.songfeelsyoutube.fragments.PlayListFragment;

public class PagerAdapter extends FragmentPagerAdapter {
    int nNumOfTabs;
    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super( fm );
        this.nNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                ChannelFragment tab1 = new ChannelFragment();
                return tab1;
            case 1:
                PlayListFragment tab2 = new PlayListFragment();
                return tab2;
            case 2:
                LiveFragment tab3 = new LiveFragment();
                return tab3;
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return nNumOfTabs;
    }
}
