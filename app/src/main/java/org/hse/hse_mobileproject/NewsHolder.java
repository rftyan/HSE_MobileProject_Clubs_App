package org.hse.hse_mobileproject;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsHolder extends RecyclerView.ViewHolder {
    Context context;
    TextView title;
    TextView description;
    TextView category;
    TextView club;

    public NewsHolder(@NonNull View itemView, Context context, RecyclerViewInterface recyclerViewInterface) {
        super(itemView);
        this.context = context;
        title = itemView.findViewById(R.id.news_item_title);
        description = itemView.findViewById(R.id.news_item_description);
        category = itemView.findViewById(R.id.news_cat_description);
        club = itemView.findViewById(R.id.news_club_description);

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
    public void bind(final NewsItem data) {
        title.setText(data.getTitle());
        description.setText(data.getDescription());
        category.setText(data.getCategory());
        club.setText(data.getClub());
    }
}
