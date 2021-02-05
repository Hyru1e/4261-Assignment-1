package com.example.chooseyourcocktail;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class CocktailDataService {
    public static final String RANDOM_COCKTAIL_QUERY = "https://www.thecocktaildb.com/api/json/v1/1/random.php";
    Context context;

    public CocktailDataService(Context context) {
        this.context = context;
    }

    //interface to set up callbacks
    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(String cocktailName, String image);
    }

    public void getRandomDrinkName(VolleyResponseListener resLis) {
        String url = RANDOM_COCKTAIL_QUERY;


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String cocktailName = null;
                String image = null;
                try {
                    JSONArray cocktailObject = response.getJSONArray("drinks");
                    JSONObject cocktailInfo = cocktailObject.getJSONObject(0);
                    cocktailName = cocktailInfo.getString("strDrink");
                    image = cocktailInfo.getString("strDrinkThumb");
                } catch (JSONException e) {
                    e.printStackTrace();
                    resLis.onError("There's been an error");
                }


                resLis.onResponse(cocktailName, image);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();

            }
        });
        SingletonQueue.getInstance(context).addToRequestQueue(request);


    }

}