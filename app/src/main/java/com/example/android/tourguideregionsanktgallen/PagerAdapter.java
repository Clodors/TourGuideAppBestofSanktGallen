package com.example.android.tourguideregionsanktgallen;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class PagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public PagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AttractionsFragment();
            case 1:
                return new MuseumsFragment();
            case 2:
                return new NatureFragment();
            default:
                return new ZooFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.attractions_fragment_title);
            case 1:
                return context.getString(R.string.museums_fragment_title);
            case 2:
                return context.getString(R.string.nature_fragment_title);
            default:
                return context.getString(R.string.zoo_fragment_title);
        }
    }

    @Override
    public float getPageWidth(int position) {
        return super.getPageWidth(position);
    }
}
