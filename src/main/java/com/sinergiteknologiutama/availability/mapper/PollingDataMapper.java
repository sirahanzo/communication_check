package com.sinergiteknologiutama.availability.mapper;

import com.sinergiteknologiutama.availability.model.PollingAlarmModel;
import com.sinergiteknologiutama.availability.model.PollingDataModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PollingDataMapper implements RowMapper<PollingDataModel> {

    @Override
    public PollingDataModel mapRow(ResultSet resultSet, int i) throws SQLException {

        PollingDataModel polling = new PollingDataModel();

        polling.setId(resultSet.getInt("id"));
        polling.setSite_oid(resultSet.getString("site_oid"));
        polling.setParameter_id(resultSet.getInt("parameter_id"));
        polling.setPack1(resultSet.getDouble("pack1"));
        polling.setPack2(resultSet.getDouble("pack2"));
        polling.setPack3(resultSet.getDouble("pack3"));
        polling.setPack4(resultSet.getDouble("pack4"));
        polling.setPack5(resultSet.getDouble("pack5"));
        polling.setPack6(resultSet.getDouble("pack6"));
        polling.setPack7(resultSet.getDouble("pack7"));
        polling.setPack8(resultSet.getDouble("pack8"));
        polling.setPack9(resultSet.getDouble("pack9"));
        polling.setPack10(resultSet.getDouble("pack10"));
        polling.setPack11(resultSet.getDouble("pack11"));
        polling.setPack12(resultSet.getDouble("pack12"));
        polling.setPack13(resultSet.getDouble("pack13"));
        polling.setPack14(resultSet.getDouble("pack14"));
        polling.setPack15(resultSet.getDouble("pack15"));

        return polling;
    }
}
