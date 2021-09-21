package com.rajendra.foodapp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText email,password;
    Button login;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.usernamee);
        password = findViewById(R.id.passwordd);
        login = findViewById(R.id.buttonLoginn);

       // iNodeJS = RetrofitClient.getInstance().create(INodeJS.class);

        //sharedPreferences
        sharedPreferences = getSharedPreferences("testt", Context.MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = email.getText().toString();
                String p = password.getText().toString();
                if (e.equals("")) {
                    email.setError("email is empty");
                }
                if (p.equals("")) {
                    password.setError("password is empty");
                    //Toast.makeText(LoginActivity.this, "Check Your Entries!", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("test", e);
                    editor.putString("test1", p);
                    editor.apply();
                    Intent i = new Intent(Login.this,MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }
   /* private void loginUser(final String email, String password) {
        compositeDisposable.add(iNodeJS.loginUser(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        if (s.contains("encrypted_password")) {
                            Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                            loadClientData();

                            Intent i = new Intent(LoginActivity.this, Accueil.class);
                            startActivity(i);
                        } else
                            Toast.makeText(LoginActivity.this, "" + s, Toast.LENGTH_SHORT).show(); //Show error from API
                    }
                })
        );
    }

    public void loadClientData() {
        sharedPreferences = getApplicationContext().getSharedPreferences("CurrentUser", Context.MODE_PRIVATE);
        String email2 = email.getText().toString();
        Call<User> call = iNodeJS.getUser(email2);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("idUser", user.getId());
                editor.putString("FirstNameUser", user.getName());
                editor.putString("EmailUser", user.getEmail());
                editor.putInt("PhoneUser", user.getPhone());
                editor.apply();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
            }
        });
    }

    */
}