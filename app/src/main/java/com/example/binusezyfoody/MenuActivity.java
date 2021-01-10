package com.example.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    ArrayList<Item> menus;

    RecyclerView rvMenu;
    MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        int menuType = intent.getIntExtra("menuType", 0);

        initMenu(menuType);

        rvMenu = findViewById(R.id.rvMenu);
        rvMenu.setLayoutManager(new GridLayoutManager(this, 2));

        adapter = new MenuAdapter(this, menus);
        rvMenu.setAdapter(adapter);
    }

    public void openMyOrderActivity(View view) {
        Intent intent = new Intent(this, MyOrderActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    void initMenu(int choice){


        switch(choice){
            case 0: // Drinks
                setTitle("Drinks");

                ArrayList<Item >drinks = new ArrayList<>();

                for(int i =1; i <=6; i++) {
                    drinks.add(new MainActivity().stocks.get(i-1));
                }

                menus = drinks;
                break;

            case 1: // Snacks
                setTitle("Snacks");

                ArrayList<Item >snacks = new ArrayList<>();

                for(int i =7; i <=12; i++) {
                    snacks.add(new MainActivity().stocks.get(i-1));
                }


                menus = snacks;
                break;

            case 2: // Foods
                setTitle("Foods");

                ArrayList<Item >foods = new ArrayList<>();

                for(int i =13; i <=18; i++) {
                    foods.add(new MainActivity().stocks.get(i-1));
                }


                menus = foods;
                break;
        }

    }


}