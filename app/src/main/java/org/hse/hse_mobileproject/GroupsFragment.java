package org.hse.hse_mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GroupsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GroupsFragment extends Fragment implements RecyclerViewInterface {
    List<GroupsItem> list;
    RecyclerView recyclerView;
    GroupsItemAdapter groupsItemAdapter;
    Button filterButton;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GroupsFragment() {
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
    public static GroupsFragment newInstance(String param1, String param2) {
        GroupsFragment fragment = new GroupsFragment();
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
        return inflater.inflate(R.layout.fragment_group, container, false);

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
        recyclerView = view.findViewById(R.id.groupsContainer);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        groupsItemAdapter = new GroupsItemAdapter(this);
        recyclerView.setAdapter(groupsItemAdapter);
        dataInitialize();
    }

    private void buttonFilterClick() {
        Intent intent = new Intent(getContext(), FilterGroupsActivity.class);
        startActivity(intent);
    }

    private void dataInitialize() {
        list = new ArrayList<>();
        GroupsItem item = new GroupsItem();
        item.setTitle("Placeholder");
        item.setDescription("Placeholder text placeholder text placeholder text placeholder text" +
                " placeholder text");
        item.setCategory("Placeholder Text");
        list.add(item);

        item = new GroupsItem();
        item.setTitle("Placeholder");
        item.setDescription("Placeholder text placeholder text placeholder text placeholder text" +
                " placeholder text");
        item.setCategory("Placeholder Text");
        list.add(item);

        item = new GroupsItem();
        item.setTitle("Placeholder");
        item.setDescription("Placeholder text placeholder text placeholder text placeholder text" +
                " placeholder text");
        item.setCategory("Placeholder Text");
        list.add(item);

        item = new GroupsItem();
        item.setTitle("Placeholder");
        item.setDescription("Placeholder text placeholder text placeholder text placeholder text" +
                " placeholder text");
        item.setCategory("Placeholder Text");
        list.add(item);
        groupsItemAdapter.setGroupsList(list);
    }

    @Override
    public void onItemClick(int position) {
        // Создание нового Intent для перехода на страницу организации
        Intent intent = new Intent(getContext(), OrganizationPageActivity.class);

        // Передача информации о выбранной организации через Intent
        intent.putExtra(OrganizationPageActivity.ORGANIZATION_NAME, list.get(position).getOrganizationName());
        intent.putExtra(OrganizationPageActivity.ORGANIZATION_DESCRIPTION, list.get(position).getOrganizationDescription());
        // Дополнительные данные организации, которые могут быть нужны

        // Запуск активности организации
        startActivity(intent);
    }

}