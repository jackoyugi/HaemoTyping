package co.ke.biofit.haemotyping.adapter;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

import co.ke.biofit.haemotyping.model.MakeUpSearchResponse;
import co.ke.biofit.haemotyping.ui.MakeUpDetailFragment;
import retrofit2.Call;

public class MakeUpPageAdapter extends FragmentPagerAdapter {
    public static final String TAG = MakeUpPageAdapter.class.getSimpleName();

    private List<MakeUpSearchResponse> makeUpSearchResponses;

    public MakeUpPageAdapter(FragmentManager fm, int behavior, List<MakeUpSearchResponse> makeUpSearchResponse) {
        super(fm, behavior);
       makeUpSearchResponses = makeUpSearchResponse;
    }

    @Override
    public Fragment getItem(int position) {                                                          //changed to fragment from makeupdetailfragment
        return MakeUpDetailFragment.newInstance(makeUpSearchResponses.get(position));
    }

    @Override
    public int getCount() {
        return  makeUpSearchResponses.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return makeUpSearchResponses.get(position).getName();
    }

    public void onFailure(Call<MakeUpSearchResponse> call, Throwable t) {
        Log.e(TAG, "onFailure: ", t);
    }
}
