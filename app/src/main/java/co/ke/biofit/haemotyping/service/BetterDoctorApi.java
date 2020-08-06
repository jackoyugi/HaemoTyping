package co.ke.biofit.haemotyping.service;

import co.ke.biofit.haemotyping.activity.BetterDoctorSearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BetterDoctorApi {
    @GET("doctors/search")
    Call<BetterDoctorSearchResponse> getDoctors(
            @Query("location") String location,
            @Query("term") String term
    );
}
