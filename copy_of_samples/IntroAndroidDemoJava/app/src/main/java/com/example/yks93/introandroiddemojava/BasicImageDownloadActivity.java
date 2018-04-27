package com.example.yks93.introandroiddemojava;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class BasicImageDownloadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_image_download);
        StrictMode.setThreadPolicy(
                new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        try {
            downloadImageFromUri("http://2.gravatar.com/avatar/858dfac47ab8176458c005414d3f0c36?s=128&d=&r=G");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void downloadImageFromUri(String address) throws IOException {
        URL url;

        try {
            url = new URL(address);
        } catch (MalformedURLException e) {
            url = null;
        }

        URLConnection conn;
        InputStream in = null;
        Bitmap bitmap = null;

        try {
            conn = url.openConnection();
            conn.connect();
            in = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(in);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                in.close();
        }

        if (bitmap != null) {
            ImageView img = (ImageView) findViewById(R.id.ivBasicImage);
            img.setImageBitmap(bitmap);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_basic_image_download, menu);
        return true;
    }

}
