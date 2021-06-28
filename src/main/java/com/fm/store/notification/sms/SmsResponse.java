package com.fm.store.notification.sms;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmsResponse {

    private Data data;

    public SmsResponse(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    static class Data {

        private String status;
        @JsonProperty("sms_id")
        private String smsId;
        private Double price;
        private Double credit;
        private String number;

        public Data(String status, String smsId, Double price, Double credit, String number) {
            this.status = status;
            this.smsId = smsId;
            this.price = price;
            this.credit = credit;
            this.number = number;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSmsId() {
            return smsId;
        }

        public void setSmsId(String smsId) {
            this.smsId = smsId;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Double getCredit() {
            return credit;
        }

        public void setCredit(Double credit) {
            this.credit = credit;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }
}
