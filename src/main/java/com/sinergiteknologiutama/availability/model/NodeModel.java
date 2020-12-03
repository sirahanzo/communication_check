package com.sinergiteknologiutama.availability.model;

import java.util.ArrayList;
import java.util.List;

public class NodeModel {

    private int id;//not use
    private String site_oid; //not use if join with sites table
    private Integer device_id;
    //private String poller_ipaddress;
    private String name; // not
    private String serial_number;
    private String ipaddress;//not use
    private String protocol_monitoring;//not user
    private String status;
    private Integer device_node_id;
    private String node_name;
    List<SitesModel> sitesModelList = new ArrayList<SitesModel>();
    List<DevicesModel> devicesModelList = new ArrayList<DevicesModel>();
    private ParameterModel parameterModel ;
    private DevicesModel devicesModel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSite_oid() {
        return site_oid;
    }

    public void setSite_oid(String site_oid) {
        this.site_oid = site_oid;
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

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getProtocol_monitoring() {
        return protocol_monitoring;
    }

    public void setProtocol_monitoring(String protocol_monitoring) {
        this.protocol_monitoring = protocol_monitoring;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDevice_node_id() {
        return device_node_id;
    }

    public void setDevice_node_id(Integer device_node_id) {
        this.device_node_id = device_node_id;
    }

    public List<SitesModel> getSitesModelList() {
        return sitesModelList;
    }

    public void setSitesModelList(List<SitesModel> sitesModelList) {
        this.sitesModelList = sitesModelList;
    }

    public List<DevicesModel> getDevicesModelList() {
        return devicesModelList;
    }

    public void setDevicesModelList(List<DevicesModel> devicesModelList) {
        this.devicesModelList = devicesModelList;
    }

    public ParameterModel getParameterModel() {
        return parameterModel;
    }

    public void setParameterModel(ParameterModel parameterModel) {
        this.parameterModel = parameterModel;
    }

    public DevicesModel getDevicesModel() {
        return devicesModel;
    }

    public void setDevicesModel(DevicesModel devicesModel) {
        this.devicesModel = devicesModel;
    }

    public String getNode_name() {
        return node_name;
    }

    public void setNode_name(String node_name) {
        this.node_name = node_name;
    }
}
