package com.example.collin.contactstest;

import android.content.Intent;
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
    private static List<Contacts> listContact = new ArrayList<Contacts>();
    public final static String SER_KEY = "com.example.collin.contactstest.ser";
    ContactAdapter adapter = new ContactAdapter(this, listContact);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContacts = (ListView)findViewById(R.id.contact_list);

        new FetchNetworkData().execute();                                       //call network to gather JSON info

        mContacts.setAdapter(adapter);                                          //set up the adapter with the list of contacts created by parsing JSON

        mContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {      //allow each element in ListView to be clickable - unique to each element
                Log.d("Click", "clicked row: " + position);
                Intent intent = new Intent(MainActivity.this, DetailPage.class);
                Bundle bundle = new Bundle();
                Contacts contact = (Contacts) parent.getItemAtPosition(position);   //get the contact object in the row clicked by the user
                Log.d("ClickedPerson", contact.getContact_name());                  //check the return on getItemAtPosition
                bundle.putSerializable(SER_KEY, contact);                           //serialize the contacts object to send to the detail page activity
                intent.putExtras(bundle);                                           //add the bundle with the contact object to the intent
                startActivity(intent);                                              //launch details page
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        adapter.notifyDataSetChanged();                                             //update the contacts listview by telling the adapter to refresh
    }

    public static void updateList(Contacts contact){                                //this function allows the list of contacts to be updated in the detial activity
        listContact.set(contact.position, contact);
    }

    public class FetchNetworkData extends AsyncTask<String, Void, String> {         //this class is used to gather JSON info in background

        @Override
        protected String doInBackground(String... params) {

            String responseString = null;
            try {
                responseString = NetworkUtils.getResponseFromHttpUrl();
                //Log.d("JSONRET", responseString);
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
                listContact.add(contact);                                       //iterate through the contacts list returned and add it to the contacts list used by the listview adapter
            }
        }

        public Contacts[] processJSON(String responseData){
            Contacts[] contacts = new Contacts[25];                             //initialized an array of Contacts. 25 here but it should be larger if you expect the JSON to have a lot of information
            int p = 0;

            try{
                JSONArray contactArray = new JSONArray(responseData);


                for(int i=0; i<contactArray.length(); i++){
                    p++;
                    contacts[i] = new Contacts();
                    JSONObject child = contactArray.getJSONObject(i);
                    contacts[i].setContact_name(child.getString("name"));
                    contacts[i].setContact_company(child.getString("company"));

                    contacts[i].setContact_small_url(child.getString("smallImageURL"));
                    contacts[i].setContact_large_url(child.getString("largeImageURL"));

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
                    contacts[i].position = i;
                }


            }catch (Exception e){
                Log.d("TESTER", "shoot v 2.0");
                e.printStackTrace();
            }
            Contacts[] cont = new Contacts[p];                                  //List view works much better if you have the exact number of contacts as the size of your contacts array
            for(int i=0; i<p; i++){                                             // to solve this, create a new array of the right size once you know what it is and copy the contents of the
                cont[i] = new Contacts();                                       //  original unfilled array to an array of the perfect size (p)
            }
            System.arraycopy(contacts, 0, cont, 0, p);                          //copied here

            return cont;
        }
    }
}
