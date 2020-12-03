package com.sinergiteknologiutama.availability.mapper;

import com.sinergiteknologiutama.availability.model.DailyPowerCalculationModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DailyPowerCalculationMapper implements RowMapper<DailyPowerCalculationModel> {
    @Override
    public DailyPowerCalculationModel mapRow(ResultSet resultSet, int i) throws SQLException {

        DailyPowerCalculationModel daily = new DailyPowerCalculationModel();

        daily.setId(resultSet.getInt("id"));
        daily.setSite_oid(resultSet.getString("site_oid"));
        daily.setPack_id(resultSet.getInt("pack_id"));
        daily.setVbus(resultSet.getDouble("vbus"));
        daily.setIbus(resultSet.getDouble("ibus"));
        daily.setPower(resultSet.getDouble("power"));
        daily.setCreated_at(resultSet.getTimestamp("created_at"));
        daily.setUpdated_at(resultSet.getTimestamp("updated_at"));
        daily.setAggregate(resultSet.getDouble("aggregate"));

        return daily;
    }
}
