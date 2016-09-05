package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.example.jokelib.JokeActivity;
import com.example.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Chaiy on 9/4/2016.
 */
public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {

    private final Context context;
    private ProgressBar progressBar;
    private static MyApi myApiService = null;
    private GetJokeTaskListener getJokeTaskListener;

    EndpointsAsyncTask(Context context) {
        this.context = context;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public GetJokeTaskListener getGetJokeTaskListener() {
        return getJokeTaskListener;
    }

    public void setGetJokeTaskListener(GetJokeTaskListener getJokeTaskListener) {
        this.getJokeTaskListener = getJokeTaskListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (progressBar != null)
            progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (getJokeTaskListener != null) {
            getJokeTaskListener.onComplete(result);
        }
        if (progressBar != null)
            progressBar.setVisibility(View.GONE);

        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_EXTRA, result);
        context.startActivity(intent);
        //Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }

    public static interface GetJokeTaskListener {
        public void onComplete(String joke);
    }
}