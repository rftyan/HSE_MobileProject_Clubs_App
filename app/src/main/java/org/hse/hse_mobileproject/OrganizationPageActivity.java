package org.hse.hse_mobileproject;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class OrganizationPageActivity extends AppCompatActivity {

    // Константы для передачи данных организации через Intent
    public static final String ORGANIZATION_NAME = "organization_name";
    public static final String ORGANIZATION_DESCRIPTION = "organization_description";
    private ImageView profileImage;
    private TextView username;
    private TextView userHandle;
    private TextView website;
    private Button followButton;
    private Button messageButton;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_page);

        // Initialize UI elements
        profileImage = findViewById(R.id.profile_image);
        username = findViewById(R.id.username);
        userHandle = findViewById(R.id.user_handle);
        website = findViewById(R.id.website);
        followButton = findViewById(R.id.follow_button);
        messageButton = findViewById(R.id.message_button);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        // Setup TabLayout and ViewPager
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        // Button click handling
        followButton.setOnClickListener(v -> {
            // Logic for Follow button
        });

        messageButton.setOnClickListener(v -> {
            // Logic for Message button
        });

        // Additional setup for UI elements, e.g., load user profile
        // profileImage.setImageResource(R.drawable.some_image);
        // username.setText("Some Username");
        // userHandle.setText("@someuserhandle");
        // website.setText("www.somewebsite.com");
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new VacanciesFragment(), "Вакансии");
        adapter.addFragment(new EventsFragment(), "Мероприятия");
        adapter.addFragment(new NewsGroupFragment(), "Новости");
        viewPager.setAdapter(adapter);
    }
}

