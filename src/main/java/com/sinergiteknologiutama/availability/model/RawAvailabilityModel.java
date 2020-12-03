package com.sinergiteknologiutama.availability.model;

import java.sql.Timestamp;

public class RawAvailabilityModel {
    private int id;
    private String region_oid;
    private String site_oid;
    private int pack_id;
    private String serial_number;
    private String month_of_data;
    private String year_of_data;
    private int system_state;
    private Double avg_bus_current;
    private Double avg_bus_voltage;
    private Double best_power;
    private Double peak_power;
    private Double soc_start;
    private Double soc_end;
    private Double max_bus_currrent;
    private Double max_bus_voltage;
    private Double duration_hour;
    private Timestamp created_at;
    private Timestamp updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegion_oid() {
        return region_oid;
    }

    public void setRegion_oid(String region_oid) {
        this.region_oid = region_oid;
    }

    public String getSite_oid() {
        return site_oid;
    }

    public void setSite_oid(String site_oid) {
        this.site_oid = site_oid;
    }

    public int getPack_id() {
        return pack_id;
    }

    public void setPack_id(int pack_id) {
        this.pack_id = pack_id;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getMonth_of_data() {
        return month_of_data;
    }

    public void setMonth_of_data(String month_of_data) {
        this.month_of_data = month_of_data;
    }

    public String getYear_of_data() {
        return year_of_data;
    }

    public void setYear_of_data(String year_of_data) {
        this.year_of_data = year_of_data;
    }

    public int getSystem_state() {
        return system_state;
    }

    public void setSystem_state(int system_state) {
        this.system_state = system_state;
    }

    public Double getAvg_bus_current() {
        return avg_bus_current;
    }

    public void setAvg_bus_current(Double avg_bus_current) {
        this.avg_bus_current = avg_bus_current;
    }

    public Double getAvg_bus_voltage() {
        return avg_bus_voltage;
    }

    public void setAvg_bus_voltage(Double avg_bus_voltage) {
        this.avg_bus_voltage = avg_bus_voltage;
    }

    public Double getBest_power() {
        return best_power;
    }

    public void setBest_power(Double best_power) {
        this.best_power = best_power;
    }

    public Double getPeak_power() {
        return peak_power;
    }

    public void setPeak_power(Double peak_power) {
        this.peak_power = peak_power;
    }

    public Double getSoc_start() {
        return soc_start;
    }

    public void setSoc_start(Double soc_start) {
        this.soc_start = soc_start;
    }

    public Double getSoc_end() {
        return soc_end;
    }

    public void setSoc_end(Double soc_end) {
        this.soc_end = soc_end;
    }

    public Double getMax_bus_currrent() {
        return max_bus_currrent;
    }

    public void setMax_bus_currrent(Double max_bus_currrent) {
        this.max_bus_currrent = max_bus_currrent;
    }

    public Double getMax_bus_voltage() {
        return max_bus_voltage;
    }

    public void setMax_bus_voltage(Double max_bus_voltage) {
        this.max_bus_voltage = max_bus_voltage;
    }

    public Double getDuration_hour() {
        return duration_hour;
    }

    public void setDuration_hour(Double duration_hour) {
        this.duration_hour = duration_hour;
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
