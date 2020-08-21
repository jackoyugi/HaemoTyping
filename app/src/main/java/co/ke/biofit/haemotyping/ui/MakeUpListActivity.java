package co.ke.biofit.haemotyping.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.biofit.haemotyping.Constants;
import co.ke.biofit.haemotyping.R;
import co.ke.biofit.haemotyping.activity.MakeUpSearchResponse;
import co.ke.biofit.haemotyping.adapter.MakeUpAdapter;
import co.ke.biofit.haemotyping.service.MakeUpApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static co.ke.biofit.haemotyping.service.MakeUpClient.getClient;


public class MakeUpListActivity extends AppCompatActivity {
    public static final String TAG = MakeUpListActivity.class.getSimpleName();

    private SharedPreferences mSharedPreferences;
    private String mRecentAddress;

    @BindView(R.id.makeup_recyclerView) RecyclerView mRecyclerView;
    private MakeUpAdapter mAdapter;

    public List<MakeUpSearchResponse> makeUpSearchResponse;

    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup);
        ButterKnife.bind(this);



        Intent intent = getIntent();

        String location = intent.getStringExtra("location");

        MakeUpApi client = getClient();

        //responsible for getting data from makeup api and displays through recycler adapters as stated

        Call<List<MakeUpSearchResponse>> call = client.getProducts(location, "makeUpSearchResponse");

        call.enqueue(new Callback<List<MakeUpSearchResponse>>() {

            @Override
            public void onResponse(Call<List<MakeUpSearchResponse>> call, Response<List<MakeUpSearchResponse>> response) {
                hideProgressBar();

                if (response.isSuccessful()) {


                    makeUpSearchResponse= new ArrayList<>(response.body());

                    mAdapter = new MakeUpAdapter(MakeUpListActivity.this, makeUpSearchResponse);


                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MakeUpListActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

                    showProducts();
                } else {
                    showUnsuccessfulMessage();
                }

            }
            // throws error message implements the call method

            @Override
            public void onFailure(Call<List<MakeUpSearchResponse>> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();

            }
        });

//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mRecentAddress = mSharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY, null);
//        Log.d("Shared Pref Location", mRecentAddress);
//        if (mRecentAddress != null) {
//            getProducts(mRecentAddress);
//        }

    }
    // below displays error when the search is successful or available

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showProducts() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }


}
