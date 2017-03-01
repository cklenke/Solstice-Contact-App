package com.example.collin.contactstest;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.BitSet;

/**
 * Created by Collin on 2/26/2017.
 */
public class Contacts implements Serializable {
    private Bitmap contact_photo;
    private String contact_name;
    private String contact_phone;
    private String contact_email;

    public Contacts(Bitmap photo, String name, String phone, String email){
        this.contact_photo = photo;
        this.contact_name = name;
        this.contact_phone = phone;
        this.contact_email = email;
    }

    public Bitmap getContact_photo() {
        return contact_photo;
    }

    public void setContact_photo(Bitmap contact_photo) {
        this.contact_photo = contact_photo;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }
}
