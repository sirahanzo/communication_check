package com.sinergiteknologiutama.availability.mapper;

import com.sinergiteknologiutama.availability.model.CommunicationDataModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommunicationDataMapper implements RowMapper<CommunicationDataModel> {

    @Override
    public CommunicationDataModel mapRow(ResultSet resultSet, int i) throws SQLException {

        CommunicationDataModel communication = new CommunicationDataModel();

        communication.setId(resultSet.getInt("id"));
        communication.setDevice_node_id(resultSet.getInt("device_node_id"));
        communication.setMonitoring_status(resultSet.getInt("monitoring_status"));
        communication.setAlarm_status(resultSet.getInt("alarm_status"));
        communication.setCreated_at(resultSet.getTimestamp("created_at"));
        communication.setUpdated_at(resultSet.getTimestamp("updated_at"));

        return communication;
    }
}
