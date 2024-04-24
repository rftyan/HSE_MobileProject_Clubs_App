package org.hse.hse_mobileproject;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.nio.Buffer;

public class AppMainActivity extends AppCompatActivity implements RecyclerViewInterface {
    private BottomNavigationView bottomNavigationView;
    private ConstraintLayout constraintLayout;
    private MaterialToolbar materialToolbar;
    private void loadFragment(Fragment fragment, boolean isAppInicialized) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (isAppInicialized) {
            fragmentTransaction.add(R.id.contentContainer, fragment);
        } else {
            fragmentTransaction.replace(R.id.contentContainer, fragment);
        }
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_main_activity);

        bottomNavigationView = findViewById(R.id.bottomNavView);
        constraintLayout = findViewById(R.id.contentContainer);
        materialToolbar = findViewById(R.id.actionBar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navNews) {
                    loadFragment(new NewsFragment(), false);
                    materialToolbar.setTitle(R.string.news_title);
                } else if (itemId == R.id.navGroups) {
                    loadFragment(new GroupFragment(), false);
                    materialToolbar.setTitle(R.string.organizations_title);
                } else if (itemId == R.id.navProfile) {
                    loadFragment(new ProfileFragment(), false);
                    materialToolbar.setTitle(R.string.profile_title);
                } else {
                    loadFragment(new SettingsFragment(), false);
                    materialToolbar.setTitle(R.string.settings_title);
                }
                return true;
            }
        });
        loadFragment(new NewsFragment(), true);
    }

    @Override
    public void onItemClick(int position) {

    }
}
