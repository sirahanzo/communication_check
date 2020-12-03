package com.sinergiteknologiutama.availability.dao;

import com.sinergiteknologiutama.availability.mapper.ParametersMapper;
import com.sinergiteknologiutama.availability.model.ParameterModel;
import com.sinergiteknologiutama.availability.model.ParametersModel;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("parametersDao")
public class ParametersDao extends BaseDao {

    public List<ParametersModel> list(int device_id)throws DataAccessException{

        String SQL = "SELECT * FROM parameters WHERE device_id = ? AND `group` LIKE 'POLLING'";
        List<ParametersModel> params = jdbcTemplate.query(SQL,new Object[]{device_id},new ParametersMapper());
        return params;
    }

}
