package com.example.collin.contactstest;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView mContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContacts = (ListView)findViewById(R.id.contact_list);
        List<Contacts> listContact = new ArrayList<Contacts>();
        listContact.add(new Contacts(BitmapFactory.decodeResource(getResources(), R.drawable.contact_picture), "Collin Klenke", "(281) 844 4490", "cklenke@nd.edu"));
        listContact.add(new Contacts(BitmapFactory.decodeResource(getResources(), R.drawable.contact_picture), "Scott Williams", "(281) 855 4490", "swilli@nd.edu"));
        listContact.add(new Contacts(BitmapFactory.decodeResource(getResources(), R.drawable.contact_picture), "Obama", "(911) 911 4490", "obeezey@nd.edu"));


        ContactAdapter adapter = new ContactAdapter(this, listContact);
        mContacts.setAdapter(adapter);

    }
}
