package com.example.collin.contactstest;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Collin on 3/1/2017.
 */
public class DetailPage extends Activity {

    private String name;
    private String company;
    private String work_phone;
    private String home_phone;
    private String mobile_phone;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String email;
    private String largeImageURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_page);
        Contacts contact = (Contacts)getIntent().getSerializableExtra(MainActivity.SER_KEY);
    }
}
