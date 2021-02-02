package com.example.chooseyourcocktail;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class SearchActivity extends Activity {

    Button search;
    EditText alcohol, mixer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search = (Button)findViewById(R.id.searchButton);
        alcohol = (EditText)findViewById(R.id.alcohol);
        mixer = (EditText)findViewById(R.id.mixer);
    }
}
