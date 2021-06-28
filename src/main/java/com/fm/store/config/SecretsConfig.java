package com.fm.store.config;

public class SecretsConfig {

    private Bulkgate bulkgate;
    private Mailtrap mailtrap;
    private Shippo shippo;
    private Stripe stripe;

    public Bulkgate getBulkgate() {
        return bulkgate;
    }

    public void setBulkgate(Bulkgate bulkgate) {
        this.bulkgate = bulkgate;
    }

    public Mailtrap getMailtrap() {
        return mailtrap;
    }

    public void setMailtrap(Mailtrap mailtrap) {
        this.mailtrap = mailtrap;
    }

    public Shippo getShippo() {
        return shippo;
    }

    public void setShippo(Shippo shippo) {
        this.shippo = shippo;
    }

    public Stripe getStripe() {
        return stripe;
    }

    public void setStripe(Stripe stripe) {
        this.stripe = stripe;
    }

    public static class Bulkgate {

        private String appId;
        private String appToken;

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
    }

    public static class Mailtrap {

        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class Shippo {

        private String apiToken;

        public String getApiToken() {
            return apiToken;
        }

        public void setApiToken(String apiToken) {
            this.apiToken = apiToken;
        }
    }

    public static class Stripe {

        private String apiToken;

        public String getApiToken() {
            return apiToken;
        }

        public void setApiToken(String apiToken) {
            this.apiToken = apiToken;
        }
    }
}
