package com.sinergiteknologiutama.availability.model;

public class DevicesModel {

    private int id;
    private Integer manufacturer_id;
    private Integer device_type_id;
    private String name;
    private String api_key;
    private String api_label;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getManufacturer_id() {
        return manufacturer_id;
    }

    public void setManufacturer_id(Integer manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }

    public Integer getDevice_type_id() {
        return device_type_id;
    }

    public void setDevice_type_id(Integer device_type_id) {
        this.device_type_id = device_type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public String getApi_label() {
        return api_label;
    }

    public void setApi_label(String api_label) {
        this.api_label = api_label;
    }
}
