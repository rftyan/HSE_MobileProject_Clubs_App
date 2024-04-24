package org.hse.hse_mobileproject;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewsPageActivity extends AppCompatActivity {
    static final String NEWS_TITLE = "news_title";
    static final String NEWS_CATEGORY = "news_category";
    static final String NEWS_CLUB = "news_club";
    TextView newsTitle;
    TextView newsCategory;
    TextView newsClub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_item_activity);
        String newsTitleText = getIntent().getStringExtra(NEWS_TITLE);
        String newsCategoryText = getIntent().getStringExtra(NEWS_CATEGORY);
        String newsClubText = getIntent().getStringExtra(NEWS_CLUB);

        newsTitle = findViewById(R.id.news_page_title);
        newsCategory = findViewById(R.id.news_page_cat_content);
        newsClub = findViewById(R.id.news_page_club_content);

        newsTitle.setText(newsTitleText);
        newsCategory.setText(newsCategoryText);
        newsClub.setText(newsClubText);
    }
}
