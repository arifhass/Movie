
package com.nopalyer.movieapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.nopalyer.movieapp.R;

import java.util.ArrayList;
import java.util.Calendar;

public class Payment extends AppCompatActivity {
    Spinner spinMonth,spinYear,spinCard;
    Button btn;
    EditText cardNumber,phoneNumber,cardName;
    String checkCardNumber,checkPhoneNumber,checkCardName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        spinMonth=findViewById(R.id.spinner_card_month);
        spinYear=findViewById(R.id.spinner_card_year);
        spinCard=findViewById(R.id.spinner_Card_Type);
        cardName=findViewById(R.id.card_number);
        cardNumber=findViewById(R.id.card_number);
        phoneNumber=findViewById(R.id.phone_number);

        btn=findViewById(R.id.button_done);
        populateSpinners();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkCardName = cardName.getText().toString();
                checkCardNumber=cardNumber.getText().toString();
                checkPhoneNumber=phoneNumber.getText().toString();
                if (checkCardNumber.matches("")) {
                    Toast.makeText(Payment.this, "You did not enter CardNumber", Toast.LENGTH_SHORT).show();
                }
                else if (checkCardName.matches("")) {
                    Toast.makeText(Payment.this, "You did not enter Name", Toast.LENGTH_SHORT).show();
                }
                else if (checkPhoneNumber.matches("")) {
                    Toast.makeText(Payment.this, "You did not enter phoneNumber", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(Payment.this, FinalActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    void populateSpinners(){
        ArrayList<String> months = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            months.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapterMonth = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, months);
        spinMonth.setAdapter(adapterMonth);


        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = thisYear; i <= thisYear+10; i++) {
            years.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapterYear = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, years);
        spinYear.setAdapter(adapterYear);
        //list of cards set in spinner
        ArrayList<String> cards=new ArrayList<String>();
        cards.add("Debit Card");
        cards.add("Visa Card");
        cards.add("Master Card");
        ArrayAdapter<String> adapterCard=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,cards);
        spinCard.setAdapter(adapterCard);
    }
}