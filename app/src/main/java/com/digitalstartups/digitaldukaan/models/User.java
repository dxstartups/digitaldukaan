package com.digitalstartups.digitaldukaan.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class User {

    public static final String FIELD_FIRSTNAME  = "first_name";
    public static final String FIELD_LASTNAME = "last_name";
    public static final String FIELD_EMAIL = "_id";
    public static final String FIELD_CONTACT = "contact_number";
    public static final String FIELD_LICENSE = "license_no";
    public static final String FIELD_ADDRESS = "address";
    public static final String FIELD_PASSWORD = "password";


    @BsonId
    private String id; // email address

    @BsonProperty(FIELD_FIRSTNAME)
    private String firstName;

    @BsonProperty(FIELD_LASTNAME)
    private String lastName;

    @BsonProperty(FIELD_CONTACT)
    private String contactNumber;

    @BsonProperty(FIELD_LICENSE)
    private String licenseNumber;

    @BsonProperty(FIELD_ADDRESS)
    private String address;

    @BsonProperty(FIELD_PASSWORD)
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
