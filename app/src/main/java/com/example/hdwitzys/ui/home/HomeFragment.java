package com.example.hdwitzys.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.GravityCompat;


import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.hdwitzys.R;
import com.example.hdwitzys.databinding.FragmentHomeBinding;
import com.example.hdwitzys.ui.drinks.DrinksFragment;
import com.example.hdwitzys.ui.entrees.EntreesFragment;
import com.example.hdwitzys.ui.icecream.IceCreamFragment;
import com.example.hdwitzys.ui.checkout.CheckoutFragment;
import com.example.hdwitzys.ui.sides.SidesFragment;
import com.google.android.material.navigation.NavigationView;

public class HomeFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentHomeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // Set up NavigationView listener
        NavigationView navigationView = root.findViewById(R.id.nav_view); // Use the correct ID here
        navigationView.setNavigationItemSelectedListener(this);


        return root;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // No need to replace with HomeFragment since you are already in the HomeFragment
            // Add any specific behavior if needed
        } else if (id == R.id.nav_entrees) {
            replaceFragment(new EntreesFragment());
        } else if (id == R.id.nav_sides) {
            replaceFragment(new SidesFragment());
        } else if (id == R.id.nav_drinks) {
            replaceFragment(new DrinksFragment());
        } else if (id == R.id.nav_icecream) {
            replaceFragment(new IceCreamFragment());
        } else if (id == R.id.nav_checkout) {
            replaceFragment(new CheckoutFragment());
        }

        // Close the drawer
        DrawerLayout drawer = getActivity().findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
