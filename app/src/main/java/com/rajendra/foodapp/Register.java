package com.rajendra.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    EditText textInputEditTextFullname, textInputEditTextPhone, textInputEditTextPassword,textInputEditTextrePassword, textInputEditTextEmail;
    Button buttonSignUp;
    TextView textViewLogin;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        textInputEditTextFullname = findViewById(R.id.fullname);
        textInputEditTextPhone = findViewById(R.id.phone);
        textInputEditTextPassword = findViewById(R.id.password);
        textInputEditTextrePassword = findViewById(R.id.repassword);
        textInputEditTextEmail = findViewById(R.id.email);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        textViewLogin = findViewById(R.id.loginText);
        progressBar = findViewById(R.id.progress);


        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fullname,phone,password,repassword,email;
                fullname = textInputEditTextFullname.getText().toString();
                phone = textInputEditTextPhone.getText().toString();
                password = textInputEditTextPassword.getText().toString();
                repassword = textInputEditTextrePassword.getText().toString();
                email = String.valueOf(textInputEditTextEmail.getText());
                if (!repassword.equals(password)) {

                    Toast.makeText(com.rajendra.foodapp.Register.this, "Confirm Your Password!", Toast.LENGTH_SHORT).show();

                } else if (email.equals("")) {
                    textInputEditTextEmail.setError("Required email");
                } else if (fullname.equals("")) {
                    textInputEditTextFullname.setError("Required name");
                } else if (phone.equals("")) {
                    textInputEditTextPhone.setError("Required phone");
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    //registerUser(textInputEditTextFullname.getText().toString(), textInputEditTextEmail.getText().toString(), textInputEditTextPhone.getText().toString(),password);
                    Intent intent = new Intent(getApplicationContext(),Login.class);
                    startActivity(intent);
                    finish();
                }
            }

        });
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
   /* private void registerUser(final String email, final String name,  final String tel, final String password) {
        compositeDisposable.add(iNodeJS.registerUser(email, name, tel, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Toast.makeText(RegisterActivity.this, "" + s, Toast.LENGTH_SHORT).show();
                    }
                })
        );

    }
    */
}
