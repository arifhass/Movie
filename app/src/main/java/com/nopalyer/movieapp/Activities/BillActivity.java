package com.nopalyer.movieapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nopalyer.movieapp.R;

public class BillActivity extends AppCompatActivity {
    int received;
    TextView Ammount;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        received=getIntent().getIntExtra("numberOfSeats",0);//receiving number of seats booked
        Ammount=findViewById(R.id.ammount);
        Ammount.setText(""+received*20);//Calculating bills
        next=findViewById(R.id.button_proceed);
        //Button to go to next screen
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(BillActivity.this,Payment.class);
                startActivity(i);
            }
        });
    }
}