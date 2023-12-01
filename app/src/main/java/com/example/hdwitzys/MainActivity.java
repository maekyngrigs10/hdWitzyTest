package com.example.hdwitzys;

import android.os.Bundle;
import android.view.MenuItem; // Add this import statement
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar; // Add this line

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar); // Add this line

        // Initialize your DrawerLayout and NavigationView
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        // Set up ActionBarDrawerToggle for handling drawer open/close events
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Set up NavigationView item click listener
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) { // Change the type here
                // Handle navigation item clicks here
                int itemId = item.getItemId();
                switch (itemId) {
                    case R.id.nav_home:
                        // Handle home item click
                        openHomeFragment();
                        break;
                    case R.id.nav_entrees:
                        // Handle entrees item click
                        openEntreesFragment();
                        break;
                    // Handle other menu items...
                    case R.id.nav_checkout:
                        // Handle checkout item click
                        openCheckoutFragment();
                        break;
                }

                // Close the drawer after handling the click
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    // Methods to open corresponding fragments based on navigation item clicks

    // ...
}
