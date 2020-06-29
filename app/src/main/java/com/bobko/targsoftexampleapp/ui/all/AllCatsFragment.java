package com.bobko.targsoftexampleapp.ui.all;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bobko.targsoftexampleapp.R;
import com.bobko.targsoftexampleapp.data.CatModel;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AllCatsFragment extends Fragment {

    private AllCatsViewModel allCatsViewModel;
    private int PAGE_SIZE = 5;
    AllCatsAdapter adapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_cats, container, false);

        allCatsViewModel = new ViewModelProvider(this).get(AllCatsViewModel.class);
        AllCatsPositionDataSource dataSource = new AllCatsPositionDataSource(allCatsViewModel.getCatsApi(),getString(R.string.api_key));

        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(PAGE_SIZE)
                .build();

        PagedList<CatModel> pagedList = new PagedList.Builder<>(dataSource, config)
                .setFetchExecutor(Executors.newSingleThreadExecutor())
                .setNotifyExecutor(new MainThreadExecutor())
                .build();


        adapter = new AllCatsAdapter(new CatDiffUtilCallback());
        adapter.submitList(pagedList);

        RecyclerView list = (RecyclerView) root.findViewById(R.id.allCatsRecyclerView);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.setAdapter(adapter);

        return root;
    }

    class MainThreadExecutor implements Executor {
        private final Handler mHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(Runnable command) {
            mHandler.post(command);
        }
    }
}