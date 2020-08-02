package co.ke.biofit.haemotyping.activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.biofit.haemotyping.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.snapButton) Button mSnapButton;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSnapButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mSnapButton) {
            Intent intent = new Intent(MainActivity.this, CollectedSampleActivity.class);
            startActivity(intent);
        }

    }
}
