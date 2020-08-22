package co.ke.biofit.haemotyping.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import co.ke.biofit.haemotyping.model.MakeUpSearchResponse;
import retrofit2.Call;

public class HaemotypeArrayAdapter extends ArrayAdapter {
    public static final String TAG = HaemotypeArrayAdapter.class.getSimpleName();

    private Context mContext;
    private String[] mCollectedSample;
    private String[] mBloodGroup;

    public HaemotypeArrayAdapter(Context mContext, int resource, String[] mCollectedSample, String[] mBloodGroup) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mCollectedSample = mCollectedSample;
        this.mBloodGroup = mBloodGroup;

    }
    @Override
        public Object getItem(int position) {
            String collectedSample = mCollectedSample[position];
            String bloodGroup = mBloodGroup[position];
            return String.format("%s \nBlood Group: %s", collectedSample, bloodGroup);
        }
        @Override
        public int getCount() {
            return mCollectedSample.length;
        }

    public void onFailure(Call<MakeUpSearchResponse> call, Throwable t) {
        Log.e(TAG, "onFailure: ", t);
    }

}
