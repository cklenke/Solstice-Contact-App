package com.example.collin.contactstest.utilities;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Collin on 3/1/2017.
 */
public class NetworkUtils {

    public static String getResponseFromHttpUrl() throws IOException {
        String url = "https://s3.amazonaws.com/technical-challenge/Contacts.json";
        HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();

        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if(hasInput) return scanner.next();
            else return null;

        } finally {
            urlConnection.disconnect();
        }
    }

    /*public static Bitmap getBitmap(String src){

    }

    public class FetchBitmapData extends AsyncTask<String, Void, String>{


        @Override
        protected String doInBackground(String... params) {
            if (params.length == 0) return null;
            String src = params[0];
            try {
                URL url_bm = new URL(src);
                HttpURLConnection connection = (HttpURLConnection) url_bm.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(input);
                return bitmap;
            }catch (IOException e){
                Log.d("bitmaptesting", src);
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }*/
}
