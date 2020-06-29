package com.bobko.targsoftexampleapp.data;


import android.content.Context;

import com.bobko.targsoftexampleapp.CatsApp;
import com.bobko.targsoftexampleapp.R;
import com.bobko.targsoftexampleapp.data.database.CatDao;
import com.bobko.targsoftexampleapp.data.database.CatDatabase;
import com.bobko.targsoftexampleapp.data.retrofit.CatsApi;

import java.util.List;
import java.util.concurrent.Callable;

import androidx.lifecycle.LiveData;
import androidx.room.Room;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository  {
    private Retrofit retrofit;

    private CatsApi catsApi;

    private CatDatabase db;

    private CatDao catDao;

    public Repository(Context context)
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(context.getResources().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        catsApi = retrofit.create(CatsApi.class);

        db =  Room.databaseBuilder(context, CatDatabase.class, context.getResources().getString(R.string.database_name))
                .build();

        catDao = db.catDao();
    }

    public CatsApi getCatsApi() {
        return catsApi;
    }


    public LiveData<List<CatModel>> getFavoriteCats()
    {
        return catDao.getAll();
    }

    public void insertCat(CatModel catModel)
    {
        CatDatabase.databaseWriteExecutor.execute(() -> {
            catDao.insert(catModel);
        });
    }
}
