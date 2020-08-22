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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.biofit.haemotyping.Constants;
import co.ke.biofit.haemotyping.R;

import co.ke.biofit.haemotyping.activity.MakeUpSearchResponse;
import co.ke.biofit.haemotyping.fragment.HomeFragment;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.savedMakeUpButton) Button mSavedMakeUpButton;
    @BindView(R.id.snapButton) Button mSnapButton;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSnapButton.setOnClickListener(this);
        mSavedMakeUpButton.setOnClickListener(this);

        FragmentManager fm = getSupportFragmentManager();
        HomeFragment HomeFragment = new HomeFragment ();
        HomeFragment.show(fm, "Sample Fragment");
    }


    @Override
    public void onClick(View view) {
        if(view == mSnapButton) {
            Intent intent = new Intent(MainActivity.this, MakeUpListActivity.class);
            startActivity(intent);

        }

        if (view == mSavedMakeUpButton) {
            Intent intent = new Intent(MainActivity.this, SavedMakeUpListActivity.class);
            startActivity(intent);
        }

    }

    //debugging error logcat messages

    public void onFailure(Call<MakeUpSearchResponse> call, Throwable t) {
        Log.e(TAG, "onFailure: ", t);
    }
}
