package com.example.my_movie.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.my_movie.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

    }

    public void startSearch(View v) {

        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getApplicationContext());
        View view = layoutInflaterAndroid.inflate(R.layout.search_layout, null);

        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(this);
        alertDialogBuilderUserInput.setView(view);

        final EditText searchEditText = view.findViewById(R.id.searchEditText);

        alertDialogBuilderUserInput.setCancelable(true).setPositiveButton("Искать",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id){
                    }
                });
        final AlertDialog alertDialog = alertDialogBuilderUserInput.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(searchEditText.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Так что ищем?", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    alertDialog.dismiss();
                }
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                String movieToSearch = searchEditText.getText().toString();
                intent.putExtra("movieToSearch", movieToSearch);
                startActivity(intent);
            }
        });
    }

}