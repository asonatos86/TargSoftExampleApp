package com.bobko.targsoftexampleapp.data.database;

import com.bobko.targsoftexampleapp.data.CatModel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CatDao {
    @Query("SELECT * FROM catmodel")
    LiveData<List<CatModel>> getAll();

    @Insert
    void insert(CatModel cat);
}
