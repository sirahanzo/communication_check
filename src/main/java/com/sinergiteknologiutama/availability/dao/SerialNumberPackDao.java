package com.sinergiteknologiutama.availability.dao;

import com.sinergiteknologiutama.availability.mapper.SerialNumberPackMapper;
import com.sinergiteknologiutama.availability.model.SerialNumberPackModel;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("serialNumberPackDao")
public class SerialNumberPackDao extends BaseDao {

    public SerialNumberPackModel get(String site_oid,int device_node_id,String column)throws DataAccessException{
        String SQL = "SELECT ? as serial_number FROM serial_number_pack WHERE site_oid = ? AND device_node_id = ?";
        SerialNumberPackModel site = jdbcTemplate.queryForObject(SQL,new Object[]{column,site_oid,device_node_id},new SerialNumberPackMapper());
        return site;
    }
}
