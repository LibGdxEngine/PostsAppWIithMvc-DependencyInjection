package com.devahmed.demo.mvxwithdependencyinjection.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.devahmed.demo.mvxwithdependencyinjection.model.Post;
import com.devahmed.demo.mvxwithdependencyinjection.screens.PostListItemViewMvcImp;
import com.devahmed.demo.mvxwithdependencyinjection.screens.RecyclerItemViewMvc;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> implements RecyclerItemViewMvc.Listener {

    private OnItemClickListener mListener;


    public interface OnItemClickListener {
        void OnItemClicked(Post post);
    }

    private List<Post> PostsList;

    public PostsAdapter(List<Post> PostsList, OnItemClickListener listener) {
        this.PostsList = PostsList;
        this.mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PostListItemViewMvcImp mvcImp = new PostListItemViewMvcImp(LayoutInflater.from(parent.getContext()), parent);
        mvcImp.registerListener(this);
        return new ViewHolder(mvcImp);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post model = PostsList.get(position);
        holder.recyclerViewListItemMvcImp.binData(model);
    }

    @Override
    public int getItemCount() {
        return PostsList.size();
    }

    public void setList(List<Post> newList) {
        PostsList = newList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final PostListItemViewMvcImp recyclerViewListItemMvcImp;

        public ViewHolder(PostListItemViewMvcImp viewMvcImp) {
            super(viewMvcImp.getRootView());
            recyclerViewListItemMvcImp = viewMvcImp;
        }
    }


    @Override
    public void onItemClicked(Post model) {
        mListener.OnItemClicked(model);
    }

}