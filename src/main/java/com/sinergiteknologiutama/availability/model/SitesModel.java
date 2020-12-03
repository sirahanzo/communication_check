package com.sinergiteknologiutama.availability.model;

public class SitesModel {

    //private int id;
    private int owner_id;
    private String region_oid;
    private String city_oid;
    private String oid;
    private String name;
    private String site_id_label;
    private String address;
    private String longitude;
    private String latitude;
    private Integer total_pack ;
    private NodeModel node;
    private PollingDataModel pollingData;
    private PollingAlarmModel pollingAlarm;

    public PollingDataModel getPollingData() {
        return pollingData;
    }

    public void setPollingData(PollingDataModel pollingData) {
        this.pollingData = pollingData;
    }

    public PollingAlarmModel getPollingAlarm() {
        return pollingAlarm;
    }

    public void setPollingAlarm(PollingAlarmModel pollingAlarm) {
        this.pollingAlarm = pollingAlarm;
    }

    public NodeModel getNode() {
        return node;
    }

    public void setNode(NodeModel node) {
        this.node = node;
    }
/*public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getRegion_oid() {
        return region_oid;
    }

    public void setRegion_oid(String region_oid) {
        this.region_oid = region_oid;
    }

    public String getCity_oid() {
        return city_oid;
    }

    public void setCity_oid(String city_oid) {
        this.city_oid = city_oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSite_id_label() {
        return site_id_label;
    }

    public void setSite_id_label(String site_id_label) {
        this.site_id_label = site_id_label;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Integer getTotal_pack() {
        return total_pack;
    }

    public void setTotal_pack(Integer total_pack) {
        this.total_pack = total_pack;
    }
}
