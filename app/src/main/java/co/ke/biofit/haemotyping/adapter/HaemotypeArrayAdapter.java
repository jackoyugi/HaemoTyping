package co.ke.biofit.haemotyping.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

public class HaemotypeArrayAdapter extends ArrayAdapter {

    private Context mContext;
    private String[] mCollectedSample;
    private String[] mBloodGroup;

    public HaemotypeArrayAdapter(Context context, int resource, String[] collectedSample, String[] bloodGroup) {
        super(context, resource);
        this.mContext = mContext;
        this.mCollectedSample = mCollectedSample;
        this.mBloodGroup = mBloodGroup;
    }

        @Override
        public Object getItem(int position) {
            String collectedSample = mCollectedSample[position];
            String bloodGroup = mBloodGroup[position];
            return String.format("%s \nServes great: %s", collectedSample, bloodGroup);
        }
        @Override
        public int getCount() {
            return mCollectedSample.length;
        }

}
