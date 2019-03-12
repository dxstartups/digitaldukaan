package com.digitalstartups.digitaldukaan.models;

import android.graphics.pdf.PdfDocument;

import com.google.gson.annotations.SerializedName;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;

public class Shop {

    public static final String FIELD_SHOPID = "_id";
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_ADDRESS = "address";
    public static final String FIELD_CONTACT_NUMBER = "contact_number";
    public static final String FIELD_TYPE = "type";
    public static final String FIELD_DESC = "description";
    public static final String FIELD_DOCS = "documents";
    public static final String FIELD_ACCOUNT_NUMBER = "account_number";
    public static final String FIELD_BSB = "bsb";


    @BsonId
    @SerializedName(FIELD_SHOPID)
    private String id;

    @BsonProperty(FIELD_EMAIL)
    @SerializedName(FIELD_EMAIL)
    private String email;

    @BsonProperty(FIELD_NAME)
    @SerializedName(FIELD_NAME)
    private String name;

    @BsonProperty(FIELD_ADDRESS)
    @SerializedName(FIELD_ADDRESS)
    private String address;

    @BsonProperty(FIELD_CONTACT_NUMBER)
    @SerializedName(FIELD_CONTACT_NUMBER)
    private String contactNumber;

    @BsonProperty(FIELD_TYPE)
    @SerializedName(FIELD_TYPE)
    private String type;

    @BsonProperty(FIELD_DESC)
    @SerializedName(FIELD_DESC)
    private String description;

    @BsonProperty(FIELD_DOCS)
    @SerializedName(FIELD_DOCS)
    private List<PdfDocument> documents;

    @BsonProperty(FIELD_ACCOUNT_NUMBER)
    @SerializedName(FIELD_ACCOUNT_NUMBER)
    private String accountNumber;

    @BsonProperty(FIELD_BSB)
    @SerializedName(FIELD_BSB)
    private String bsb;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PdfDocument> getDocument() {
        return documents;
    }

    public void setDocument(List<PdfDocument> documents) {
        this.documents = documents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBsb() {
        return bsb;
    }

    public void setBsb(String bsb) {
        this.bsb = bsb;
    }
}
