package com.example.hsai_project;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // navigation
        final NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        final DrawerLayout drawerLayout = (DrawerLayout) this.findViewById(R.id.drawer_layout);
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph())
                        .setDrawerLayout(drawerLayout)
                        .build();

        // hamburger menu
        final NavigationView navView = findViewById(R.id.list_nav);
        NavigationUI.setupWithNavController(navView, navController);

        // Bottom navigation
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        NavigationUI.setupWithNavController(bottomNav, navController);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.bottom_nav_explore:
                        navController.navigate(R.id.bottom_nav_explore);
                        break;
                    case R.id.bottom_nav_map:
                        navController.navigate(R.id.bottom_nav_map);
                        break;
                    case R.id.bottom_nav_shops:
                        navController.navigate(R.id.bottom_nav_shops);
                        break;
                    case R.id.bottom_nav_products:
                        navController.navigate(R.id.bottom_nav_products);
                        break;
                    case R.id.bottom_nav_hamburger:
                        drawerLayout.openDrawer(navView);
                        return false;
                }
                return true;
            }
        });
    }
}
