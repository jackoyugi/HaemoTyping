package co.ke.biofit.haemotyping.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.biofit.haemotyping.Constants;
import co.ke.biofit.haemotyping.R;
import co.ke.biofit.haemotyping.model.MakeUpSearchResponse;

public class MakeUpDetailFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.makeUpImageView)
    ImageView mImageLabel;
    @BindView(R.id.makeUpNameTextView) TextView mNameLabel;
    @BindView(R.id.makeUpTextView) TextView mCategoriesLabel;
    @BindView(R.id.ratingTextView) TextView mRatingLabel;
    @BindView(R.id.websiteTextView) TextView mWebsiteLabel;
    @BindView(R.id.phoneTextView) TextView mPhoneLabel;
    @BindView(R.id.addressTextView) TextView mAddressLabel;
    @BindView(R.id.saveMakeUpButton) TextView mSavedMakeUpButton;

    private MakeUpSearchResponse makeUpSearchResponse;
    private Bundle savedInstanceState;

    private ArrayList<MakeUpSearchResponse> responses;


    public static MakeUpDetailFragment newInstance(MakeUpSearchResponse makeUpSearchResponse)  {
        MakeUpDetailFragment makeUpDetailFragment = new MakeUpDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("makeUpSearchResponse", Parcels.wrap(makeUpSearchResponse));
        makeUpDetailFragment.setArguments(args);
        return makeUpDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
//        this.savedInstanceState = savedInstanceState;
        super.onCreate(savedInstanceState);
        makeUpSearchResponse = Parcels.unwrap(getArguments().getParcelable("makeUpSearchResponse")); //changed to responses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_makeup_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.get().load(makeUpSearchResponse.getImageLink()).into(mImageLabel);


        mNameLabel.setText(makeUpSearchResponse.getName());
        mCategoriesLabel.setText(android.text.TextUtils.join(", ", makeUpSearchResponse.getProductColors())); //changed
//        mRatingLabel.setText(Double.toString(makeUpSearchResponse.getRating()) + "/5");
        mPhoneLabel.setText(makeUpSearchResponse.getProductType());
        mAddressLabel.setText(makeUpSearchResponse.getWebsiteLink().toString());
        mCategoriesLabel.setText(android.text.TextUtils.join(", ", makeUpSearchResponse.getAddress()));
        mWebsiteLabel.setText(makeUpSearchResponse.getDescription());

        mWebsiteLabel.setOnClickListener(this);
        mPhoneLabel.setOnClickListener(this);
        mAddressLabel.setOnClickListener(this);

        mSavedMakeUpButton.setOnClickListener(this);

        return view;
    }


    public MakeUpDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onClick(View view) {

        if (view == mSavedMakeUpButton) {
            DatabaseReference makeUpSearchResponseRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_MAKEUPSEARCHRESPONSE);
            makeUpSearchResponseRef.push().setValue(makeUpSearchResponse);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
        if (view == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(makeUpSearchResponse.getWebsiteLink()));
            startActivity(webIntent);
        }
        if (view == mPhoneLabel) {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:" + makeUpSearchResponse.getProductLink()));
            startActivity(phoneIntent);
        }
        if (view == mAddressLabel) {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:" + makeUpSearchResponse.getAddress()));

            startActivity(mapIntent);
        }

        if (view == mSavedMakeUpButton) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();
            DatabaseReference restaurantRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_MAKEUPSEARCHRESPONSE)
                    .child(uid);
            DatabaseReference pushRef = restaurantRef.push();
            String pushId = pushRef.getKey();
            makeUpSearchResponse.setPushId(pushId);
            pushRef.setValue(makeUpSearchResponse);

            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }



    }
}