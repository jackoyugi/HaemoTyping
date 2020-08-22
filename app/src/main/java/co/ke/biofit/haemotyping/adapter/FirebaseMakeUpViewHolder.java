package co.ke.biofit.haemotyping.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import co.ke.biofit.haemotyping.Constants;
import co.ke.biofit.haemotyping.R;
import co.ke.biofit.haemotyping.model.MakeUpSearchResponse;
import co.ke.biofit.haemotyping.ui.MakeUpDetailActivity;

public class FirebaseMakeUpViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View mView;
    Context mContext;

    public FirebaseMakeUpViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindMakeUpSearchResponse(MakeUpSearchResponse makeUpSearchResponse) {
        ImageView makeUpImageView = (ImageView) mView.findViewById(R.id.makeup_image);
        TextView nameTextView = (TextView) mView.findViewById(R.id.makeUpNamesTextView);
        TextView categoryTextView = (TextView) mView.findViewById(R.id.categorysTextView);
        TextView ratingTextView = (TextView) mView.findViewById(R.id.ratingsTextView);

        Picasso.get().load(makeUpSearchResponse.getImageLink()).into(makeUpImageView);

        nameTextView.setText(makeUpSearchResponse.getName());
//        categoryTextView.setText(makeUpSearchResponse.getTagList().get(0));
//        ratingTextView.setText("Rating: " + makeUpSearchResponse.getRating() + "/5");
    }

    @Override
    public void onClick(View view) {

        final ArrayList<MakeUpSearchResponse> makeUpSearchResponse = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_MAKEUPSEARCHRESPONSE);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    makeUpSearchResponse.add(snapshot.getValue(MakeUpSearchResponse.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, MakeUpDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("makeUpSearchResponse", Parcels.wrap(makeUpSearchResponse));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }


}
