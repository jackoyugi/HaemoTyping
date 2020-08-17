package co.ke.biofit.haemotyping.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.biofit.haemotyping.R;
import co.ke.biofit.haemotyping.activity.MakeUpSearchResponse;
import co.ke.biofit.haemotyping.adapter.MakeUpPageAdapter;

public class MakeUpDetailActivity extends AppCompatActivity {

    @BindView(R.id.viewPager) ViewPager mViewPager;
    private MakeUpPageAdapter adapterViewPager;
    List<MakeUpSearchResponse> mMakeUpSearchResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup_detail);
        ButterKnife.bind(this);

        mMakeUpSearchResponse = Parcels.unwrap(getIntent().getParcelableExtra("makeups"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new MakeUpPageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mMakeUpSearchResponse);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
