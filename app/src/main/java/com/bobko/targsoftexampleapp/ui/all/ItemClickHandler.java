package com.bobko.targsoftexampleapp.ui.all;

import android.content.Context;
import android.content.DialogInterface;

import com.bobko.targsoftexampleapp.CatsApp;
import com.bobko.targsoftexampleapp.DownloadWorkManager;
import com.bobko.targsoftexampleapp.R;
import com.bobko.targsoftexampleapp.data.CatModel;

import androidx.appcompat.app.AlertDialog;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

public class ItemClickHandler {
    public void itemClick(CatModel catModel, Context context)
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setItems(R.array.all_menu, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which)
                        {
                            case 0:
                                download(catModel);
                                break;
                            case 1:
                                saveToFavorites(catModel);
                        }
                    }
                });
        builder.create().show();
    }
    private void download(CatModel catModel)
    {
        Data workerData = new Data.Builder()
                .putString("url",catModel.getUrl())
                .build();
        OneTimeWorkRequest myWorkRequest = new OneTimeWorkRequest.Builder(DownloadWorkManager.class)
                .setInputData(workerData)
                .build();
        WorkManager.getInstance().enqueue(myWorkRequest);
    }

    private void saveToFavorites(CatModel catModel)
    {
        CatsApp.instance.getRepository().insertCat(catModel);
    }
}
