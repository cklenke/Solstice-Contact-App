package com.example.collin.contactstest.utilities;


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
}
