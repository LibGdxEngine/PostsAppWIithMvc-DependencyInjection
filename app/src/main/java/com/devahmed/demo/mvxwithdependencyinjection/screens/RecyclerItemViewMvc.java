package com.devahmed.demo.mvxwithdependencyinjection.screens;

import com.devahmed.demo.mvxwithdependencyinjection.common.ObservableViewMvc;
import com.devahmed.demo.mvxwithdependencyinjection.model.Post;

public interface RecyclerItemViewMvc extends ObservableViewMvc<RecyclerItemViewMvc.Listener> {

    public interface Listener{
        void onItemClicked(Post post);
    }

    public void binData(Post post);
}
