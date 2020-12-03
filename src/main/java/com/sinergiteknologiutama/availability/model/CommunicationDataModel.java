package com.sinergiteknologiutama.availability.model;


import java.sql.Timestamp;

public class CommunicationDataModel {

    private int id;
    private int device_node_id;
    private int monitoring_status;
    private int alarm_status;
    private Timestamp created_at;
    private Timestamp updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDevice_node_id() {
        return device_node_id;
    }

    public void setDevice_node_id(int device_node_id) {
        this.device_node_id = device_node_id;
    }

    public int getMonitoring_status() {
        return monitoring_status;
    }

    public void setMonitoring_status(int monitoring_status) {
        this.monitoring_status = monitoring_status;
    }

    public int getAlarm_status() {
        return alarm_status;
    }

    public void setAlarm_status(int alarm_status) {
        this.alarm_status = alarm_status;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }


}
