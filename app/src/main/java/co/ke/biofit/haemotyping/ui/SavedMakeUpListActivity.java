package co.ke.biofit.haemotyping.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import co.ke.biofit.haemotyping.Constants;
import co.ke.biofit.haemotyping.R;
import co.ke.biofit.haemotyping.activity.MakeUpSearchResponse;
import co.ke.biofit.haemotyping.adapter.FirebaseMakeUpViewHolder;

public class SavedMakeUpListActivity extends AppCompatActivity {
    private DatabaseReference mMakeUpReference;
    private FirebaseRecyclerAdapter<MakeUpSearchResponse, FirebaseMakeUpViewHolder> mFirebaseAdapter;

    @BindView(R.id.makeup_recyclerView) RecyclerView mRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup);

        mMakeUpReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_MAKEUPSEARCHRESPONSE);
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<MakeUpSearchResponse> options =
                new FirebaseRecyclerOptions.Builder<MakeUpSearchResponse>()
                        .setQuery(mMakeUpReference, MakeUpSearchResponse.class)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<MakeUpSearchResponse, FirebaseMakeUpViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseMakeUpViewHolder firebaseMakeUpViewHolder, int position, @NonNull MakeUpSearchResponse makeUpSearchResponse) {
                firebaseMakeUpViewHolder.bindMakeUpSearchResponse(makeUpSearchResponse);
            }

            @NonNull
            @Override
            public FirebaseMakeUpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.makeup_list_item, parent, false);
                return new FirebaseMakeUpViewHolder(view);
            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }
}