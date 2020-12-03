package com.sinergiteknologiutama.availability.dao;

import com.sinergiteknologiutama.availability.mapper.DailyPowerCalculationMapper;
import com.sinergiteknologiutama.availability.model.DailyPowerCalculationModel;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository("dailyPowerCalculationDao")
public class DailyPowerCalculationDao extends BaseDao {

    public void insertNewData(String site_oid, int pack_id, Double vbus, Double ibus, Double power, Timestamp created_at,Timestamp updated_at)throws DataAccessException{
        String SQL = "INSERT INTO daily_power_calculate (site_oid, pack_id, vbus, ibus, power, created_at, updated_at) values (?, ?, ?, ?, ?, ?,?)";
        jdbcTemplate.update(SQL,site_oid,pack_id,vbus,ibus,power,created_at,updated_at);
    }

    public DailyPowerCalculationModel avgVbus(String site_oid, int pack_id, Timestamp from , Timestamp to) throws  DataAccessException{
        String SQL = "SELECT id,site_oid,pack_id,vbus,ibus,power, created_at,updated_at, avg(`vbus`) AS aggregate FROM daily_power_calculate WHERE site_oid = ? AND pack_id = ? AND updated_at >= ? AND updated_at <= ?";
        //String SQL = "SELECT id,site_oid,pack_id,vbus,ibus,power, created_at,updated_at, avg(`vbus`) AS aggregate FROM daily_power_calculate WHERE site_oid = ? AND pack_id = ?";
        //System.out.println("SELECT id,site_oid,pack_id,vbus,ibus,power, created_at,updated_at, avg(`vbus`) AS aggregate FROM daily_power_calculate WHERE site_oid = "+site_oid+" AND pack_id = "+pack_id+"AND updated_at >= "+from+" AND updated_at <= "+to);
        DailyPowerCalculationModel aggregate =  jdbcTemplate.queryForObject(SQL,new Object[]{site_oid,pack_id,from,to},new DailyPowerCalculationMapper());
        //DailyPowerCalculationModel aggregate =  jdbcTemplate.queryForObject(SQL,new Object[]{site_oid,pack_id},new DailyPowerCalculationMapper());
        return  aggregate;
    }

    public DailyPowerCalculationModel avgIbus(String site_oid, int pack_id, Timestamp from , Timestamp to) throws  DataAccessException{
        String SQL = "SELECT id,site_oid,pack_id,vbus,ibus,power, created_at,updated_at, avg(`ibus`) AS aggregate FROM daily_power_calculate WHERE site_oid = ? AND pack_id = ? AND updated_at >= ? AND updated_at <= ?";
        return jdbcTemplate.queryForObject(SQL,new Object[]{site_oid,pack_id,from,to},new DailyPowerCalculationMapper());

        //String SQL = "SELECT id,site_oid,pack_id,vbus,ibus,power, created_at,updated_at, avg(`ibus`) AS aggregate FROM daily_power_calculate WHERE site_oid = ? AND pack_id = ?";
        //return jdbcTemplate.queryForObject(SQL,new Object[]{site_oid,pack_id},new DailyPowerCalculationMapper());
    }

    public DailyPowerCalculationModel maxVbus(String site_oid, int pack_id, Timestamp from , Timestamp to) throws  DataAccessException{
        String SQL = "SELECT id,site_oid,pack_id,vbus,ibus,power, created_at,updated_at, MAX(`vbus`) AS aggregate FROM daily_power_calculate WHERE `site_oid` = ? AND `pack_id` = ? AND `updated_at` >= ? AND `updated_at` <= ?";
        return jdbcTemplate.queryForObject(SQL,new Object[]{site_oid,pack_id,from,to},new DailyPowerCalculationMapper());

        //String SQL = "SELECT id,site_oid,pack_id,vbus,ibus,power, created_at,updated_at, MAX(`vbus`) AS aggregate FROM daily_power_calculate WHERE site_oid = ? AND pack_id = ?";
        //return jdbcTemplate.queryForObject(SQL,new Object[]{site_oid,pack_id},new DailyPowerCalculationMapper());
    }

    public DailyPowerCalculationModel maxIbus(String site_oid, int pack_id, Timestamp from , Timestamp to) throws  DataAccessException{
        String SQL = "SELECT id,site_oid,pack_id,vbus,ibus,power, created_at,updated_at, MAX(`vbus`) AS aggregate FROM daily_power_calculate WHERE `site_oid` = ? AND `pack_id` = ? AND `updated_at` >= ? AND `updated_at` <= ?";
        return jdbcTemplate.queryForObject(SQL,new Object[]{site_oid,pack_id,from,to},new DailyPowerCalculationMapper());

        //String SQL = "SELECT id,site_oid,pack_id,vbus,ibus,power, created_at,updated_at, MAX(`ibus`) AS aggregate FROM daily_power_calculate WHERE site_oid = ? AND pack_id = ?";
        //return jdbcTemplate.queryForObject(SQL,new Object[]{site_oid,pack_id},new DailyPowerCalculationMapper());
    }




}
