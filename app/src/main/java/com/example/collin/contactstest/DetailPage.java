package com.example.collin.contactstest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Collin on 3/1/2017.
 */

public class DetailPage extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_page);
        Context mContext;
        mContext = this;

        TextView name;
        TextView company;
        TextView work_phone;
        TextView home_phone;
        TextView mobile_phone;
        TextView street;
        TextView city;
        TextView state;
        TextView zip;
        TextView email;
        //private String largeImageURL;
        ImageView large_photo;




        Contacts contact = (Contacts)getIntent().getSerializableExtra(MainActivity.SER_KEY);

        Log.d("created", contact.getContact_city());

        name = (TextView) findViewById(R.id.c_name);
        company = (TextView) findViewById(R.id.c_company);
        work_phone = (TextView) findViewById(R.id.c_work_phone);
        home_phone = (TextView) findViewById(R.id.c_home_phone);
        mobile_phone = (TextView) findViewById(R.id.c_mobile_phone);
        street = (TextView) findViewById(R.id.c_street);
        city = (TextView) findViewById(R.id.c_city);
        state = (TextView) findViewById(R.id.c_state);
        zip = (TextView) findViewById(R.id.c_zip);
        email = (TextView) findViewById(R.id.email);
        large_photo = (ImageView) findViewById(R.id.contact_photo);

        name.setText(contact.getContact_name());
        company.setText(contact.getContact_company());
        work_phone.setText(contact.getContact_phone());
        home_phone.setText(contact.getContact_home_phone());
        mobile_phone.setText(contact.getContact_mobile_phone());
        street.setText(contact.getContact_street_address());
        String citystring = contact.getContact_city();
        citystring = citystring + ", ";
        city.setText(citystring);
        String statestring = contact.getContact_state();
        statestring = statestring + ", ";
        state.setText(statestring);
        zip.setText(contact.getContact_zip());
        email.setText(contact.getContact_email());

        Picasso.with(mContext).load(contact.getContact_large_url()).into(large_photo);



    }

    private void returnButton(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
