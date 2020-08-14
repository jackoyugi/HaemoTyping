package co.ke.biofit.haemotyping.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.ke.biofit.haemotyping.R;
import co.ke.biofit.haemotyping.activity.MakeUpSearchResponse;
import co.ke.biofit.haemotyping.ui.MainActivity;
import retrofit2.Call;

public class MakeUpAdapter extends RecyclerView.Adapter<MakeUpAdapter.viewHolder> {
    public static final String TAG = MakeUpAdapter.class.getSimpleName();
    private Context context;
    private ArrayList<MakeUpSearchResponse> makeUpSearchResponses;


    public MakeUpAdapter(Context context, ArrayList<MakeUpSearchResponse> makeUpSearchResponse) {
        this.makeUpSearchResponses=makeUpSearchResponse;
        this.context=context;

    }

    @NonNull
    @Override
    public MakeUpAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.makeup_list_item, viewGroup, false);
        return new MakeUpAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MakeUpAdapter.viewHolder viewHolder, int position) {
        String[] makeup_name = new String[makeUpSearchResponses.size()];
        String[] makeup_brand = new String[makeUpSearchResponses.size()];
        String[] makeup_image = new String[makeUpSearchResponses.size()];
        for (int i = 0; i<makeup_name.length; i++){
            viewHolder.makeup_name.setText(makeUpSearchResponses.get(i).getName());
        }
        for (int i =0; i<makeup_brand.length; i++){
            viewHolder.makeup_brand.setText(makeUpSearchResponses.get(i).getBrand());
        }
        for (int i=0; i< makeup_image.length; i++){
            Picasso.get().load(makeUpSearchResponses.get(i).getImageLink()).into(viewHolder.makeup_image);
        }

//        viewHolder.makeup_name.setText(makeUpSearchResponses.get(12).getName());
//        viewHolder.makeup_brand.setText(makeUpSearchResponses.get(12).getBrand());
//
//        Picasso.get().load(makeUpSearchResponses.get(12).getImageLink()).into(viewHolder.makeup_image);

    }

    @Override
    public int getItemCount() {
        return makeUpSearchResponses.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        private ImageView makeup_image;
        private TextView makeup_name, makeup_brand;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            makeup_image=(ImageView)itemView.findViewById(R.id.makeup_image);
            makeup_name=(TextView)itemView.findViewById(R.id.makeup_name);
            makeup_brand=(TextView)itemView.findViewById(R.id.makeup_brand);
        }
    }
    public void onFailure(Call<MakeUpSearchResponse> call, Throwable t) {
        Log.e(TAG, "onFailure: ", t);
    }
}
