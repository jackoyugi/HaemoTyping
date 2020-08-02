package co.ke.biofit.haemotyping.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import android.annotation.SuppressLint;
import androidx.appcompat.app.ActionBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import co.ke.biofit.haemotyping.R;
import co.ke.biofit.haemotyping.adapter.SectionsPagerAdapter;
import co.ke.biofit.haemotyping.fragment.BrowseFragment;
import co.ke.biofit.haemotyping.fragment.HomeFragment;
import co.ke.biofit.haemotyping.util.TabUtils;


@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    private static final androidx.fragment.app.Fragment[] mFragments ={
            new androidx.fragment.app.Fragment(),
    };

    private ArrayList<ActionBar.Tab> mTabs;
    private ViewPager mViewPager;
    private androidx.appcompat.app.ActionBar mActionBar;
    private SectionsPagerAdapter mSectionsPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupActionBar();
    }

    private void setupActionBar() {
        mActionBar = getSupportActionBar();
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        setupPageViewer();
        mTabs = new ArrayList<ActionBar.Tab>();
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            ActionBar.Tab t = mActionBar.newTab().setText(TabUtils.getTabTitleId(i)).setTabListener(this);
            mTabs.add(t);
            mActionBar.addTab(t);
        }
    }


    @SuppressLint("WrongViewCast")
    private void setupPageViewer() {
        mSectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), mFragments);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);
            }
        });
    }

    // Inflate the menu; this adds items to the action bar if it is present.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        final MenuItem actionSnapIt = menu.findItem(R.id.action_snap_it);
        MenuItemCompat.getActionView(actionSnapIt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(actionSnapIt);
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_snap_it:
                if (MediaUtils.isExternalStorageWritable()) {
                    Intent intent = new Intent(this, CameraActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "External Storage not available.",
                            Toast.LENGTH_SHORT).show();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        TabUtils.setCurrentTabPosition(tab.getPosition());
//        mViewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}