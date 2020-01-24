package com.devahmed.demo.mvxwithdependencyinjection.dependencyInjection;

import android.app.Activity;
import android.view.LayoutInflater;


import com.devahmed.demo.mvxwithdependencyinjection.model.Post;

import java.util.List;

import retrofit2.Call;

public class ControllerCompositionRoot {

    private CompositionRoot compositionRoot;
    private Activity activity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot , Activity activity) {
        this.compositionRoot = compositionRoot;
        this.activity = activity;
    }

    public Call<List<Post>> getPostsFromDatasource(){
        return compositionRoot.getDataFromDatasource();
    }

    private LayoutInflater getLayoutInfalter(){
        return LayoutInflater.from(activity);
    }

    public ViewMvcFactory getMvcFactory(){
        return new ViewMvcFactory(getLayoutInfalter());
    }
}
