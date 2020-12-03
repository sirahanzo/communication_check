package com.sinergiteknologiutama.availability.model;

public class ParameterModel {

    private int id;
    private Integer device_id;
    private String name;
    private String alias;
    private String group;
    private String unit;
    private Integer severity_id;
    private Integer notification_id;
    private Double minimum;
    private Double maximum;
    private Double scale;
    private Double state;
    private Double triggers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Integer device_id) {
        this.device_id = device_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getSeverity_id() {
        return severity_id;
    }

    public void setSeverity_id(Integer severity_id) {
        this.severity_id = severity_id;
    }

    public Integer getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(Integer notification_id) {
        this.notification_id = notification_id;
    }

    public Double getMinimum() {
        return minimum;
    }

    public void setMinimum(Double minimum) {
        this.minimum = minimum;
    }

    public Double getMaximum() {
        return maximum;
    }

    public void setMaximum(Double maximum) {
        this.maximum = maximum;
    }

    public Double getScale() {
        return scale;
    }

    public void setScale(Double scale) {
        this.scale = scale;
    }

    public Double getState() {
        return state;
    }

    public void setState(Double state) {
        this.state = state;
    }

    public Double getTriggers() {
        return triggers;
    }

    public void setTriggers(Double triggers) {
        this.triggers = triggers;
    }
}
