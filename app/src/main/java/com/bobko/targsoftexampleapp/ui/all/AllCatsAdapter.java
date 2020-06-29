package com.bobko.targsoftexampleapp.ui.all;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bobko.targsoftexampleapp.CatsApp;
import com.bobko.targsoftexampleapp.R;
import com.bobko.targsoftexampleapp.data.CatModel;
import com.bobko.targsoftexampleapp.databinding.CatsListItemBinding;
import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class AllCatsAdapter extends PagedListAdapter<CatModel, AllCatsAdapter.AllCatsViewHolder> {
    protected AllCatsAdapter(DiffUtil.ItemCallback<CatModel> diffUtilCallback) {
        super(diffUtilCallback);
    }

    @NonNull
    @Override
    public AllCatsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CatsListItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.cats_list_item, parent, false);
        return new AllCatsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCatsViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    @BindingAdapter({"app:url"})
    public static void loadImage(ImageView view, String url)
    {
        Glide.with(CatsApp.instance)
                .load(url)
                .into(view);
    }

    class AllCatsViewHolder extends RecyclerView.ViewHolder {
        CatsListItemBinding binding;
        public AllCatsViewHolder(@NonNull CatsListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(CatModel cat)
        {
            binding.setCat(cat);
            binding.setHandler(new ItemClickHandler());
            binding.executePendingBindings();
        }
    }
}
