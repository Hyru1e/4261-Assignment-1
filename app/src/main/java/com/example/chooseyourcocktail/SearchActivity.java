package com.example.chooseyourcocktail;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class SearchActivity extends Activity {
    ImageView image_RCG;
    Button btn_RCG;
    TextView text_randomName;
    CocktailDataService cocktaildataservice = new CocktailDataService(SearchActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        image_RCG = (ImageView)findViewById(R.id.image_RCG);

        btn_RCG = (Button) findViewById(R.id.btn_RCG);

        text_randomName = (TextView) findViewById(R.id.text_randomName);

        btn_RCG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cocktaildataservice.getRandomDrinkName(new CocktailDataService.VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(SearchActivity.this, "Somethings Wrongs", Toast.LENGTH_SHORT).show();


                    }

                    @Override
                    public void onResponse(String cocktailName, String image) {
                        Toast.makeText(SearchActivity.this, cocktailName, Toast.LENGTH_SHORT).show();
                        String url = image;
                        Glide.with(SearchActivity.this).load(url).into(image_RCG);
                        text_randomName.setText("Try the " + cocktailName);
                    }
                });


            }
        });


    }




}
