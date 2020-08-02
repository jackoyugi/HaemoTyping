package co.ke.biofit.haemotyping.adapter;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import co.ke.biofit.haemotyping.util.TabUtils;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private Fragment[] mFragments;
    private Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm, Fragment[] fragments) {
        super(fm);
        this.mContext = context;
        this.mFragments = fragments;
    }
    @NonNull

    @Override
    public Fragment getItem(int position) {
        return getPageFragment(position);
    }

    public Fragment getPageFragment(int position) {
        return mFragments[position];
    }


    @Override
    public int getCount() {
        return TabUtils.TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TabUtils.getTabTitleId(position));
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }
}
