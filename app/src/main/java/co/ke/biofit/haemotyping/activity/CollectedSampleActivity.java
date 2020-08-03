package co.ke.biofit.haemotyping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.biofit.haemotyping.R;
import co.ke.biofit.haemotyping.adapter.HaemotypeArrayAdapter;

public class CollectedSampleActivity extends AppCompatActivity {
    public static final String TAG = CollectedSampleActivity.class.getSimpleName();
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;

    private String[] collectedSample = new String[] {"Jack Winter", "Winnie's Pinches",
            "Seeds of Gold", "The Pupper", "Luc Lac", "Sweet Basil", "Grace Butt"};

    private String[] bloodGroup = new String[] {"O+/Rh+", "A-/Rh-", "B+/Rh+", "A+/Rh-", "AB-/Rh-", "AB+/Rh+", "O+/Rh+" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collectedsample);
        ButterKnife.bind(this);

        HaemotypeArrayAdapter adapter = new HaemotypeArrayAdapter(this, android.R.layout.simple_list_item_1, collectedSample, bloodGroup);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String collectedSample = ((TextView) view).getText().toString();
                Log.v("CollectedSampleActivity", "In the onItemClickListener!");
                Toast.makeText(CollectedSampleActivity.this, collectedSample, Toast.LENGTH_LONG).show();
            }
        });
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        mLocationTextView.setText("Here are all the people with blood group() near you: " );
        Log.d("CollectedSampleActivity", "In the onCreate method!");

    }


}
