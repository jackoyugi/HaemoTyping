package co.ke.biofit.haemotyping.service;
import co.ke.biofit.haemotyping.activity.MakeUpSearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MakeUpApi {
    @GET("products.json/search")
    Call<MakeUpSearchResponse> getDoctors(
            @Query("brand") String brand,
            @Query("brand_type") String brand_type
    );
}
