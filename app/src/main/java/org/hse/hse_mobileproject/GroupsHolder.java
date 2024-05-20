package org.hse.hse_mobileproject;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GroupsHolder extends RecyclerView.ViewHolder {
    Context context;
    TextView title;
    TextView description;
    TextView category;

    public GroupsHolder(@NonNull View itemView, Context context, RecyclerViewInterface recyclerViewInterface) {
        super(itemView);
        this.context = context;
        title = itemView.findViewById(R.id.groups_item_title);
        description = itemView.findViewById(R.id.groups_item_description);
        category = itemView.findViewById(R.id.groups_cat_description);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerViewInterface != null) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        recyclerViewInterface.onItemClick(pos);
                    }
                }
            }
        });
    }
    public void bind(final GroupsItem data) {
        title.setText(data.getTitle());
        description.setText(data.getDescription());
        category.setText(data.getCategory());
    }
}
