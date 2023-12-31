package com.example.hdwitzys.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class SharedOrderViewModel extends ViewModel {
    private final MutableLiveData<Double> totalCost = new MutableLiveData<>(0.0);
    private MutableLiveData<List<OrderItem>> orderItems = new MutableLiveData<>(new ArrayList<>());

    public void addToTotal(double itemCost) {
        if (totalCost.getValue() != null) {
            totalCost.setValue(totalCost.getValue() + itemCost);
        }
    }

    public void subtractFromTotal(double itemCost) {
        if (totalCost.getValue() != null) {
            totalCost.setValue(totalCost.getValue() - itemCost);
        }
    }

    public void addOrderItem(String itemName, double price) {
        OrderItem item = new OrderItem(itemName, price);
        List<OrderItem> currentItems = orderItems.getValue();
        if (currentItems != null) {
            currentItems.add(item);
            orderItems.setValue(currentItems);
            addToTotal(price);
        }
    }

    public MutableLiveData<Double> getTotalCost() {
        return totalCost;
    }

    public MutableLiveData<List<OrderItem>> getOrderItems() {
        return orderItems;
    }

    public void resetOrder() {
        totalCost.setValue(0.0);
        orderItems.setValue(new ArrayList<>());
    }

    // Class representing an item in the order
    public static class OrderItem {
        private String itemName;
        private double price;

        public OrderItem(String itemName, double price) {
            this.itemName = itemName;
            this.price = price;
        }

        // Getter methods
        public String getItemName() {
            return itemName;
        }

        public double getPrice() {
            return price;
        }
    }
}
