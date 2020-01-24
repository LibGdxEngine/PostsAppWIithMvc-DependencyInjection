package com.devahmed.demo.mvxwithdependencyinjection.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.devahmed.demo.mvxwithdependencyinjection.R;
import com.devahmed.demo.mvxwithdependencyinjection.dependencyInjection.BaseActivity;
import com.devahmed.demo.mvxwithdependencyinjection.model.Post;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class MainActivity extends BaseActivity implements MainScreenMvc.Listener {

    MainScreenMvcImp mvcImp;
    List<Post> mPostsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvcImp = getCompositionRoot().getMvcFactory().getPostsRecyclerViewMvcImp(null);
        mvcImp.registerListener(this);

        mPostsList = new ArrayList<>();

        Call<List<Post>> postsFromDatasource = getCompositionRoot().getPostsFromDatasource();
        postsFromDatasource.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                mPostsList = response.body();

                mvcImp.bindDate(mPostsList);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });


        setContentView(mvcImp.getRootView());
    }

    @Override
    public void onCLick(Post post) {
        Toast.makeText(this, "" +  post.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
