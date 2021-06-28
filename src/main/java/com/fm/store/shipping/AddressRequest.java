package com.fm.store.shipping;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressRequest {

    private String name;
    private String company;
    private String street1;
    @JsonProperty("street_no")
    private String streetNo;
    private String street2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String phone;
    private String email;
    private String metadata;

    public AddressRequest() {
    }

    public AddressRequest(String name,
                          String company,
                          String street1,
                          String streetNo,
                          String street2,
                          String city,
                          String state,
                          String zip,
                          String country,
                          String phone,
                          String email,
                          String metadata) {
        this.name = name;
        this.company = company;
        this.street1 = street1;
        this.streetNo = streetNo;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.metadata = metadata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
}
