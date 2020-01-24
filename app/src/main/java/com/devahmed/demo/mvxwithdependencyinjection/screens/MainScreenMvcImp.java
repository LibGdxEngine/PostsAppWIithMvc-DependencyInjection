package com.devahmed.demo.mvxwithdependencyinjection.screens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devahmed.demo.mvxwithdependencyinjection.R;
import com.devahmed.demo.mvxwithdependencyinjection.adapters.PostsAdapter;
import com.devahmed.demo.mvxwithdependencyinjection.common.BaseObservableMvcView;
import com.devahmed.demo.mvxwithdependencyinjection.model.Post;

import java.util.ArrayList;
import java.util.List;

public class MainScreenMvcImp extends BaseObservableMvcView<MainScreenMvc.Listener> implements MainScreenMvc, PostsAdapter.OnItemClickListener {
    RecyclerView recyclerView;
    List<Post> mPostsList = new ArrayList<>();
    PostsAdapter adapter;
    public MainScreenMvcImp(LayoutInflater inflater , ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.activity_main , parent , false));
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        adapter = new PostsAdapter(mPostsList , this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void bindDate(List<Post> posts) {
        this.mPostsList = posts;
        adapter.setList(posts);
    }

    @Override
    public void OnItemClicked(Post post) {
        for(Listener listener : getmListeners()){
            listener.onCLick(post);
        }
    }
}
