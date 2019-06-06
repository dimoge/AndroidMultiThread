package com.example.androidmultithreading;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler();

    Handler handler2 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //super.handleMessage(msg);
            switch (msg.what) {
                case 1:

                    break;
                case 2:

                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //TODO: 将要在主线程中执行...
                        Toast.makeText(MainActivity.this, "1111111111", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //TODO: 将要在主线程中执行...
                        Toast.makeText(MainActivity.this, "2222222222", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        thread.start();


        getSupportLoaderManager().initLoader(0, null, new LoaderManager.LoaderCallbacks<Object>() {
            @NonNull
            @Override
            public Loader<Object> onCreateLoader(int i, @Nullable Bundle bundle) {
                return null;
            }

            @Override
            public void onLoadFinished(@NonNull Loader<Object> loader, Object o) {

            }

            @Override
            public void onLoaderReset(@NonNull Loader<Object> loader) {

            }
        });


    }

    public class MyAsyncTask extends AsyncTask<String, Integer, Void>{

        @Override
        protected Void doInBackground(String... voids) {
            publishProgress(1);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {

        }
    };
}
