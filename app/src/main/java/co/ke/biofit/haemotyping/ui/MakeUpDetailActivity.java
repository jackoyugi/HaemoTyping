package co.ke.biofit.haemotyping.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.biofit.haemotyping.R;
import co.ke.biofit.haemotyping.activity.MakeUpSearchResponse;
import co.ke.biofit.haemotyping.activity.ProductColor;
import co.ke.biofit.haemotyping.adapter.MakeUpPageAdapter;
import retrofit2.Call;

public class MakeUpDetailActivity extends AppCompatActivity {
    public static final String TAG = MakeUpDetailActivity.class.getSimpleName();

    @BindView(R.id.viewPager) ViewPager mViewPager;
    private MakeUpPageAdapter adapterViewPager;



    List<MakeUpSearchResponse> makeUpSearchResponses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup_detail);
        ButterKnife.bind(this);

        makeUpSearchResponses = Parcels.unwrap(getIntent().getParcelableExtra("makeUpSearchResponses"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new MakeUpPageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, makeUpSearchResponses);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
    public void onFailure(Call<MakeUpSearchResponse> call, Throwable t) {
        Log.e(TAG, "onFailure: ", t);
    }
}
