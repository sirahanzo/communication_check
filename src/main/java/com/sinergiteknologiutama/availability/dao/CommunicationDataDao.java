package com.sinergiteknologiutama.availability.dao;

import com.sinergiteknologiutama.availability.mapper.CommunicationDataMapper;
import com.sinergiteknologiutama.availability.model.CommunicationDataModel;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

@Repository("communicationDataDao")
public class CommunicationDataDao extends BaseDao {

    /*public CommunicationDataModel getNode(int device_node_id) throws DataAccessException {
        String SQL = "SELECT * FROM communication_data WHERE device_node_id = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{device_node_id}, new CommunicationDataMapper());
    }*/

    public CommunicationDataModel getNode(int device_node_id) {
        String SQL = "SELECT * FROM communication_data WHERE device_node_id = ?";
        try {

            return jdbcTemplate.queryForObject(SQL, new Object[]{device_node_id}, new CommunicationDataMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void updateMonitoringStatus(int device_node_id, int status) throws DataAccessException {
        //String SQL = "UPDATE communication_data set monitoring_status= ?,updated_at = (SELECT DATE_FORMAT(NOW(), '%Y-%m-%d %H:%i:%s')) WHERE device_node_id = ?";
        String SQL = "UPDATE communication_data set monitoring_status= ? WHERE device_node_id = ?";
        jdbcTemplate.update(SQL, status, device_node_id);
    }
}
