package com.fm.store.notification.sms;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmsRequest {

    @JsonProperty("application_id")
    private String appId;
    @JsonProperty("application_token")
    private String appToken;
    private String number;
    private String text;
    private String country;

    public SmsRequest() {
    }

    public SmsRequest(String appId, String appToken, String number, String text) {
        this.appId = appId;
        this.appToken = appToken;
        this.number = number;
        this.text = text;
        this.country = "ro";
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppToken() {
        return appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
