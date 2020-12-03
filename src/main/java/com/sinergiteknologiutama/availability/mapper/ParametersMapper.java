package com.sinergiteknologiutama.availability.mapper;

import com.sinergiteknologiutama.availability.model.ParameterModel;
import com.sinergiteknologiutama.availability.model.ParametersModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParametersMapper implements RowMapper<ParametersModel> {
    @Override
    public ParametersModel mapRow(ResultSet resultSet, int i) throws SQLException {

        ParametersModel params = new ParametersModel();

        params.setId(resultSet.getInt("id"));
        params.setDevice_id(resultSet.getInt("device_id"));
        params.setName(resultSet.getString("name"));

        return params;
    }
}
