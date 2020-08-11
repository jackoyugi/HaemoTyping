package co.ke.biofit.haemotyping.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.biofit.haemotyping.R;
import co.ke.biofit.haemotyping.activity.MakeUpSearchResponse;
import co.ke.biofit.haemotyping.activity.ProductColor;
import co.ke.biofit.haemotyping.adapter.HaemotypeArrayAdapter;
import co.ke.biofit.haemotyping.service.MakeUpApi;
import co.ke.biofit.haemotyping.service.MakeUpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CollectedSampleActivity extends AppCompatActivity {
    public static final String TAG = CollectedSampleActivity.class.getSimpleName();
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collectedsample);
        ButterKnife.bind(this);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String collectedSample = ((TextView) view).getText().toString();
                Log.v("CollectedSampleActivity", "In the onItemClickListener!");
                Toast.makeText(CollectedSampleActivity.this, collectedSample, Toast.LENGTH_LONG).show();
            }
        });


        Intent intent = getIntent();

        String brand = intent.getStringExtra("covergirl");
        mLocationTextView.setText("Here are all the people with blood group (?) near you: " + brand);
        Log.d("CollectedSampleActivity", "In the onCreate method!");

        MakeUpApi client = MakeUpClient.getClient();

        Call<MakeUpSearchResponse> call = client.getDoctors(brand, "lipstick");

        call.enqueue(new Callback<MakeUpSearchResponse>() {
            @Override
            public void onResponse(Call<MakeUpSearchResponse> call, Response<MakeUpSearchResponse> response) {
                if (response.isSuccessful()) {
                    List<ProductColor> betterDoctorList = response.body().getProductColors();
                    String[] doctors = new String[betterDoctorList.size()];
                    String[] specialties = new String[betterDoctorList.size()];

                    for (int i = 0; i < doctors.length; i++) {
                        doctors[i] = String.valueOf(betterDoctorList.get(i).getHexValue());
                    }

                    for (int i = 0; i < specialties.length; i++) {
                        String colourName = betterDoctorList.get(i).getColourName();
                        specialties[i] = String.valueOf(colourName.getClass());
                    }

                    ArrayAdapter adapter = new HaemotypeArrayAdapter(CollectedSampleActivity.this, android.R.layout.simple_list_item_1, doctors, specialties);
                    mListView.setAdapter(adapter);

                    showRestaurants();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<MakeUpSearchResponse> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();
                Log.e(TAG, "onFailure: ", t);
            }
        });

    }
    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showRestaurants() {
        mListView.setVisibility(View.VISIBLE);
        mLocationTextView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }


}
