package co.ke.biofit.haemotyping.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.biofit.haemotyping.R;
import co.ke.biofit.haemotyping.activity.MakeUpSearchResponse;

public class MakeUpDetailFragment extends Fragment {
    @BindView(R.id.makeUpImageView)
    ImageView mImageLabel;
    @BindView(R.id.makeUpNameTextView) TextView mNameLabel;
    @BindView(R.id.makeUpTextView) TextView mCategoriesLabel;
    @BindView(R.id.ratingTextView) TextView mRatingLabel;
    @BindView(R.id.websiteTextView) TextView mWebsiteLabel;
    @BindView(R.id.phoneTextView) TextView mPhoneLabel;
    @BindView(R.id.addressTextView) TextView mAddressLabel;
    @BindView(R.id.saveMakeUpButton) TextView mSaveRestaurantButton;

    private MakeUpSearchResponse makeUpSearchResponse;
    private Bundle savedInstanceState;

    private ArrayList<MakeUpSearchResponse> responses;


    public static MakeUpDetailFragment newInstance(MakeUpSearchResponse makeUpSearchResponse) {
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

        List<String> categories = new ArrayList<>();


        mNameLabel.setText(makeUpSearchResponse.getName());
        mCategoriesLabel.setText(android.text.TextUtils.join(", ", categories));
//        mRatingLabel.setText(Double.toString(makeUpSearchResponse.getRating()) + "/5");
        mPhoneLabel.setText(makeUpSearchResponse.getProductType());
        mAddressLabel.setText(makeUpSearchResponse.getWebsiteLink().toString());

        return view;
    }


    public MakeUpDetailFragment() {
        // Required empty public constructor
    }

}