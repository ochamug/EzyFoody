package com.example.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderCompleteActivity extends AppCompatActivity {

    ArrayList<Item> myOrder;
    RecyclerView rvMyOrder;
    OrderCompleteAdapter adapter;
    TextView tvTotal;

    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        myOrder = new MainActivity().orders;

        rvMyOrder = findViewById(R.id.rvMyOrder);
        tvTotal = findViewById(R.id.tvTotal);
        rvMyOrder.setLayoutManager(new LinearLayoutManager(this));

        adapter = new OrderCompleteAdapter(this, myOrder);
        rvMyOrder.setAdapter(adapter);

        calculateTotal();
    }

    void calculateTotal(){
        for(int i =0; i < myOrder.size(); i++){
            total += myOrder.get(i).price*myOrder.get(i).quantity;
        }
        tvTotal.setText("Total: Rp "+total);
    }


    public void toHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}