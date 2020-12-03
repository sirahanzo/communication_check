package com.sinergiteknologiutama.availability.dao;

import com.sinergiteknologiutama.availability.mapper.SitesMapper;
import com.sinergiteknologiutama.availability.model.SitesModel;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("sitesDao")
public class SitesDao extends BaseDao {

    public List<SitesModel> sitesList()throws DataAccessException{
        String SQL = "SELECT * FROM sites left join device_nodes dn on sites.oid = dn.site_oid";
        //String SQL = "SELECT * FROM sites ";
        return jdbcTemplate.query(SQL,new Object[]{},new SitesMapper());
    }
}
