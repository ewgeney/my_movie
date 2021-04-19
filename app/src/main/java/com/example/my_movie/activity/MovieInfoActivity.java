package com.example.my_movie.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.my_movie.R;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class MovieInfoActivity extends AppCompatActivity {

    private String imdbId;
    private TextView titleInfoTextView;
    private TextView ratingTextView;
    private TextView yearInfoTextView;
    private TextView countryTextView;
    private TextView genreTextView;
    private TextView directorTextView;
    private TextView actorsTextView;
    private TextView plotTextView;
    private ImageView posterBigSizeTextView;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);

        imdbId = getIntent().getExtras().get("imdbId").toString();
        titleInfoTextView =  findViewById(R.id.titleInfoTextView);
        ratingTextView = findViewById(R.id.imdbRatingTextView);
        yearInfoTextView = findViewById(R.id.yearInfoTextView);
        countryTextView = findViewById(R.id.countryInfoTextView);
        genreTextView = findViewById(R.id.genreTextView);
        directorTextView = findViewById(R.id.directorTextView);
        actorsTextView = findViewById(R.id.actorsTextView);
        plotTextView = findViewById(R.id.plotTextView);
        posterBigSizeTextView = findViewById(R.id.posterBigSizeImageView);
        requestQueue = Volley.newRequestQueue(this);

        getInfo(imdbId);

    }

    private void getInfo(String imdbId) {

        String urlWithApiKey = "http://www.omdbapi.com/?apikey=4bc7ef45&i=";
        String url = urlWithApiKey+imdbId;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String titleInfo = response.getString("Title");
                    String rating = response.getString("imdbRating");
                    String year = response.getString("Year");
                    String country = response.getString("Country");
                    String genre = response.getString("Genre");
                    String director = response.getString("Director");
                    String actors = response.getString("Actors");
                    String plot = response.getString("Plot");
                    String posterBigSizeUrl = response.getString("Poster");

                    titleInfoTextView.setText(titleInfo);
                    ratingTextView.setText(rating);
                    yearInfoTextView.setText(year);
                    countryTextView.setText(country);
                    genreTextView.setText(genre);
                    directorTextView.setText(director);
                    actorsTextView.setText(actors);
                    plotTextView.setText(plot);
                    Picasso.get().load(posterBigSizeUrl).into(posterBigSizeTextView);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}