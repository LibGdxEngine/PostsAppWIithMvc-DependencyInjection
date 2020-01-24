package com.devahmed.demo.mvxwithdependencyinjection.dependencyInjection;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.devahmed.demo.mvxwithdependencyinjection.screens.PostListItemViewMvcImp;
import com.devahmed.demo.mvxwithdependencyinjection.screens.MainScreenMvcImp;

public class ViewMvcFactory {

    private final LayoutInflater inflater;

    public ViewMvcFactory(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public MainScreenMvcImp getPostsRecyclerViewMvcImp(@Nullable ViewGroup parent){
        return new MainScreenMvcImp(inflater, parent) {
        };
    }

    public PostListItemViewMvcImp getPostsListItemViewMvcImp(@Nullable ViewGroup parent){
        return new PostListItemViewMvcImp(inflater , parent);
    }


}
