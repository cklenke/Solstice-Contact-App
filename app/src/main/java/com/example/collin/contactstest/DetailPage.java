package com.example.collin.contactstest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Collin on 3/1/2017.
 */

public class DetailPage extends Activity {

    //private Button backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_page);
        final Context mContext;
        mContext = this;

        final EditText name;
        final EditText company;
        final EditText work_phone;
        final EditText home_phone;
        final EditText mobile_phone;
        final EditText street;
        final EditText city;
        final EditText state;
        final EditText zip;
        final EditText email;
        //private String largeImageURL;
        ImageView large_photo;
        //final EditText name_edit_text;
        //final EditText company_edit_text;




        Contacts contact = (Contacts)getIntent().getSerializableExtra(MainActivity.SER_KEY);

        Log.d("created", contact.getContact_city());

        name = (EditText) findViewById(R.id.c_name);
        company = (EditText) findViewById(R.id.c_company);
        work_phone = (EditText) findViewById(R.id.c_work_phone);
        home_phone = (EditText) findViewById(R.id.c_home_phone);
        mobile_phone = (EditText) findViewById(R.id.c_mobile_phone);
        street = (EditText) findViewById(R.id.c_street);
        city = (EditText) findViewById(R.id.c_city);
        state = (EditText) findViewById(R.id.c_state);
        zip = (EditText) findViewById(R.id.c_zip);
        email = (EditText) findViewById(R.id.c_email);
        large_photo = (ImageView) findViewById(R.id.contact_photo);
        //backbutton = (Button) findViewById(R.id.back_button);
        //name_edit_text = (EditText) findViewById(R.id.name_edit_text);
        //company_edit_text = (EditText) findViewById(R.id.company_edit_text);

        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.edit_button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                name.setInputType(InputType.TYPE_CLASS_TEXT);
                name.setFocusableInTouchMode(true);
                company.setInputType(InputType.TYPE_CLASS_TEXT);
                company.setFocusableInTouchMode(true);
                work_phone.setInputType(InputType.TYPE_CLASS_PHONE);
                work_phone.setFocusableInTouchMode(true);
                home_phone.setInputType(InputType.TYPE_CLASS_PHONE);
                home_phone.setFocusableInTouchMode(true);
                mobile_phone.setInputType(InputType.TYPE_CLASS_PHONE);
                mobile_phone.setFocusableInTouchMode(true);
                city.setInputType(InputType.TYPE_CLASS_TEXT);
                city.setFocusableInTouchMode(true);
                street.setInputType(InputType.TYPE_CLASS_TEXT);
                street.setFocusableInTouchMode(true);
                state.setInputType(InputType.TYPE_CLASS_TEXT);
                state.setFocusableInTouchMode(true);
                zip.setInputType(InputType.TYPE_CLASS_NUMBER);
                zip.setFocusableInTouchMode(true);
                email.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                email.setFocusableInTouchMode(true);
            }
        });


        name.setHint(contact.getContact_name());
        company.setHint(contact.getContact_company());
        work_phone.setHint(contact.getContact_phone());
        home_phone.setHint(contact.getContact_home_phone());
        mobile_phone.setHint(contact.getContact_mobile_phone());
        street.setHint(contact.getContact_street_address());
        String citystring = contact.getContact_city();
        citystring = citystring + ", ";
        city.setHint(citystring);
        String statestring = contact.getContact_state();
        statestring = statestring + ", ";
        state.setHint(statestring);
        zip.setHint(contact.getContact_zip());
        email.setHint(contact.getContact_email());

        Picasso.with(mContext).load(contact.getContact_large_url()).into(large_photo);



    }

    private void returnButton(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
