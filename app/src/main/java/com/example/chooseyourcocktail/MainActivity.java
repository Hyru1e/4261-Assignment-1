package com.example.chooseyourcocktail;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class MainActivity extends Activity {
    EditText ed1,ed2;
    Button btn_login, btn_createAccount, CreateButton;
    ImageView image_RCG;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //grab all button id's
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_createAccount = (Button) findViewById(R.id.btn_createAccount);
        CreateButton = (Button) findViewById(R.id.CreateButton);




        //grab all text id's
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);


        //Retrofit retrofit = new Retrofit.Builder()
        // .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/filter.php?i=Vodka").build();

        //Call<List> call = CockTailAPI.getPosts();


        //event listener for login button
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1.getText().toString().equals("admin") &&
                        ed2.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(v.getContext(), SearchActivity.class);
                    startActivityForResult(myIntent, 0);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();

                }
            }
        });
        // event listener for create account on login screen
        btn_createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), CreateNewUserActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });


    }
}
