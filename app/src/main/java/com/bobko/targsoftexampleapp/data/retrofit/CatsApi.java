package com.bobko.targsoftexampleapp.data.retrofit;

import com.bobko.targsoftexampleapp.data.CatModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CatsApi {
    @GET("images/search")
    Call<List<CatModel>> getCats(@Query("limit") int limit, @Query("page") int page,@Query("x-api-key") String apiKey);
}
