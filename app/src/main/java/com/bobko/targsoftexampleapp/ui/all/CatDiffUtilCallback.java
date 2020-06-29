package com.bobko.targsoftexampleapp.ui.all;

import com.bobko.targsoftexampleapp.data.CatModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class CatDiffUtilCallback extends DiffUtil.ItemCallback<CatModel> {

    @Override
    public boolean areItemsTheSame(@NonNull CatModel oldItem, @NonNull CatModel newItem) {
        if (oldItem.getId()==newItem.getId())
            return true;
        else return false;
    }

    @Override
    public boolean areContentsTheSame(@NonNull CatModel oldItem, @NonNull CatModel newItem) {
        if (oldItem.getUrl().equals(newItem.getUrl()))
            return true;
        else return false;
    }
}
