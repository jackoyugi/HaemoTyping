package co.ke.biofit.haemotyping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.os.Bundle;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {
    private static final Fragment[] mFragments = {
            new HomeFragment(),

    };
    private ArrayList<Tab> mTabs;

    private ViewPager mViewPager;
    private androidx.appcompat.app.ActionBar mActionBar;
    private SectionsPagerAdapter mSectionsPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupActionBar();
    }
    @Override
    protected void onResume() {
        super.onResume();
        TabUtils.setUpdateCurrentTab(true);
        mActionBar.selectTab(mTabs.get(TabUtils.getCurrentTabPosition()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        TabUtils.setUpdateCurrentTab(false);
    }
    private void setupActionBar() {
        mActionBar = getSupportActionBar();
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        setupPageViewer();

        mTabs = new ArrayList<Tab>();
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            Tab t = mActionBar.newTab().setText(TabUtils.getTabTitleId(i)).setTabListener(this);
            mTabs.add(t);
            mActionBar.addTab(t);
        }
    }
}