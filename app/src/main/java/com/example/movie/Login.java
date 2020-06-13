<<<<<<< HEAD
package com.example.movie;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
//import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;

    Button mButtonRegister;
    Database db;
//    ViewGroup progressView;
//    protected boolean isProgressShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Dialog dialog = new Dialog(this,android.R.style.Theme_Translucent_NoTitleBar);
//        View v = this.getLayoutInflater().inflate(R.layout.progressbar,null);
//        dialog.setContentView(v);
        dialog.show();

        db = new Database(this);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        mButtonLogin = (Button)findViewById(R.id.button_login);
        mButtonRegister = (Button) findViewById(R.id.button_register);

        //button to direct to registration page
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(Login.this,Register2.class);
                startActivity(registerIntent);
            }
        });

        //to login after entering username and password
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                Boolean res = db.checkUser(user, pwd);

                //check username and password to let sign in
                if(res == true)
                {
                    Intent Home = new Intent(Login.this,MainActivity.class);
                    startActivity(Home);
                }

                //if username or passwrod incorrect, error message
                else
                {
                    Toast.makeText(Login.this,"Login Error",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

//    public void showProgressingView() {
//
//        if (!isProgressShowing) {
//            View view=findViewById(R.id.progressBar1);
//            view.bringToFront();
//        }
//    }
//
//    public void hideProgressingView() {
//        View v = this.findViewById(android.R.id.content).getRootView();
//        ViewGroup viewGroup = (ViewGroup) v;
//        viewGroup.removeView(progressView);
//        isProgressShowing = false;
//    }
}

=======
package com.example.movie;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
//import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;

    Button mButtonRegister;
    Database db;
//    ViewGroup progressView;
//    protected boolean isProgressShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Dialog dialog = new Dialog(this,android.R.style.Theme_Translucent_NoTitleBar);
//        View v = this.getLayoutInflater().inflate(R.layout.progressbar,null);
//        dialog.setContentView(v);
        dialog.show();

        db = new Database(this);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        mButtonLogin = (Button)findViewById(R.id.button_login);
        mButtonRegister = (Button) findViewById(R.id.button_register);

        //button to direct to registration page
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(Login.this,Register2.class);
                startActivity(registerIntent);
            }
        });

        //to login after entering username and password
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                Boolean res = db.checkUser(user, pwd);

                //check username and password to let sign in
                if(res == true)
                {
                    Intent Home = new Intent(Login.this,MainActivity.class);
                    startActivity(Home);
                }

                //if username or passwrod incorrect, error message
                else
                {
                    Toast.makeText(Login.this,"Login Error",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

//    public void showProgressingView() {
//
//        if (!isProgressShowing) {
//            View view=findViewById(R.id.progressBar1);
//            view.bringToFront();
//        }
//    }
//
//    public void hideProgressingView() {
//        View v = this.findViewById(android.R.id.content).getRootView();
//        ViewGroup viewGroup = (ViewGroup) v;
//        viewGroup.removeView(progressView);
//        isProgressShowing = false;
//    }
}

>>>>>>> 4376d64bf485b42c5f8cf81c0f1c50a36a28a202
