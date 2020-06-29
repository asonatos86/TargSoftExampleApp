package com.bobko.targsoftexampleapp.ui.favorites;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bobko.targsoftexampleapp.R;
import com.bobko.targsoftexampleapp.data.CatModel;
import com.bobko.targsoftexampleapp.ui.all.AllCatsViewModel;

import java.util.List;

public class FavoritesFragment extends Fragment {

    private FavoritesViewModel favoritesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cats, container, false);

        FavoritesAdapter adapter = new FavoritesAdapter();

        RecyclerView recyclerView = root.findViewById(R.id.allCatsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        favoritesViewModel = new ViewModelProvider(this).get(FavoritesViewModel.class);
        favoritesViewModel.getAllCats().observe(getViewLifecycleOwner(), new Observer<List<CatModel>>() {
            @Override
            public void onChanged(List<CatModel> catModels) {
                Log.d("logger",catModels.size()+"");
                adapter.setData(catModels);
                adapter.notifyDataSetChanged();
            }
        });
        return root;
    }
}