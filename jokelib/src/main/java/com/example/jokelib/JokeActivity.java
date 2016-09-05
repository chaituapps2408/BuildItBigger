package com.example.jokelib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public  static final String JOKE_EXTRA = "JOKE_EXTRA";
    TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        String joke = getIntent().getStringExtra(JOKE_EXTRA);

        jokeTextView = (TextView) findViewById(R.id.jokeTextView);
        jokeTextView.setText(joke);

    }
}
