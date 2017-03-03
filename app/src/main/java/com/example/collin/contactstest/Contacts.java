package com.example.collin.contactstest;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Collin on 2/26/2017.
 */
public class Contacts implements Serializable {

    private String contact_name;
    private String contact_company;
    private Boolean contact_favorite;
    private Bitmap contact_photo_small;
    private Bitmap contact_photo_large;
    private String contact_email;
    private String contact_website;
    private String contact_work_phone;
    private String contact_home_phone;
    private String contact_mobile_phone;
    private String contact_street_address;
    private String contact_city;
    private String contact_state;
    private String contact_country;
    private String contact_zip;
    private String contact_small_url;
    private String contact_large_url;
    public int position;

    public String getContact_small_url() {
        return contact_small_url;
    }

    public void setContact_small_url(String contact_small_url) {
        this.contact_small_url = contact_small_url;
    }

    public String getContact_large_url() {
        return contact_large_url;
    }

    public void setContact_large_url(String contact_large_url) {
        this.contact_large_url = contact_large_url;
    }

    public Contacts() {

    }

    public String getContact_company() {
        return contact_company;
    }

    public void setContact_company(String contact_company) {
        this.contact_company = contact_company;
    }

    public Boolean getContact_favorite() {
        return contact_favorite;
    }

    public void setContact_favorite(Boolean contact_favorite) {
        this.contact_favorite = contact_favorite;
    }

    public Bitmap getContact_photo_large() {
        return contact_photo_large;
    }

    public void setContact_photo_large(Bitmap contact_photo_large) {
        this.contact_photo_large = contact_photo_large;
    }

    public String getContact_website() {
        return contact_website;
    }

    public void setContact_website(String contact_website) {
        this.contact_website = contact_website;
    }

    public String getContact_work_phone() {
        return contact_work_phone;
    }

    public void setContact_work_phone(String contact_work_phone) {
        this.contact_work_phone = contact_work_phone;
    }

    public String getContact_home_phone() {
        return contact_home_phone;
    }

    public void setContact_home_phone(String contact_home_phone) {
        this.contact_home_phone = contact_home_phone;
    }

    public String getContact_mobile_phone() {
        return contact_mobile_phone;
    }

    public void setContact_mobile_phone(String contact_mobile_phone) {
        this.contact_mobile_phone = contact_mobile_phone;
    }

    public String getContact_street_address() {
        return contact_street_address;
    }

    public void setContact_street_address(String contact_street_address) {
        this.contact_street_address = contact_street_address;
    }

    public String getContact_city() {
        return contact_city;
    }

    public void setContact_city(String contact_city) {
        this.contact_city = contact_city;
    }

    public String getContact_state() {
        return contact_state;
    }

    public void setContact_state(String contact_state) {
        this.contact_state = contact_state;
    }

    public String getContact_country() {
        return contact_country;
    }

    public void setContact_country(String contact_country) {
        this.contact_country = contact_country;
    }

    public String getContact_zip() {
        return contact_zip;
    }

    public void setContact_zip(String contact_zip) {
        this.contact_zip = contact_zip;
    }

    public Bitmap getContact_photo_small() {
        return contact_photo_small;
    }

    public void setContact_photo_small(Bitmap contact_photo_small) {
        this.contact_photo_small = contact_photo_small;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_phone() {
        return contact_work_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_work_phone = contact_phone;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }
}
