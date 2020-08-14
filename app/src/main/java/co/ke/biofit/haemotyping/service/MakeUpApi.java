package co.ke.biofit.haemotyping.service;

import java.util.List;

import co.ke.biofit.haemotyping.activity.MakeUpSearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MakeUpApi {
    @GET("?brand=covergirl")
    Call<List<MakeUpSearchResponse>> getProducts(
            @Query("location") String location,
            @Query("term") String term
    );
}
