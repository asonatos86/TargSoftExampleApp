package com.bobko.targsoftexampleapp.ui.all;

import android.util.Log;

import com.bobko.targsoftexampleapp.data.CatModel;
import com.bobko.targsoftexampleapp.data.retrofit.CatsApi;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllCatsPositionDataSource extends PositionalDataSource<CatModel> {
    CatsApi api;
    String apiKey;
    AllCatsPositionDataSource (CatsApi api, String apiKey) {
        this.api = api;
        this.apiKey = apiKey;
    }
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<CatModel> callback) {
        api.getCats(params.requestedStartPosition, params.requestedLoadSize, apiKey).enqueue(new Callback<List<CatModel>>() {
            @Override
            public void onResponse(Call<List<CatModel>> call, Response<List<CatModel>> response) {
                callback.onResult(response.body(),0);
            }

            @Override
            public void onFailure(Call<List<CatModel>> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<CatModel> callback) {
        api.getCats(params.startPosition, params.loadSize, apiKey).enqueue(new Callback<List<CatModel>>() {
            @Override
            public void onResponse(Call<List<CatModel>> call, Response<List<CatModel>> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<List<CatModel>> call, Throwable t) {

            }
        });
    }
}
