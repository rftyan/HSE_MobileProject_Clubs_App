package org.hse.hse_mobileproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public final class GroupsItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<GroupsItem> groupsList = new ArrayList<>();
    RecyclerViewInterface recyclerViewInterface;

    public GroupsItemAdapter(RecyclerViewInterface recyclerViewInterface) {
        this.recyclerViewInterface = recyclerViewInterface;
    }

    public void setRecyclerViewInterface(RecyclerViewInterface recyclerViewInterface) {
        this.recyclerViewInterface = recyclerViewInterface;
    }

    public RecyclerViewInterface getRecyclerViewInterface() {
        return recyclerViewInterface;
    }

    public void setGroupsList(List<GroupsItem> groupsList) {
        this.groupsList = groupsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.groups_item, parent, false);
        return new GroupsHolder(contactView, context, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GroupsItem data = groupsList.get(position);
        ((GroupsHolder) holder).bind(data);
    }

    @Override
    public int getItemCount() {
        return groupsList.size();
    }
}
