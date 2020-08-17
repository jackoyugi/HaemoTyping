package co.ke.biofit.haemotyping.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

import co.ke.biofit.haemotyping.activity.MakeUpSearchResponse;
import co.ke.biofit.haemotyping.ui.MakeUpDetailFragment;

public class MakeUpPageAdapter extends FragmentPagerAdapter {
    private List<MakeUpSearchResponse> makeUpSearchResponses;

    public MakeUpPageAdapter(FragmentManager fm, int behavior, List<MakeUpSearchResponse> makeUpSearchResponses) {
        super(fm, behavior);
       makeUpSearchResponses=makeUpSearchResponses;
    }

    @Override
    public Fragment getItem(int position) {
        return MakeUpDetailFragment.newInstance(makeUpSearchResponses.get(position));
    }

    @Override
    public int getCount() {
        return makeUpSearchResponses.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return makeUpSearchResponses.get(position).getName();
    }
}
