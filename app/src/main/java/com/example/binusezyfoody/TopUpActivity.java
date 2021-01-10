package com.example.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TopUpActivity extends AppCompatActivity {

    EditText txtTopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        txtTopUp = findViewById(R.id.txtTopUp);
    }

    public void topUp(View v){

        if(txtTopUp.getText().toString().equals("")){
            Toast.makeText(this, "Top Up field must be filled", Toast.LENGTH_LONG).show();
            return;
        }
        try {
            if(Integer.parseInt(txtTopUp.getText().toString()) > 2000000){
                Toast.makeText(this, "Maximum balance Rp. 2.000.000", Toast.LENGTH_LONG).show();
                return;
            }
        } catch (Exception e) {
            Toast.makeText(this, "Number is too large or invalid", Toast.LENGTH_LONG).show();
            return;
        }



        int balance = Integer.parseInt(txtTopUp.getText().toString());
        new MainActivity().balance += balance;

        Toast.makeText(this, "TopUp has been put to your balance", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void openMyOrderActivity(View view) {
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }
}