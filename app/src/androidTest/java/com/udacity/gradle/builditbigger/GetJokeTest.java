package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Chaiy on 9/4/2016.
 */
public class GetJokeTest extends ApplicationTestCase<Application> {

    String mJsonString = null;
    CountDownLatch signal = null;

    public GetJokeTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    public void testGetJokeTask() throws InterruptedException {

        EndpointsAsyncTask task = new EndpointsAsyncTask(getContext());
        task.setGetJokeTaskListener(new EndpointsAsyncTask.GetJokeTaskListener() {
            @Override
            public void onComplete(String jsonString) {
                mJsonString = jsonString;
                signal.countDown();
            }
        });
        task.execute();
        signal.await();
        assertFalse(TextUtils.isEmpty(mJsonString));
    }

    /*public void testVerifyJokeResponse() throws IOException {
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

        assertNotNull(myApiService.getJoke().execute().getData());
    }*/
}
