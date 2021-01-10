package com.example.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyOrderActivity extends AppCompatActivity {

    ArrayList<Item> myOrder;
    RecyclerView rvMyOrder;
    MyOrderAdapter adapter;
    TextView tvTotal;

    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        myOrder = new MainActivity().orders;

        rvMyOrder = findViewById(R.id.rvMyOrder);
        tvTotal = findViewById(R.id.tvTotal);
        rvMyOrder.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MyOrderAdapter(this, myOrder);
        rvMyOrder.setAdapter(adapter);


        calculateTotal();
    }

    void calculateTotal(){
        for(int i =0; i < myOrder.size(); i++){
            total += myOrder.get(i).price*myOrder.get(i).quantity;
        }
        tvTotal.setText("Total: Rp "+total);
    }

    public void payNow(View view){
        if(new MainActivity().balance < total){
            Toast.makeText(this, "Your purchase is over your balance", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, OrderCompleteActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

            new MainActivity().balance -= total;

            ArrayList<Item> stock = new MainActivity().stocks;
            int id;
            for(int i =0; i < myOrder.size(); i++){
                id = myOrder.get(i).id;
                stock.get(id-1).quantity -= myOrder.get(i).quantity;

                Log.v("stock", stock.get(id-1).name + ", " + stock.get(id-1).quantity);
            }


        }

    }
}