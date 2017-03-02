package com.example.collin.contactstest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Collin on 2/26/2017.
 */
public class ContactAdapter extends BaseAdapter{

    private Context mContext;
    private List<Contacts> mContactList;
    ViewHolder v;

    static class ViewHolder {
        private ImageView mImage;
        private TextView mEmail;
        private TextView mName;
        private TextView mPhone;
    }

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
            //LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, null);

            /*v = new ViewHolder();
            v.mName = (TextView) convertView.findViewById(R.id.contact_name);
            v.mPhone = (TextView)convertView.findViewById(R.id.phone_number);
            v.mEmail = (TextView)convertView.findViewById(R.id.email);
            v.mImage = (ImageView) convertView.findViewById(R.id.contact_picture);
*/
            //convertView.setTag(v);
        } else {
           // v = (ViewHolder) convertView.getTag();

        }

        TextView name = (TextView) convertView.findViewById(R.id.contact_name);
        name.setText(entry.getContact_name());

        TextView email = (TextView) convertView.findViewById(R.id.email);
        email.setText(entry.getContact_email());

        TextView phone = (TextView) convertView.findViewById(R.id.phone_number);
        phone.setText(entry.getContact_phone());

        ImageView photo = (ImageView) convertView.findViewById(R.id.contact_picture);
        //photo.setImageBitmap(entry.getContact_photo_small());
        Picasso.with(mContext).load(entry.getContact_small_url()).into(photo);
        //v.mName.setText(entry.getContact_name());
        //v.mPhone.setText(entry.getContact_phone());
        //v.mEmail.setText(entry.getContact_email());
        //v.mImage.setImageResource(R.drawable.contact_picture);
       // Bitmap bm = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.contact_picture);
       // v.mImage.setImageBitmap(bm);

        return convertView;
    }
}
