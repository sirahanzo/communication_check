package com.sinergiteknologiutama.availability.mapper;

import com.sinergiteknologiutama.availability.model.NodeModel;
import com.sinergiteknologiutama.availability.model.PollingDataModel;
import com.sinergiteknologiutama.availability.model.SitesModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SitesMapper implements RowMapper<SitesModel> {

    List<SitesModel> siteNodes = new ArrayList<SitesModel>();

    @Override
    public SitesModel mapRow(ResultSet resultSet, int i) throws SQLException {

        SitesModel sites = new SitesModel();
        NodeModel nodes = new NodeModel();
        //PollingDataModel pollingData = new PollingDataModel();

        //sites.setId();
        sites.setOwner_id(resultSet.getInt("owner_id"));
        sites.setRegion_oid(resultSet.getString("region_oid"));
        sites.setCity_oid(resultSet.getNString("city_oid"));
        sites.setOid(resultSet.getString("oid"));
        sites.setName(resultSet.getString("name"));
        sites.setSite_id_label(resultSet.getString("site_id_label"));
        sites.setAddress(resultSet.getString("address"));
        sites.setLongitude(resultSet.getString("longitude"));
        sites.setLatitude(resultSet.getString("latitude"));
        sites.setTotal_pack(resultSet.getInt("total_pack"));

        nodes.setId(resultSet.getInt("dn.id"));
        nodes.setDevice_id(resultSet.getInt("device_id"));
        //nodes.setNode_name(resultSet.getString("name as node_name"));
        nodes.setSerial_number(resultSet.getString("serial_number"));

        //pollingData.setDevice_node_id(resultSet.getInt("device_node_id"));
        //pollingData

        sites.setNode(nodes);
        siteNodes.add(sites);

        return sites;
    }
}
