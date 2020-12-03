package com.sinergiteknologiutama.availability.dao;

import com.sinergiteknologiutama.availability.mapper.RawAvailabilityMapper;
import com.sinergiteknologiutama.availability.model.RawAvailabilityModel;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository("rawAvailabilityDao")
public class RawAvailabilityDao extends BaseDao {

    public RawAvailabilityModel getLastUpdated(String site_oid, int pack_id) throws DataAccessException {
        String SQL = "SELECT * FROM raw_availability where site_oid= ? and pack_id = ? and updated_at is null limit 1";
        //System.out.format("SELECT * FROM raw_availability where site_oid= %s and pack_id = %i and updated_at is null limit 1",site_oid,pack_id);

        //System.out.println("SELECT * FROM raw_availability where site_oid= "+site_oid+" and pack_id = "+pack_id+" and updated_at is null limit 1");

        RawAvailabilityModel data = jdbcTemplate.queryForObject(SQL, new Object[]{site_oid, pack_id}, new RawAvailabilityMapper());

        return data;
    }

    public void updateRawAvailabilityStart(String site_oid, int pack_id, Double avg_bus_current, Double avg_bus_voltage, Double best_power, Double peak_power,
                                      Double soc_end, Double max_bus_current, Double max_bus_voltage, Double duration_hour) throws DataAccessException {

        String SQL = "UPDATE raw_availability SET `avg_bus_current` = ?, `avg_bus_voltage` = ?, `best_power` = ?, `peak_power` = ?, `soc_end` = ?, `max_bus_current` = ?, `max_bus_voltage` = ?, `duration_hour` = ? where `site_oid` = ? and `pack_id` = ? and `updated_at` is null";

        jdbcTemplate.update(SQL, avg_bus_current,avg_bus_voltage,best_power,peak_power,soc_end,max_bus_current,max_bus_voltage,duration_hour,site_oid,pack_id);
    }

    public void updateRawAvailabilityEnd(String site_oid, int pack_id, Double avg_bus_current, Double avg_bus_voltage, Double best_power, Double peak_power,
                                      Double soc_end, Double max_bus_current, Double max_bus_voltage, Double duration_hour) throws DataAccessException {

        String SQL = "UPDATE raw_availability SET `avg_bus_current` = ?, `avg_bus_voltage` = ?, `best_power` = ?, `peak_power` = ?, `soc_end` = ?, `max_bus_current` = ?, `max_bus_voltage` = ?, `duration_hour` = ? , `updated_at`= (SELECT DATE_FORMAT(NOW(), '%Y-%m-%d %H:%i:%s')) where `site_oid` = ? and `pack_id` = ? and `updated_at` is null";

        jdbcTemplate.update(SQL, avg_bus_current,avg_bus_voltage,best_power,peak_power,soc_end,max_bus_current,max_bus_voltage,duration_hour,site_oid,pack_id);
    }


    public void insert(String region_oid, String site_oid, int pack_id, String serial_number, String month_of_data, String year_of_data,
                       int system_state, Double avg_bus_current, Double avg_bus_voltage, Double best_power, Double peak_power, Double soc_start,
                       Double soc_end, Double max_bus_current, Double max_bus_voltage, Double duration_hour, Timestamp created_at) throws DataAccessException {

        String SQL = "INSERT INTO raw_availability (`region_oid`, `site_oid`, `pack_id`, `serial_number`, `month_of_data`, `year_of_data`, `system_state`, `avg_bus_current`, `avg_bus_voltage`, `best_power`, `peak_power`, `soc_start`, `soc_end`, `max_bus_current`, `max_bus_voltage`, `duration_hour`, `created_at`,`updated_at`)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,null)";

        jdbcTemplate.update(SQL, region_oid, site_oid, pack_id, serial_number, month_of_data, year_of_data, system_state, avg_bus_current, avg_bus_voltage,
                best_power, peak_power, soc_start, soc_end, max_bus_current, max_bus_voltage, duration_hour,created_at);
    }


}
