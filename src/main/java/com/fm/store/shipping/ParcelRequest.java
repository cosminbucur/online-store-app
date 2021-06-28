package com.fm.store.shipping;

public class ParcelRequest {

    private double length;
    private double width;
    private double height;
    private String distance_unit = "cm";
    private double weight;
    private String mass_unit = "kg";
    private String metadata;

    public ParcelRequest() {
    }

    public ParcelRequest(double length,
                         double width,
                         double height,
                         double weight,
                         String metadata) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.metadata = metadata;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getDistance_unit() {
        return distance_unit;
    }

    public void setDistance_unit(String distance_unit) {
        this.distance_unit = distance_unit;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getMass_unit() {
        return mass_unit;
    }

    public void setMass_unit(String mass_unit) {
        this.mass_unit = mass_unit;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
}
