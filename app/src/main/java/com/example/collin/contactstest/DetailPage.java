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
        ImageView large_photo;
        final Button submit;




        final Contacts contact = (Contacts)getIntent().getSerializableExtra(MainActivity.SER_KEY);

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
        submit = (Button) findViewById(R.id.submit_button);


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

        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.edit_button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                name.setFocusableInTouchMode(true);
                company.setFocusableInTouchMode(true);
                work_phone.setFocusableInTouchMode(true);
                home_phone.setFocusableInTouchMode(true);
                mobile_phone.setFocusableInTouchMode(true);
                city.setFocusableInTouchMode(true);
                street.setFocusableInTouchMode(true);
                state.setFocusableInTouchMode(true);
                zip.setFocusableInTouchMode(true);
                email.setFocusableInTouchMode(true);

                submit.setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.submit_button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String in_name;
                String in_company;
                String in_work;
                String in_home;
                String in_mobile;
                String in_city;
                String in_street;
                String in_state;
                String in_zip;
                String in_email;

                //GATHER ENTERED INFO - PUT INTO CONTACT

                in_name = name.getText().toString();
                if(!in_name.equals("")){
                    Log.d("sumbitclicked", in_name);
                    contact.setContact_name(in_name);
                }
                in_company = company.getText().toString();
                if(!in_company.equals("")){
                    contact.setContact_company(in_company);
                }
                in_work = work_phone.getText().toString();
                if(!in_work.equals("")){
                    contact.setContact_work_phone(in_work);
                }
                in_home = home_phone.getText().toString();
                if(!in_home.equals("")){
                    contact.setContact_home_phone(in_home);
                }
                in_mobile = mobile_phone.getText().toString();
                if(!in_mobile.equals("")){
                    contact.setContact_mobile_phone(in_mobile);
                }
                in_city = city.getText().toString();
                if(!in_city.equals("")){
                    contact.setContact_city(in_city);
                }
                in_street = street.getText().toString();
                if(!in_street.equals("")){
                    contact.setContact_street_address(in_street);
                }
                in_state = state.getText().toString();
                if(!in_state.equals("")){
                    contact.setContact_state(in_state);
                }
                in_zip = zip.getText().toString();
                if(!in_zip.equals("")){
                    contact.setContact_zip(in_zip);
                }
                in_email = email.getText().toString();
                if(!in_email.equals("")){
                    contact.setContact_email(in_email);
                }
                //UPDATE THE LIST IN MAIN ACTIVITY
                MainActivity.updateList(contact);


                //MAKE THEM NOT EDITABLE AGAIN
                name.setFocusableInTouchMode(false);
                company.setFocusableInTouchMode(false);
                work_phone.setFocusableInTouchMode(false);
                home_phone.setFocusableInTouchMode(false);
                mobile_phone.setFocusableInTouchMode(false);
                city.setFocusableInTouchMode(false);
                street.setFocusableInTouchMode(false);
                state.setFocusableInTouchMode(false);
                zip.setFocusableInTouchMode(false);
                email.setFocusableInTouchMode(false);

                submit.setVisibility(View.INVISIBLE);
            }
        });
    }
}
