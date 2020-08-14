package co.ke.biofit.haemotyping.ui;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.biofit.haemotyping.R;

import co.ke.biofit.haemotyping.activity.MakeUpSearchResponse;
import co.ke.biofit.haemotyping.fragment.HomeFragment;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.snapButton) Button mSnapButton;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;
    @BindView(R.id.locationEditText) EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

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
            Intent intent = new Intent(MainActivity.this, CollectedSampleActivity.class);
            intent.putExtra("brand", brand);
            startActivity(intent);

        }

    }


    public void onFailure(Call<MakeUpSearchResponse> call, Throwable t) {
        Log.e(TAG, "onFailure: ", t);
    }
}
