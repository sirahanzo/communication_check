package com.sinergiteknologiutama.availability.mapper;

import com.sinergiteknologiutama.availability.model.RawAvailabilityModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RawAvailabilityMapper implements RowMapper<RawAvailabilityModel> {
    @Override
    public RawAvailabilityModel mapRow(ResultSet resultSet, int i) throws SQLException {

        RawAvailabilityModel raw_data = new RawAvailabilityModel();

        raw_data.setId(resultSet.getInt("id"));
        raw_data.setRegion_oid(resultSet.getString("region_oid"));
        raw_data.setSite_oid(resultSet.getString("site_oid"));
        raw_data.setPack_id(resultSet.getByte("pack_id"));
        raw_data.setSerial_number(resultSet.getString("serial_number"));
        raw_data.setMonth_of_data(resultSet.getString("month_of_data"));
        raw_data.setYear_of_data(resultSet.getString("year_of_data"));
        raw_data.setSystem_state(resultSet.getInt("system_state"));
        raw_data.setAvg_bus_current(resultSet.getDouble("avg_bus_current"));
        raw_data.setAvg_bus_voltage(resultSet.getDouble("avg_bus_voltage"));
        raw_data.setBest_power(resultSet.getDouble("best_power"));
        raw_data.setPeak_power(resultSet.getDouble("peak_power"));
        raw_data.setSoc_start(resultSet.getDouble("soc_start"));
        raw_data.setSoc_end(resultSet.getDouble("soc_end"));
        raw_data.setMax_bus_currrent(resultSet.getDouble("max_bus_current"));
        raw_data.setMax_bus_voltage(resultSet.getDouble("max_bus_voltage"));
        raw_data.setDuration_hour(resultSet.getDouble("duration_hour"));
        raw_data.setCreated_at(resultSet.getTimestamp("created_at"));
        raw_data.setUpdated_at(resultSet.getTimestamp("updated_at"));

        return raw_data;
    }
}
