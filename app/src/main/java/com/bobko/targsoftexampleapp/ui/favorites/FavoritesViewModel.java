package com.bobko.targsoftexampleapp.ui.favorites;

import android.app.Application;

import com.bobko.targsoftexampleapp.CatsApp;
import com.bobko.targsoftexampleapp.data.CatModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class FavoritesViewModel extends AndroidViewModel {

    private LiveData<List<CatModel>> catLiveData;

    public FavoritesViewModel(@NonNull Application application) {
        super(application);

        catLiveData = CatsApp.instance.getRepository().getFavoriteCats();
    }

   public LiveData<List<CatModel>> getAllCats()
   {
       return catLiveData;
   }


}