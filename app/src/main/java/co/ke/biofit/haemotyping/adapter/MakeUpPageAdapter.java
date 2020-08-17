package co.ke.biofit.haemotyping.adapter;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

import co.ke.biofit.haemotyping.activity.MakeUpSearchResponse;
import co.ke.biofit.haemotyping.ui.MakeUpDetailFragment;
import retrofit2.Call;

public class MakeUpPageAdapter extends FragmentPagerAdapter {
    public static final String TAG = MakeUpPageAdapter.class.getSimpleName();

    private List<MakeUpSearchResponse> mMakeUpSearchResponse;

    public MakeUpPageAdapter(FragmentManager fm, int behavior, List<MakeUpSearchResponse> makeUpSearchResponse) {
        super(fm, behavior);
       mMakeUpSearchResponse=makeUpSearchResponse;
    }

    @Override
    public Fragment getItem(int position) {
        return MakeUpDetailFragment.newInstance(mMakeUpSearchResponse.get(position));
    }

    @Override
    public int getCount() {
        return mMakeUpSearchResponse.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mMakeUpSearchResponse.get(position).getName();
    }

    public void onFailure(Call<MakeUpSearchResponse> call, Throwable t) {
        Log.e(TAG, "onFailure: ", t);
    }
}
