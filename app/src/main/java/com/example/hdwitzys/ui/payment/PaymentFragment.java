package com.example.hdwitzys.ui.payment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation; // Import the Navigation class
import com.example.hdwitzys.R;
import com.example.hdwitzys.ui.OrderItemAdapter;
import com.example.hdwitzys.ui.SharedOrderViewModel;

public class PaymentFragment extends Fragment {

    private SharedOrderViewModel viewModel;
    private TextView totalCostTextView;
    private ListView checkoutListView;
    private OrderItemAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment, container, false);

        // Set up a click listener for the "Continue To Payment" button

        return view;
    }
}
