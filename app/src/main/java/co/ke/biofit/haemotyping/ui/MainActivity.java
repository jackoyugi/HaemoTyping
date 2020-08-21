package co.ke.biofit.haemotyping.ui;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.biofit.haemotyping.Constants;
import co.ke.biofit.haemotyping.R;

import co.ke.biofit.haemotyping.activity.MakeUpSearchResponse;
import co.ke.biofit.haemotyping.fragment.HomeFragment;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;


    @BindView(R.id.snapButton) Button mSnapButton;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;
    @BindView(R.id.locationEditText) EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //shared preference

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mSnapButton.setOnClickListener(this);


        FragmentManager fm = getSupportFragmentManager();
        HomeFragment HomeFragment = new HomeFragment ();
        HomeFragment.show(fm, "Sample Fragment");
    }

    @Override
    public void onClick(View view) {
        if(view == mSnapButton) {
            String brand = mLocationEditText.getText().toString();
            Log.d(TAG, brand);

            if(!(brand).equals("")) {
                addToSharedPreferences(brand);
            }
            Intent intent = new Intent(MainActivity.this, MakeUpListActivity.class);
            intent.putExtra("brand", brand);
            startActivity(intent);

        }

    }

    private void addToSharedPreferences(String location) {
        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
    }

    //debugging error logcat messages

    public void onFailure(Call<MakeUpSearchResponse> call, Throwable t) {
        Log.e(TAG, "onFailure: ", t);
    }
}
