package com.rajendra.foodapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;


public class Update_profile extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    EditText name1, lname1, email1, phone1;
    Button update;
    LottieAnimationView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        v = findViewById(R.id.animm);
        email1 = findViewById(R.id.emailll);
        name1 = findViewById(R.id.nameee);
        lname1 = findViewById(R.id.lnameee);
        update = findViewById(R.id.btn_updt);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog();
            }

        });

    }

    void showDialog() {

        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.alert_dialog, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setView(view)
                .create();

        alertDialog.show();

        Button acceptButton = view.findViewById(R.id.acceptButton);
        Button cancelButton = view.findViewById(R.id.cancelButton);

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteUser();

            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.cancel();
            }
        });

    }

    private void deleteUser() {
        sharedPreferences = getApplicationContext().getSharedPreferences("CurrentUser", Context.MODE_PRIVATE);
        int idu = sharedPreferences.getInt("idUser", 0);
       /* Call<User> call = iNodeJS.DeleteUser(idu);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(com.example.xbree.Utils.Update_profile.this, "YYEEESSS", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(com.example.xbree.Utils.Update_profile.this, LoginActivity.class);
                startActivity(i);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(com.example.xbree.Utils.Update_profile.this, "Deleted Succefully", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(com.example.xbree.Utils.Update_profile.this, LoginActivity.class);
                startActivity(i);
            }
        });*/
    }

    /*public void loadClientData() {
        sharedPreferences = getApplicationContext().getSharedPreferences("CurrentUser", Context.MODE_PRIVATE);
        String idus = sharedPreferences.getString("EmailUser", "");
        Call<User> call = iNodeJS.getUser(idus);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                System.out.println(user.getId() + "teeesssssssssssssssssst");

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("idUser", user.getId());
                editor.putInt("telUser", user.getPhone());
                editor.putString("nomUser", user.getName());
                editor.putString("EmailUser", user.getEmail());
                editor.putString("pass", user.getPassword());
                editor.apply();

                idd = sharedPreferences.getInt("idUser", 0);
                String email = sharedPreferences.getString("EmailUser", "");
                String name = sharedPreferences.getString("nomUser", "");
                String lastname = sharedPreferences.getString("prenomUser", "");
                int phone = sharedPreferences.getInt("telUser", 0);
                String password = sharedPreferences.getString("pass", "");
                System.out.println(name + lastname);
                email1.setText(email);
                name1.setText(name);
                lname1.setText(lastname);
                phone1.setText(String.valueOf(phone));

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
            }
        });
    }*/
}