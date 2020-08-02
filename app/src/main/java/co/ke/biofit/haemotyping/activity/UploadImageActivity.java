package co.ke.biofit.haemotyping.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import co.ke.biofit.haemotyping.R;
import co.ke.biofit.haemotyping.util.MediaUtils;

public class UploadImageActivity extends AppCompatActivity {
    public static final String ARG_IMAGE_URI = "image_uri";

    private Uri mImageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_upload_image);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().hasExtra(ARG_IMAGE_URI)) {
            mImageUri = getIntent().getParcelableExtra(ARG_IMAGE_URI);
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), mImageUri);
                if (bitmap != null) {
                    ImageView imageUpload = (ImageView) findViewById(R.id.image_upload);
                    imageUpload.setImageBitmap(bitmap);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
