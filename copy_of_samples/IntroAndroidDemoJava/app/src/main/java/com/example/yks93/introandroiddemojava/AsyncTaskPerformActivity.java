package com.example.yks93.introandroiddemojava;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.Toast;


public class AsyncTaskPerformActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_perform);
        new MyAsyncTask().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_async_task_perform, menu);
        return true;
    }

    private void doneCounting() {
        Toast.makeText(this, "Done Counting to 1000000", Toast.LENGTH_SHORT).show();
    }

    private class MyAsyncTask extends AsyncTask<Void, Void, Void> {

        public Void doInBackground(Void... params) {
            for (long i=0; i < 1000000; ++i)
                System.out.println(i);

            return null;
        }

        protected void onPostExecuted(Void result) {
            doneCounting();
        }

    }

}
