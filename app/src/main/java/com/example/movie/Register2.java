package com.example.movie;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register2 extends AppCompatActivity {
    Database db;
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        db = new Database(this);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        mTextCnfPassword = (EditText)findViewById(R.id.edittext_cnf_password);
        mButtonRegister = (Button)findViewById(R.id.button_register);
        mTextViewLogin = (TextView)findViewById(R.id.textview_login);

        //direct user to login page
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(Register2.this,Login.class);
                startActivity(LoginIntent);
            }
        });

        //enter users credentials to database on click
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String confirm_pwd = mTextCnfPassword.getText().toString().trim();

                //confirming both passwords match
                if(pwd.equals(confirm_pwd)){
                    long val = db.addUser(user,pwd);
                    if(val > 0){
                        Toast.makeText(Register2.this,"You have registered",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(Register2.this,Login.class);
                        startActivity(moveToLogin);
                    }

                    else{
                        Toast.makeText(Register2.this,"Registeration Error",Toast.LENGTH_SHORT).show();
                    }
                }

                //error if both passwords don't match
                else{
                    Toast.makeText(Register2.this,"Passwords do not match",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
