package com.example.chooseyourcocktail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateNewUserActivity extends Activity {
    Button create;
    EditText firstName, lastName, username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        create = (Button)findViewById(R.id.CreateButton);
        firstName = (EditText)findViewById(R.id.firstName);
        lastName = (EditText)findViewById(R.id.lastName);
        username = (EditText)findViewById(R.id.userName);
        password = (EditText)findViewById(R.id.password);


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), SearchActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}
