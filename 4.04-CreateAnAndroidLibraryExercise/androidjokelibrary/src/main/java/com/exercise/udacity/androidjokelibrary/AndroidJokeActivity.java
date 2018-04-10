package com.exercise.udacity.androidjokelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AndroidJokeActivity extends AppCompatActivity {

    public static final String JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_joke);

        TextView tvJoke = findViewById(R.id.tv_joke);

        String joke = getIntent().getStringExtra(JOKE);
        tvJoke.setText(joke);
    }
}
