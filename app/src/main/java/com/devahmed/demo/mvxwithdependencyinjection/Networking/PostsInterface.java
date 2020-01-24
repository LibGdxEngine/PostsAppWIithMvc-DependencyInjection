package com.devahmed.demo.mvxwithdependencyinjection.Networking;

import com.devahmed.demo.mvxwithdependencyinjection.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostsInterface {


    @GET("posts")
    Call<List<Post>> getPosts();


}
