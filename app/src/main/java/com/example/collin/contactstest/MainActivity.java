package com.example.collin.contactstest;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.collin.contactstest.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView mContacts;
    List<Contacts> listContact = new ArrayList<Contacts>();
    public final static String SER_KEY = "com.example.collin.contactstest.ser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContacts = (ListView)findViewById(R.id.contact_list);


        new FetchNetworkData().execute();

        ContactAdapter adapter = new ContactAdapter(this, listContact);
        mContacts.setAdapter(adapter);

        mContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailPage.class);
                Bundle bundle = new Bundle();
                Contacts contact = (Contacts) parent.getItemAtPosition(position);
                bundle.putSerializable(SER_KEY, contact);
                intent.putExtras(bundle);
            }
        });
    }

    public class FetchNetworkData extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            String responseString = null;
            try {
                responseString = NetworkUtils.getResponseFromHttpUrl();
                Log.d("JSONRET", responseString);
            } catch (Exception e){
                Log.d("JSONRET", "shoot");
                e.printStackTrace();
            }
            return responseString;

        }

        @Override
        protected void onPostExecute(String responseData){
            Contacts[] contacts = processJSON(responseData);

            for(Contacts contact: contacts){
                listContact.add(contact);
            }
        }

        public Contacts[] processJSON(String responseData){
            Contacts[] contacts = new Contacts[25];

            try{
                JSONArray contactArray = new JSONArray(responseData);

                for(int i=0; i<contactArray.length(); i++){
                    contacts[i] = new Contacts();
                    JSONObject child = contactArray.getJSONObject(i);
                    contacts[i].setContact_name(child.getString("name"));
                    //Log.d("TESTER", "name return: " + child.getString("name"));
                    contacts[i].setContact_company(child.getString("company"));
                    //contacts[i].setContact_favorite(child.getBoolean("favorite"));
                    //contacts[i].setContact_photo_small();
                    //contacts[i].setContact_photo_large();
                    contacts[i].setContact_email(child.getString("email"));
                    contacts[i].setContact_website(child.getString("website"));

                    JSONObject phonenums = child.getJSONObject("phone");
                    contacts[i].setContact_work_phone(phonenums.getString("work"));
                    contacts[i].setContact_home_phone(phonenums.getString("home"));
                    if(phonenums.has("mobile")){
                        contacts[i].setContact_mobile_phone(phonenums.getString("mobile"));
                    } else {
                        contacts[i].setContact_mobile_phone(null);
                    }


                    JSONObject address = child.getJSONObject("address");
                    contacts[i].setContact_street_address(address.getString("street"));
                    contacts[i].setContact_city(address.getString("city"));
                    contacts[i].setContact_state(address.getString("state"));
                    contacts[i].setContact_country(address.getString("country"));
                    contacts[i].setContact_zip(address.getString("zip"));
                }


            }catch (Exception e){
                Log.d("TESTER", "shoot v 2.0");
                e.printStackTrace();
            }

            return contacts;
        }
    }
}
