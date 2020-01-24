package com.devahmed.demo.mvxwithdependencyinjection.screens;

import com.devahmed.demo.mvxwithdependencyinjection.common.ObservableViewMvc;
import com.devahmed.demo.mvxwithdependencyinjection.model.Post;

import java.util.List;

public interface MainScreenMvc extends ObservableViewMvc<MainScreenMvc.Listener> {

    public interface Listener{
        void onCLick(Post post);
    }

    public void bindDate(List<Post> posts);
}
