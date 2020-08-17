package co.ke.biofit.haemotyping.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.biofit.haemotyping.R;
import co.ke.biofit.haemotyping.activity.MakeUpSearchResponse;
import retrofit2.Call;

public class MakeUpAdapter extends RecyclerView.Adapter<MakeUpAdapter.viewHolder> {
    public static final String TAG = MakeUpAdapter.class.getSimpleName();
    private Context mContext;
    private List<MakeUpSearchResponse> makeUpSearchResponses;


    public MakeUpAdapter(Context context, List<MakeUpSearchResponse> makeUpSearchResponse) {
       makeUpSearchResponses=makeUpSearchResponse;
       mContext=context;

    }
    //inflating the adapter

    @Override
    public MakeUpAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.makeup_list_item, parent, false);
        viewHolder viewHolder = new viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MakeUpAdapter.viewHolder holder, int position){
        holder.bindMakeUp(makeUpSearchResponses.get(position));
    }
    //check for the arraylist

    @Override
    public int getItemCount() {
        return makeUpSearchResponses.size();
    }

    //information to be displayed are stored in viewholder


    public class viewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.makeup_name) TextView mNameTextView;
        @BindView(R.id.makeup_brand) TextView mBrandTextView;
        @BindView(R.id.makeup_image) ImageView mImageView;

        private Context mContext;

        public viewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }


        public void bindMakeUp(MakeUpSearchResponse makeUpSearchResponse){
            mNameTextView.setText(makeUpSearchResponse.getName());
            mBrandTextView.setText(makeUpSearchResponse.getBrand());
            Picasso.get().load(makeUpSearchResponse.getImageLink()).into(mImageView);

        }
    }

    // this one is helpful for showing error messages in the logcat for ease debugging
    public void onFailure(Call<MakeUpSearchResponse> call, Throwable t) {
        Log.e(TAG, "onFailure: ", t);
    }
}