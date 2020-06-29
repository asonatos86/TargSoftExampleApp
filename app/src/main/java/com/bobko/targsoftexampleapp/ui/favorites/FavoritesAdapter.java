package com.bobko.targsoftexampleapp.ui.favorites;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bobko.targsoftexampleapp.R;
import com.bobko.targsoftexampleapp.data.CatModel;
import com.bobko.targsoftexampleapp.databinding.CatsListItemBinding;
import com.bobko.targsoftexampleapp.databinding.FavoritesListItemBinding;
import com.bobko.targsoftexampleapp.ui.all.ItemClickHandler;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder> {

    private List<CatModel> items = new LinkedList<>();

    public void setData(List<CatModel> data) {
        items.clear();
        items.addAll(data);
    }

    @NonNull
    @Override
    public FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        FavoritesListItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.favorites_list_item, parent, false);
        return new FavoritesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class FavoritesViewHolder extends RecyclerView.ViewHolder
    {
        FavoritesListItemBinding binding;
        public FavoritesViewHolder(@NonNull FavoritesListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(CatModel cat)
        {
            binding.setCat(cat);
            binding.setHandler(new FavoritesItemClickHandler());
            binding.executePendingBindings();
        }
    }
}
