package com.example.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Item> stocks;
    public static ArrayList<Item> orders;
    public static int balance = 200000;
    public static ArrayList<Order> history;


    TextView tvBalance;

    public MainActivity(){
        this.stocks = initStock();
//        Log.v("stock", new MainActivity().stocks.size() +"");

    }

    public ArrayList<Item> initStock(){
        ArrayList<Item> stocks = new ArrayList<Item>();

        stocks.add(new Item(1,"Air Mineral", 3000, R.drawable.air_mineral, 5));
        stocks.add(new Item(2,"Jus Apel", 15000, R.drawable.jus_apel, 7));
        stocks.add(new Item(3,"Jus Mangga", 15000, R.drawable.jus_mangga, 10));
        stocks.add(new Item(4,"Jus Jambu", 17000, R.drawable.jus_jambu, 20));
        stocks.add(new Item(5,"Jus Pisang", 20000,  R.drawable.jus_pisang, 10));
        stocks.add(new Item(6,"Jus Hijau", 12000, R.drawable.jus_hijau, 30));

        stocks.add(new Item(7,"Gerad Cookie", 6000, R.drawable.snack_cookie, 10));
        stocks.add(new Item(8,"Doritos", 6500, R.drawable.snack_doritos, 50));
        stocks.add(new Item(9,"Kitkat Sakura", 16000, R.drawable.snack_kitkat, 10));
        stocks.add(new Item(10,"Momogi Jangung Bakar", 7000, R.drawable.snack_momogi, 20));
        stocks.add(new Item(11,"Pocky", 8000,  R.drawable.snack_pocky, 30));
        stocks.add(new Item(12,"Pringles", 12000, R.drawable.snack_pringles, 60));

        stocks.add(new Item(13,"Ayam Geprek", 15000, R.drawable.food_ayam_geprek, 12));
        stocks.add(new Item(14,"Nasi Goreng", 11000, R.drawable.food_nasi_goreng, 13));
        stocks.add(new Item(15,"Sate Ayam", 18000, R.drawable.food_sate_ayam, 14));
        stocks.add(new Item(16,"Sate Padang", 20000, R.drawable.food_sate_padang, 12));
        stocks.add(new Item(17,"Soto Betawi", 20000,  R.drawable.food_soto_betawi, 17));
        stocks.add(new Item(18,"Soto Ayam", 19000, R.drawable.food_soto_ayam, 19));

        return stocks;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orders = new ArrayList<>();

        tvBalance = findViewById(R.id.tvBalance);
        tvBalance.setText("Balance : Rp. " + balance);
    }

    public void openDrinksActivity(View v){
        Intent intent = new Intent(this, MenuActivity.class);
        int menuType = Integer.parseInt(v.getTag().toString());
        intent.putExtra("menuType", menuType);
        startActivity(intent);
    }

    public void openTopUpActivity(View v){
        Intent intent = new Intent(this, TopUpActivity.class);
        startActivity(intent);
    }

    public void openMyOrderActivity(View view) {
        Intent intent = new Intent(this, TopUpActivity.class);
        startActivity(intent);
    }
}