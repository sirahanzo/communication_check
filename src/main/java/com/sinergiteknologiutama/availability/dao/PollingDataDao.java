package com.sinergiteknologiutama.availability.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("pollingDataDao")
public class PollingDataDao extends BaseDao{

    //public void update(String site_oid,int device_node_id,int parameter_id , Double pack1,Double pack2, Double pack3,Double pack4,Double pack5 , Double pack6,
    //                   Double pack7,Double pack8, Double pack9 ,Double pack10, Double pack11, Double pack12,Double pack13, Double pack14, Double pack15) throws DataAccessException{
    //    String SQL = "UPDATE `polling_data_devices` set `pack1` = 0,pack2=0,pack3=0,pack4=0, pack5=0, pack6=0, pack7=0 , pack8=0 , pack9=0,pack10=0,pack11=0, pack12=0, pack13=0, pack14=0,pack15=0  where `parameter_id` = ? and `site_oid` = ? and `device_node_id` = ?"
    //}

    public void updateDataCommlost(int parameter_id,String site_oid, int device_node_id)throws DataAccessException{
        String SQL="UPDATE `polling_data_devices` SET `pack1`=0, pack2=0, pack3=0 ,pack4=0, pack5=0, pack6=0, pack7=0 , pack8=0 , pack9=0,pack10=0,pack11=0, pack12=0, pack13=0, pack14=0,pack15=0 , updated_at = (SELECT DATE_FORMAT(NOW(),'%Y-%m-%d %H:%i:%s'))  WHERE `parameter_id` = ? AND `site_oid` = ? AND `device_node_id` = ?";
        jdbcTemplate.update(SQL,parameter_id,site_oid,device_node_id);
    }
}
