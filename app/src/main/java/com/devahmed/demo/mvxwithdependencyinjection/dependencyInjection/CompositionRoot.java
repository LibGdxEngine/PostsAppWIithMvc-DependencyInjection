package com.devahmed.demo.mvxwithdependencyinjection.dependencyInjection;

import com.devahmed.demo.mvxwithdependencyinjection.Networking.PostsClient;
import com.devahmed.demo.mvxwithdependencyinjection.model.Post;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class CompositionRoot {

    private List<Post> posts;

    public Call<List<Post>> getDataFromDatasource() {
        Call<List<Post>> posts = PostsClient.getInstance().getPosts();
        return posts;
    }

    private List<Post> getPostsList(){
        if(posts == null){
            posts = new ArrayList<>();
            for (int i = 0; i <10 ; i++) {
                posts.add(new Post(" Number " + i , i * 78 + ""));
            }
        }
        return posts;
    }
}