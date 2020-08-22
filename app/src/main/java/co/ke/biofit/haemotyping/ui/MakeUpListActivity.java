package co.ke.biofit.haemotyping.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.biofit.haemotyping.Constants;
import co.ke.biofit.haemotyping.R;
import co.ke.biofit.haemotyping.model.MakeUpSearchResponse;
import co.ke.biofit.haemotyping.adapter.MakeUpAdapter;
import co.ke.biofit.haemotyping.service.MakeUpApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static co.ke.biofit.haemotyping.service.MakeUpClient.getClient;


public class MakeUpListActivity extends AppCompatActivity {
    public static final String TAG = MakeUpListActivity.class.getSimpleName();

    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;


    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mRecentAddress;

    @BindView(R.id.makeup_recyclerView) RecyclerView mRecyclerView;
    private MakeUpAdapter mAdapter;

    public List<MakeUpSearchResponse> makeUpSearchResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup);
        ButterKnife.bind(this);


        Intent intent = getIntent();

        String location = intent.getStringExtra("location");

        getProducts(location);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentAddress = mSharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY, null);

        if (mRecentAddress != null) {
            getProducts(mRecentAddress);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                addToSharedPreferences(query);
                getProducts(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }

        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    private void getProducts(String location){


       final MakeUpApi client = getClient();

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

    }

    private void addToSharedPreferences(String location) {
        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
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
