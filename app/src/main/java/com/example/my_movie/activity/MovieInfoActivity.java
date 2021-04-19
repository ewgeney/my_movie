package com.example.my_movie.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my_movie.R;

public class MovieInfoActivity extends AppCompatActivity {

    TextView textView;
    String imdbId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);

        textView =  findViewById(R.id.imdbIdTextView);
        imdbId = getIntent().getExtras().get("imdbId").toString();
        textView.setText(imdbId);

    }
}