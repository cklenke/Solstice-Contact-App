package com.example.collin.contactstest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Collin on 2/26/2017.
 */
public class ContactAdapter extends BaseAdapter{

    private Context mContext;
    private List<Contacts> mContactList;

    public ContactAdapter(Context context, List<Contacts> list){
        mContext = context;
        mContactList = list;
    }
    @Override
    public int getCount() {
        return mContactList.size();
    }

    @Override
    public Object getItem(int position) {
        return mContactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contacts entry = mContactList.get(position);
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item, null);
        }
        ImageView photo = (ImageView) convertView.findViewById(R.id.contact_picture);
        photo.setImageBitmap(entry.getContact_photo());

        TextView name = (TextView) convertView.findViewById(R.id.contact_name);
        name.setText(entry.getContact_name());

        TextView phone = (TextView)convertView.findViewById(R.id.phone_number);
        phone.setText(entry.getContact_phone());

        TextView email = (TextView)convertView.findViewById(R.id.email);
        email.setText(entry.getContact_email());

        return convertView;
    }
}
