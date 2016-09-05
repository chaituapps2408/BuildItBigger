package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {

    EndpointsAsyncTask endpointsAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void tellJoke(View view) {
        /*Joker joker = new Joker();
        joker.getJoke();
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_EXTRA, joker.getJoke());
        startActivity(intent);*/
        //Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
        endpointsAsyncTask = new EndpointsAsyncTask(this);
        endpointsAsyncTask.setProgressBar((ProgressBar) findViewById(R.id.progressBar1));
        endpointsAsyncTask.execute();
    }

}
