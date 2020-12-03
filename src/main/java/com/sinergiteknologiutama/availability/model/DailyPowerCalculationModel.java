package com.sinergiteknologiutama.availability.model;

import java.sql.Timestamp;

public class DailyPowerCalculationModel {

    private int id;
    private String site_oid;
    private int pack_id;
    private Double vbus;
    private Double ibus;
    private Double power;
    private Double aggregate;
    private Timestamp created_at;
    private Timestamp updated_at;

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

    public int getPack_id() {
        return pack_id;
    }

    public void setPack_id(int pack_id) {
        this.pack_id = pack_id;
    }

    public Double getVbus() {
        return vbus;
    }

    public void setVbus(Double vbus) {
        this.vbus = vbus;
    }

    public Double getIbus() {
        return ibus;
    }

    public void setIbus(Double ibus) {
        this.ibus = ibus;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public Double getAggregate() {
        return aggregate;
    }

    public void setAggregate(Double aggregate) {
        this.aggregate = aggregate;
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
