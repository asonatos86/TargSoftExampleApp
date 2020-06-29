package com.bobko.targsoftexampleapp.data.database;

import com.bobko.targsoftexampleapp.data.CatModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {CatModel.class}, exportSchema = false, version = 1)
public abstract class CatDatabase extends RoomDatabase {
    public abstract CatDao catDao();
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(4);

}
