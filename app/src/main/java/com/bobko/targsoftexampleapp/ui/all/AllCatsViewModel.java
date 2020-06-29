package com.bobko.targsoftexampleapp.ui.all;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.bobko.targsoftexampleapp.CatsApp;
import com.bobko.targsoftexampleapp.R;
import com.bobko.targsoftexampleapp.data.CatModel;
import com.bobko.targsoftexampleapp.data.Repository;
import com.bobko.targsoftexampleapp.data.retrofit.CatsApi;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllCatsViewModel extends AndroidViewModel {

    private CatsApi catsApi;

    public AllCatsViewModel(@NonNull Application application) {
        super(application);

        catsApi = CatsApp.instance.getRepository().getCatsApi();
    }


    public CatsApi getCatsApi() {
        return catsApi;
    }
}