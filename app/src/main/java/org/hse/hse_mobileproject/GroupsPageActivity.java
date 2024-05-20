package org.hse.hse_mobileproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GroupsPageActivity extends AppCompatActivity {
    static final String GROUPS_TITLE = "groups_title";
    static final String GROUPS_CATEGORY = "groups_category";
    TextView groupsTitle;
    TextView groupsCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.groups_item_activity);
        String groupsTitleText = getIntent().getStringExtra(GROUPS_TITLE);
        String groupsCategoryText = getIntent().getStringExtra(GROUPS_CATEGORY);

        groupsTitle = findViewById(R.id.groups_page_title);
        groupsCategory = findViewById(R.id.groups_page_cat_content);

        groupsTitle.setText(groupsTitleText);
        groupsCategory.setText(groupsCategoryText);
    }
}
