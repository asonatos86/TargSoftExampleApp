package com.bobko.targsoftexampleapp;

import android.app.Application;

import com.bobko.targsoftexampleapp.data.Repository;


public class CatsApp extends Application {
    Repository repository;

    public static CatsApp instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        repository = new Repository(this);
    }

    public Repository getRepository()
    {
        return repository;
    }

    public Application getInstance(){
        return instance;
    }
}
