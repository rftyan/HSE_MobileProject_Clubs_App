package org.hse.hse_mobileproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public final class NewsItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<NewsItem> newsList = new ArrayList<>();
    RecyclerViewInterface recyclerViewInterface;

    public NewsItemAdapter(RecyclerViewInterface recyclerViewInterface) {
        this.recyclerViewInterface = recyclerViewInterface;
    }

    public void setRecyclerViewInterface(RecyclerViewInterface recyclerViewInterface) {
        this.recyclerViewInterface = recyclerViewInterface;
    }

    public RecyclerViewInterface getRecyclerViewInterface() {
        return recyclerViewInterface;
    }

    public void setNewsList(List<NewsItem> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.news_item, parent, false);
        return new NewsHolder(contactView, context, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewsItem data = newsList.get(position);
        ((NewsHolder) holder).bind(data);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
