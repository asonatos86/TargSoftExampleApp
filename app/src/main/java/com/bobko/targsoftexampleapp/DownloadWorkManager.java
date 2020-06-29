package com.bobko.targsoftexampleapp;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import static android.content.Context.DOWNLOAD_SERVICE;

public class DownloadWorkManager extends Worker {

    public DownloadWorkManager(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        String fileName = getInputData().getString("url");
        fileName = fileName.substring(fileName.lastIndexOf("/")+1,fileName.length()-1);

        DownloadManager.Request request=new DownloadManager.Request(Uri.parse(getInputData().getString("url")));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Example");
        request.setDescription("Download cat");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);

        DownloadManager downloadManager = (DownloadManager) getApplicationContext().getSystemService(DOWNLOAD_SERVICE);
        downloadManager.enqueue(request);

        return Result.success();
    }
}
