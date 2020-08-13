package co.ke.biofit.haemotyping.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.biofit.haemotyping.R;
import co.ke.biofit.haemotyping.activity.MakeUpSearchResponse;
import co.ke.biofit.haemotyping.service.MakeUpApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CollectedSampleActivity extends AppCompatActivity {
    public static final String TAG = CollectedSampleActivity.class.getSimpleName();
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    ArrayList<MakeUpSearchResponse> makeUpSearchResponse=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collectedsample);
        ButterKnife.bind(this);

        getClientResponse();

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String collectedSample = ((TextView) view).getText().toString();
                Log.v("CollectedSampleActivity", "In the onItemClickListener!");
                Toast.makeText(CollectedSampleActivity.this, collectedSample, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();

        String brand = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the people with blood group (?) near you: " + brand);

//        MakeUpApi client = getClient();

    }

    private void getClientResponse() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://makeup-api.herokuapp.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MakeUpApi client=retrofit.create(MakeUpApi.class);
        Call <List<MakeUpSearchResponse>> call = client.getProducts();

        call.enqueue(new Callback<List<MakeUpSearchResponse>>() {
            @Override
            public void onResponse(Call<List<MakeUpSearchResponse>> call, Response<List<MakeUpSearchResponse>> response) {
                makeUpSearchResponse= new ArrayList<>(response.body());
                Toast.makeText(CollectedSampleActivity.this, "Success", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<MakeUpSearchResponse>> call, Throwable t) {
                Toast.makeText(CollectedSampleActivity.this, "Failed", Toast.LENGTH_SHORT).show();
//                hideProgressBar();
//                showFailureMessage();
                Log.e(TAG, "onFailure: ", t);
            }
        });

    }

//    private void showFailureMessage() {
//        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
//        mErrorTextView.setVisibility(View.VISIBLE);
//    }
//
//    private void showUnsuccessfulMessage() {
//        mErrorTextView.setText("Something went wrong. Please try again later");
//        mErrorTextView.setVisibility(View.VISIBLE);
//    }
//
//    private void showProducts() {
//        mListView.setVisibility(View.VISIBLE);
//        mLocationTextView.setVisibility(View.VISIBLE);
//    }
//
//    private void hideProgressBar() {
//        mProgressBar.setVisibility(View.GONE);
//    }


}
