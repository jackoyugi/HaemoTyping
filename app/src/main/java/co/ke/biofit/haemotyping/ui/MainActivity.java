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

//    private SharedPreferences mSharedPreferences;
//    private SharedPreferences.Editor mEditor;

    private DatabaseReference mSearchedLocationReference;

    private ValueEventListener mSearchedLocationReferenceListener;

    @BindView(R.id.savedMakeUpButton) Button mSavedMakeUpButton;



    @BindView(R.id.snapButton) Button mSnapButton;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;
    @BindView(R.id.locationEditText) EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();


        mSearchedLocationReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_LOCATION); //pinpoint location node



        mSearchedLocationReferenceListener = mSearchedLocationReference.addValueEventListener(new ValueEventListener(){ //attach listener

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) { //something changed!
                for (DataSnapshot locationSnapshot : dataSnapshot.getChildren()) {
                    String location = locationSnapshot.getValue().toString();
                    Log.d("Locations updated", "location: " + location); //log
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) { //update UI here if error occurred.

            }
        });



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //shared preference

//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mEditor = mSharedPreferences.edit();

        mSnapButton.setOnClickListener(this);

        mSavedMakeUpButton.setOnClickListener(this);


        FragmentManager fm = getSupportFragmentManager();
        HomeFragment HomeFragment = new HomeFragment ();
        HomeFragment.show(fm, "Sample Fragment");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSearchedLocationReference.removeEventListener(mSearchedLocationReferenceListener);
    }

    @Override
    public void onClick(View view) {
        if(view == mSnapButton) {
            String location = mLocationEditText.getText().toString();
            Log.d(TAG, location);

            saveLocationToFirebase(location);

//            if(!(location).equals("")) {
//                addToSharedPreferences(location);
//            }
            Intent intent = new Intent(MainActivity.this, MakeUpListActivity.class);
            intent.putExtra("location" , location);
            startActivity(intent);

        }

        if (view == mSavedMakeUpButton) {
            Intent intent = new Intent(MainActivity.this, SavedMakeUpListActivity.class);
            startActivity(intent);
        }

    }

    public void saveLocationToFirebase(String location) {
        mSearchedLocationReference.push().setValue(location);
    }

//    private void addToSharedPreferences(String location) {
//        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
//    }

    //debugging error logcat messages

    public void onFailure(Call<MakeUpSearchResponse> call, Throwable t) {
        Log.e(TAG, "onFailure: ", t);
    }
}
