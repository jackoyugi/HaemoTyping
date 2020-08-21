//package co.ke.biofit.haemotyping.services;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import butterknife.internal.Constants;
//import co.ke.biofit.haemotyping.activity.MakeUpSearchResponse;
//import okhttp3.Call;
//import okhttp3.HttpUrl;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class MakeUpService {
//    public static void findMakeUp( Callback callback) {
//        OkHttpClient client = new OkHttpClient.Builder()
//                .build();
//
//        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://makeup-api.herokuapp.com/api/v1products.json/").newBuilder();
//        String url = urlBuilder.build().toString();
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//
//        Call call = client.newCall(request);
//        call.enqueue((okhttp3.Callback) callback);
//    }
//
//    public ArrayList<MakeUpSearchResponse> processResults(Response response) {
//        ArrayList<MakeUpSearchResponse> makeUpSearchResponses = new ArrayList<>();
//        try {
//            String jsonData = response.body().toString();
//            JSONObject salonJSON = new JSONObject(jsonData);
//            JSONArray beautyParlorJSON = salonJSON.getJSONArray("makeupsearchresponse");
//            if (response.isSuccessful()) {
//                for (int i = 0; i < beautyParlorJSON.length(); i++) {
//                    JSONObject beautyparlorJSON = beautyParlorJSON.getJSONObject(i);
//                    String name = beautyparlorJSON.getString("name");
//                    String brand = beautyparlorJSON.optString("brand");
//                    String apiFeaturedImage = beautyparlorJSON.getString("imageUrl");
//
//                    MakeUpSearchResponse makeUpSearchResponse = new MakeUpSearchResponse(name, brand, apiFeaturedImage);
//                    makeUpSearchResponses.add(makeUpSearchResponse);
//                }
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return makeUpSearchResponses;
//    }
//}
