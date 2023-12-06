package com.example.hdwitzys.ui.entrees;// Add these imports at the top of your file
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.hdwitzys.R; // Make sure this is the correct package name for your R class

import java.util.ArrayList;

public class EntreesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_entrees, container, false);

        // Assuming you have a list of entrees, customize based on your data structure
        ArrayList<String> entreesList = getEntreesList();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, entreesList);

        ListView listView = view.findViewById(R.id.entreesListView); // Make sure this ID matches the one in your XML
        listView.setAdapter(adapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String selectedEntree = entreesList.get(position);
//                // Start the EntreesViewsActivity with the selected entree
//                NavHostFragment.findNavController(EntreesFragment.this)
//                        .navigate(EntreesFragmentDirections.actionEntreesFragmentToEntreesViewsActivity(selectedEntree));
//            }
//        });

        return view;
    }

    // Replace this with your actual method to get entrees data
    private ArrayList<String> getEntreesList() {
        ArrayList<String> entreesList = new ArrayList<>();
//        Populate the list with entrees
      entreesList.add("Cheeseburger");
        entreesList.add("Grigburger");
        // Add more entrees as needed
        return entreesList;
    }
}
