package com.sinergiteknologiutama.availability.mapper;

import com.sinergiteknologiutama.availability.model.SerialNumberPackModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SerialNumberPackMapper implements RowMapper<SerialNumberPackModel> {
    @Override
    public SerialNumberPackModel mapRow(ResultSet resultSet, int i) throws SQLException {
        SerialNumberPackModel site = new SerialNumberPackModel();

        /*site.setId(resultSet.getInt("id"));
        site.setDevice_node_id(resultSet.getInt("device_node_id"));
        site.setSn1(resultSet.getString("sn1"));
        site.setSn2(resultSet.getString("sn2"));
        site.setSn3(resultSet.getString("sn3"));
        site.setSn4(resultSet.getString("sn4"));
        site.setSn5(resultSet.getString("sn5"));
        site.setSn6(resultSet.getString("sn6"));
        site.setSn7(resultSet.getString("sn7"));
        site.setSn8(resultSet.getString("sn8"));
        site.setSn9(resultSet.getString("sn9"));
        site.setSn10(resultSet.getString("sn10"));
        site.setSn11(resultSet.getString("sn11"));
        site.setSn12(resultSet.getString("sn12"));
        site.setSn13(resultSet.getString("sn13"));
        site.setSn14(resultSet.getString("sn14"));
        site.setSn15(resultSet.getString("sn15"));
        site.setBatt_id1(resultSet.getString("batt_id1"));
        site.setBatt_id2(resultSet.getString("batt_id2"));
        site.setBatt_id3(resultSet.getString("batt_id3"));
        site.setBatt_id4(resultSet.getString("batt_id4"));
        site.setBatt_id5(resultSet.getString("batt_id5"));
        site.setBatt_id6(resultSet.getString("batt_id6"));
        site.setBatt_id7(resultSet.getString("batt_id7"));
        site.setBatt_id8(resultSet.getString("batt_id8"));
        site.setBatt_id9(resultSet.getString("batt_id9"));
        site.setBatt_id10(resultSet.getString("batt_id10"));
        site.setBatt_id11(resultSet.getString("batt_id11"));
        site.setBatt_id12(resultSet.getString("batt_id12"));
        site.setBatt_id13(resultSet.getString("batt_id13"));
        site.setBatt_id14(resultSet.getString("batt_id14"));
        site.setBatt_id15(resultSet.getString("batt_id15"));
*/
        site.setSerial_number(resultSet.getString("serial_number"));
        //site.setBattery_id(resultSet.getString("battery_id"));

        return site;
    }
}
