package org.hse.hse_mobileproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment implements RecyclerViewInterface {
    List<NewsItem> list;
    RecyclerView recyclerView;
    NewsItemAdapter newsItemAdapter;
    Button filterButton;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        filterButton = (Button) view.findViewById(R.id.filter_button);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonFilterClick();
            }
        });
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.newsContainer);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        newsItemAdapter = new NewsItemAdapter(this);
        recyclerView.setAdapter(newsItemAdapter);
        dataInitialize();
    }

    private void buttonFilterClick() {
        Intent intent = new Intent(getContext(), FilterActivity.class);
        startActivity(intent);
    }

    private void dataInitialize() {
        list = new ArrayList<>();
        NewsItem item = new NewsItem();
        item.setTitle("Placeholder");
        item.setDescription("Placeholder text placeholder text placeholder text placeholder text" +
                " placeholder text");
        item.setCategory("Placeholder Text");
        item.setClub("Placeholder Text");
        list.add(item);

        item = new NewsItem();
        item.setTitle("Placeholder");
        item.setDescription("Placeholder text placeholder text placeholder text placeholder text" +
                " placeholder text");
        item.setCategory("Placeholder Text");
        item.setClub("Placeholder Text");
        list.add(item);

        item = new NewsItem();
        item.setTitle("Placeholder");
        item.setDescription("Placeholder text placeholder text placeholder text placeholder text" +
                " placeholder text");
        item.setCategory("Placeholder Text");
        item.setClub("Placeholder Text");
        list.add(item);

        item = new NewsItem();
        item.setTitle("Placeholder");
        item.setDescription("Placeholder text placeholder text placeholder text placeholder text" +
                " placeholder text");
        item.setCategory("Placeholder Text");
        item.setClub("Placeholder Text");
        list.add(item);
        newsItemAdapter.setNewsList(list);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getContext(), NewsPageActivity.class);
        intent.putExtra(NewsPageActivity.NEWS_TITLE, list.get(position).getTitle());
        intent.putExtra(NewsPageActivity.NEWS_CATEGORY, list.get(position).getCategory());
        intent.putExtra(NewsPageActivity.NEWS_CLUB, list.get(position).getClub());
        startActivity(intent);
    }
}