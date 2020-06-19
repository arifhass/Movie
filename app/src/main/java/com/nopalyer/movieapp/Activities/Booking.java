package com.nopalyer.movieapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.nopalyer.movieapp.R;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Booking extends AppCompatActivity {
Button btn1,btn2,btn3;
Spinner spinMonth,spinDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        btn1=(Button)findViewById(R.id.btnSelectTime1);
        btn2=(Button)findViewById(R.id.btnSelectTime2);
        btn3=(Button)findViewById(R.id.btnSelectTime3);
        spinDay=findViewById(R.id.spinner_day);

        populateDateSpinner();// Initializing Spinners
        //2pm Button
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Booking.this,SeatSelectionActivity.class);
                startActivity(intent);
            }
        });
        //5pm Button
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Booking.this,SeatSelectionActivity.class);
                startActivity(intent);
            }
        });
        //8pm Button
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Booking.this,SeatSelectionActivity.class);
                startActivity(intent);
            }
        });

    }

    ArrayList populatemonthLength(ArrayList l,int year){

        //storing month lengths
        l.add(31);
        if(year%4==0)
            l.add(29);
        else
            l.add(28);
        l.add(31);
        l.add(30);
        l.add(31);
        l.add(30);
        l.add(31);
        l.add(31);
        l.add(30);
        l.add(31);
        l.add(30);
        l.add(31);
        return  l;
    }
    void populateDateSpinner(){
        //Populating Date Spinner
        Calendar calendar;
        SimpleDateFormat dateFormat;
        String date;
        ArrayList<String> days = new ArrayList<String>();
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = dateFormat.format(calendar.getTime());

        int d=Integer.valueOf(date.substring(0,2));
        int  m=Integer.valueOf(date.substring(3,5));
        int  y=Integer.valueOf(date.
                substring(6));
        ArrayList <Integer>monthLength=new ArrayList();
        monthLength=populatemonthLength(monthLength,y);
        System.out.println("day = " + d+" month = "+m+" year = "+y);
        for (int i=0;i<7;i++){
            //Validation for correct dates
            if (d%(monthLength.get(m))==0) {
                d = 1;
                if (m % 12 == 0) {
                    y++;
                    m = 1;
                } else
                    m++;
            }
            else
                d++;
            date=(Integer.toString(d)+"/"+Integer.toString(m)+"/"+Integer.toString(y));
            days.add(date);
            }
        //Adapter to display 7 dates
        ArrayAdapter<String> adapterDay = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days);
        spinDay.setAdapter(adapterDay);
    }
}

