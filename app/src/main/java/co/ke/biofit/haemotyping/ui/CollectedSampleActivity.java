package co.ke.biofit.haemotyping.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.biofit.haemotyping.R;
import co.ke.biofit.haemotyping.activity.BetterDoctorSearchResponse;
import co.ke.biofit.haemotyping.activity.Datum;
import co.ke.biofit.haemotyping.activity.Specialty_;
import co.ke.biofit.haemotyping.adapter.HaemotypeArrayAdapter;
import co.ke.biofit.haemotyping.service.BetterDoctorApi;
import co.ke.biofit.haemotyping.service.BetterDoctorClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CollectedSampleActivity extends AppCompatActivity {
    public static final String TAG = CollectedSampleActivity.class.getSimpleName();
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;

//    private String[] collectedSample = new String[] {"Jack Winter", "Winnie's Pinches",
//            "Seeds of Gold", "The Pupper", "Luc Lac", "Sweet Basil", "Grace Butt", "Cate Jitter", "The Movers", "We the Winner", "Dont Ask", "Am Here"};
//
//    private String[] bloodGroup = new String[] {"O+/Rh+", "A-/Rh-", "B+/Rh+", "A+/Rh-", "AB-/Rh-", "AB+/Rh+", "O+/Rh+", "A+", "AB-", "O+", "B+", "B-"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collectedsample);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location;
        location = intent.getStringExtra("location");

        BetterDoctorApi client = BetterDoctorClient.getClient();



        Call<BetterDoctorSearchResponse> call = client.getDoctors(location, "doctors");

        call.enqueue(new Callback<BetterDoctorSearchResponse>() {
            @Override
            public void onResponse(Call<BetterDoctorSearchResponse> call, Response<BetterDoctorSearchResponse> response) {
                if (response.isSuccessful()) {
                    List<Datum> betterDoctorList = response.body().getData();
                    String[] doctors = new String[betterDoctorList.size()];
                    String[] specialties = new String[betterDoctorList.size()];

                    for (int i = 0; i < doctors.length; i++){
                        doctors[i] = String.valueOf(betterDoctorList.get(i).getProfile());
                    }

                    for (int i = 0; i < specialties.length; i++) {
                        Specialty_ specialty = betterDoctorList.get(i).getSpecialties().get(0);
                        specialties[i] = specialty.getName();
                    }

                    ArrayAdapter adapter
                            = new HaemotypeArrayAdapter(CollectedSampleActivity.this, android.R.layout.simple_list_item_1, doctors, specialties);
                    mListView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<BetterDoctorSearchResponse> call, Throwable t) {

            }
        });

//        HaemotypeArrayAdapter adapter = new HaemotypeArrayAdapter(this, android.R.layout.simple_list_item_1, collectedSample, bloodGroup);
//        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String collectedSample = ((TextView) view).getText().toString();
                Log.v("CollectedSampleActivity", "In the onItemClickListener!");
                Toast.makeText(CollectedSampleActivity.this, collectedSample, Toast.LENGTH_LONG).show();
            }
        });

        mLocationTextView.setText("Here are all the people with blood group (?) near you: " + location);
        Log.d("CollectedSampleActivity", "In the onCreate method!");

    }

    public void onFailure(Call<BetterDoctorSearchResponse> call, Throwable t) {
        Log.e(TAG, "onFailure: ", t);
    }


}
