package com.exercise.udacity.a404_createanandroidlibraryexercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.exercise.udacity.androidjokelibrary.AndroidJokeActivity;
import com.exercise.udacity.jokes.JokeSmith;

public class MainActivity extends AppCompatActivity {

    public static final String JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void retrieveJoke(View view) {
        JokeSmith jokeSmith = new JokeSmith();
        String joke = jokeSmith.getJoke(false);

        Intent intent = new Intent(this, AndroidJokeActivity.class);
        intent.putExtra(JOKE, joke);

        startActivity(intent);
    }
}
