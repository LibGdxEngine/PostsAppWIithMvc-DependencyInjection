package com.devahmed.demo.mvxwithdependencyinjection.screens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devahmed.demo.mvxwithdependencyinjection.R;
import com.devahmed.demo.mvxwithdependencyinjection.common.BaseObservableMvcView;
import com.devahmed.demo.mvxwithdependencyinjection.model.Post;

public class PostListItemViewMvcImp extends BaseObservableMvcView <RecyclerItemViewMvc.Listener>
        implements RecyclerItemViewMvc {

    private TextView textView;
    private Post post;
    public PostListItemViewMvcImp(LayoutInflater from, ViewGroup parent) {
        setRootView(from.inflate(R.layout.row , parent, false));
        textView = findViewById(R.id.textView);
        getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for ( Listener listener : getmListeners()){
                    listener.onItemClicked(post);
                }
            }
        });
    }

    @Override
    public void binData(Post post) {
        this.post = post;
        textView.setText(post.getTitle());
    }
}
