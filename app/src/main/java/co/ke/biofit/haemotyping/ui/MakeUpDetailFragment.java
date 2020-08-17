package co.ke.biofit.haemotyping.ui;

import android.icu.util.ULocale;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MakeUpDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MakeUpDetailFragment extends Fragment {
    @BindView(R.id.restaurantImageView)
    ImageView mImageLabel;
    @BindView(R.id.restaurantNameTextView) TextView mNameLabel;
    @BindView(R.id.cuisineTextView) TextView mCategoriesLabel;
    @BindView(R.id.ratingTextView) TextView mRatingLabel;
    @BindView(R.id.websiteTextView) TextView mWebsiteLabel;
    @BindView(R.id.phoneTextView) TextView mPhoneLabel;
    @BindView(R.id.addressTextView) TextView mAddressLabel;
    @BindView(R.id.saveRestaurantButton) TextView mSaveRestaurantButton;

    private MakeUpSearchResponse makeUpSearchResponse;
    private Bundle savedInstanceState;


    public static MakeUpDetailFragment newInstance(MakeUpSearchResponse makeUpSearchResponse) {
        MakeUpDetailFragment makeUpDetailFragment = new MakeUpDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("restaurant", Parcels.wrap(makeUpSearchResponse));
        makeUpDetailFragment.setArguments(args);
        return makeUpDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        super.onCreate(savedInstanceState);
        makeUpSearchResponse = Parcels.unwrap(getArguments().getParcelable("makeUpsearchResponse"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_makeup_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.get().load(makeUpSearchResponse.getImageLink()).into(mImageLabel);

        List<String> categories = new ArrayList<>();



        mNameLabel.setText(makeUpSearchResponse.getName());
        mCategoriesLabel.setText(android.text.TextUtils.join(", ", categories));
        mRatingLabel.setText(Double.toString(makeUpSearchResponse.getRating()) + "/5");
        mPhoneLabel.setText(makeUpSearchResponse.getProductType());
        mAddressLabel.setText(makeUpSearchResponse.getWebsiteLink().toString());

        return view;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MakeUpDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MakeUpFragrment.
     */
    // TODO: Rename and change types and number of parameters
    public static MakeUpDetailFragment newInstance(String param1, String param2) {
        MakeUpDetailFragment fragment = new MakeUpDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

}