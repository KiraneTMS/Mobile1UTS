package com.example.mobile1_arsya_uts;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mobile1_arsya_uts.databinding.ActivityMainBinding;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String foods[], drinks[], foodsPrice[], drinksPrice[], harga;
    int foodImages[] = {
            R.drawable.image_honeygarlic,
            R.drawable.image_beefburger,
            R.drawable.image_regularfries};
    int drinkImages[] = {
            R.drawable.image_icecreamcone,
            R.drawable.image_flurryoreo,
            R.drawable.image_fantafloat};

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addListData();

        FoodAdapter foodAdapter = new FoodAdapter(this, foods, foodsPrice, foodImages);
        binding.listFood.setAdapter(foodAdapter);
        binding.listFood.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        FoodAdapter drinkAdapter = new FoodAdapter(this, drinks, drinksPrice, drinkImages);
        binding.listDrink.setAdapter(drinkAdapter);
        binding.listDrink.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }


    public void addListData(){
        // Add Food List
        foods = getResources().getStringArray(R.array.foods);
        foodsPrice = getResources().getStringArray(R.array.foods_price);
        // Add Drink List
        drinks = getResources().getStringArray(R.array.drinks);
        drinksPrice = getResources().getStringArray(R.array.drinks_price);

    }




}