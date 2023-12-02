package com.example.hdwitzys;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

import com.example.hdwitzys.ui.checkout.CheckoutFragment;
import com.example.hdwitzys.ui.drinks.DrinksFragment;
import com.example.hdwitzys.ui.entrees.EntreesFragment;
import com.example.hdwitzys.ui.home.HomeFragment;
import com.example.hdwitzys.ui.icecream.IceCreamFragment;
import com.example.hdwitzys.ui.sides.SidesFragment;
import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
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
            public boolean onNavigationItemSelected(MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.nav_home) {
                    openHomeFragment();
                } else if (itemId == R.id.nav_entrees) {
                    openEntreesFragment();
                } else if (itemId == R.id.nav_sides) {
                    openSidesFragment();
                } else if (itemId == R.id.nav_drinks) {
                    openDrinksFragment();
                } else if (itemId == R.id.nav_icecream) {
                    openIceCreamFragment();
                } else if (itemId == R.id.nav_checkout) {
                    openCheckoutFragment();
                }

                // Close the drawer after handling the click
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }

        });
    }

    private void openHomeFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, new HomeFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }
    private void openEntreesFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, new EntreesFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }
    private void openSidesFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, new SidesFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }
    private void openDrinksFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, new DrinksFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }
    private void openIceCreamFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, new IceCreamFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }
    private void openCheckoutFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, new CheckoutFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
