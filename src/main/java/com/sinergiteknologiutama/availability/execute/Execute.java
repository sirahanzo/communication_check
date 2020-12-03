package com.sinergiteknologiutama.availability.execute;

import com.sinergiteknologiutama.availability.dao.*;
import com.sinergiteknologiutama.availability.model.ParametersModel;
import com.sinergiteknologiutama.availability.model.RawAvailabilityModel;
import com.sinergiteknologiutama.availability.model.SitesModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class Execute {

    final SitesDao sitesDao;
    final CommunicationDataDao communicationDao;
    final RawAvailabilityDao rawAvailabilityDao;
    final DailyPowerCalculationDao dailyPowerCalculationDao;
    final SerialNumberPackDao snPackDao;
    final ParametersDao parametersDao;
    final PollingDataDao pollingDataDao;


    Logger logger = LoggerFactory.getLogger(Execute.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Execute(SitesDao sitesDao, CommunicationDataDao communicationDao, RawAvailabilityDao rawAvailabilityDao, DailyPowerCalculationDao dailyPowerCalculationDao, SerialNumberPackDao snPackDao, ParametersDao parametersDao, PollingDataDao pollingDataDao) {
        this.sitesDao = sitesDao;
        this.communicationDao = communicationDao;
        this.rawAvailabilityDao = rawAvailabilityDao;
        this.dailyPowerCalculationDao = dailyPowerCalculationDao;
        this.snPackDao = snPackDao;
        this.parametersDao = parametersDao;
        this.pollingDataDao = pollingDataDao;
    }


    @Value("${deltatime.lastupdate.minute}")
    private Integer chekScheduler;


    @Async
    public void checkStatusTask() {
        String current_time = dateFormat.format(new Date(System.currentTimeMillis()));
        //System.out.println("Start Check Status JOB ID:"+ current_time);
        //logger.trace("trace");
        //logger.debug("debug");
        //logger.info("info");
        //logger.warn("warning");
        //logger.error("error");

        List<SitesModel> siteNodes = sitesDao.sitesList();
        for (SitesModel record : siteNodes) {
            try {
                int node_id = record.getNode().getId();
                String region_oid = record.getRegion_oid();
                String site_name = record.getName();
                String site_oid = record.getOid();
                String site_id_lable = record.getSite_id_label();

                //get last_updated from communication_data
                Timestamp last_comm = communicationDao.getNode(node_id).getUpdated_at();

                Timestamp time_now = Timestamp.valueOf(current_time);
                Integer total_pack = record.getTotal_pack();


                Duration duration = Duration.between(last_comm.toLocalDateTime(), time_now.toLocalDateTime());
                //System.out.println("LAST UPDATED AT :" + last_comm.toLocalDateTime());
                //System.out.println("TIME NOW :" + time_now.toLocalDateTime());

                Duration d = Duration.between(last_comm.toLocalDateTime(), time_now.toLocalDateTime());
                long secondsElapsed = d.getSeconds();
                long limit = TimeUnit.MINUTES.toSeconds(chekScheduler);

                Double duration_hour = (double) (d.getSeconds() / 3600);

                System.out.println("DURATION HOUR:" + duration_hour);

                logger.info("\nSITE NAME:{}\n" + "SITE OID:{}\n" + "SITE ID LABEL:{} \n" +
                                "DEVICE NODE ID:{}\n" + "TOTAL PACK :{}\n" + "LAST UPDATED:{}\n" + "CURRENT TIME:{}\n",
                        site_name, site_oid, site_id_lable, node_id, total_pack, last_comm, time_now);

                if (secondsElapsed > limit) {
                    //System.out.println("more than 5 minute == comlost");

                    /*
                     * 1.update comunication_data monitoring_status => 0 (commlost)
                     *
                     * foreach pack on site update column last_updated on table raw_availability
                     * insert on data on table daily_power_calculated (site_oid,pack_id,vbus,ibus,power) value (0,0,0,0)
                     * "count" $avg_vbus,$avg_ibus,$max_vbus,$max_ibus,$max_power on daily_power_calculate
                     * update raw_availability whith "count" value , then isert new value = 0
                     *
                     *
                     * */


                    //System.out.println("UPDATE polling_data SET data=0");
                    List<ParametersModel> parameter = parametersDao.list(1);
                    for (ParametersModel list : parameter) {
                        pollingDataDao.updateDataCommlost(list.getId(), site_oid, node_id);
                        //System.out.println("update polling SET VALUE = 0 WHERE parameter_id ="+list.getId()+" AND site_oid="+site_oid+" AND device_node_id="+node_id);
                    }

                    for (int i = 1; i <= total_pack; i++) {
                        //System.out.println("update raw_availability pack"+i);

                        //System.out.println("calculated function/function");
                        //Timestamp last_status = rawAvailabilityDao.getLastUpdated(site_oid,i).getUpdated_at();

                        //count avg_vbus
                        Double avg_Vbus = dailyPowerCalculationDao.avgVbus(site_oid, i, last_comm, time_now).getAggregate();
                        System.out.println("avg_VBUS PACK" + i + ":" + avg_Vbus);

                        Double avg_Ibus = dailyPowerCalculationDao.avgIbus(site_oid, i, last_comm, time_now).getAggregate();
                        System.out.println("avg_IBUS PACK" + i + ":" + avg_Ibus);

                        Double max_Vbus = dailyPowerCalculationDao.maxVbus(site_oid, i, last_comm, time_now).getAggregate();
                        System.out.println("max_VBUS PACK" + i + ":" + max_Vbus);

                        Double max_Ibus = dailyPowerCalculationDao.maxIbus(site_oid, i, last_comm, time_now).getAggregate();
                        System.out.println("max_IBUS PACK" + i + ":" + max_Ibus);
                        //
                        ////count max_power = max_vbus * max_bus
                        //
                        double max_Power = max_Vbus * max_Ibus;
                        System.out.println("max_POWER:" + max_Power);

                        String serial_number = snPackDao.get(site_oid, node_id, "sn" + i).getSerial_number();
                        System.out.println("SERIAL NUMBER PACK" + i + ":" + serial_number);

                        String battery_id = snPackDao.get(site_oid, node_id, "batt_id" + i).getSerial_number();
                        System.out.println("BATTERY ID PACK" + i + ":" + battery_id);

                        String month_of_data = time_now.toLocalDateTime().getMonth().name();
                        System.out.println("MONTH :" + month_of_data);

                        String year_of_data = String.valueOf(time_now.toLocalDateTime().getYear());
                        //System.out.println("YEAR :"+ year_of_data);

                        //if commlost
                        if (communicationDao.getNode(node_id) == null) {
                            //insert daily_power_calculate data= 0
                            //System.out.println("INSERT INTO daily_power_calculate data = 0 WHERE PACK" + i);
                            dailyPowerCalculationDao.insertNewData(site_oid, i, 0.0, 0.0, 0.0, time_now, time_now);


                            //update raw_availability  updated_at = current_time/time_now detal_hour nya bertambah
                            //System.out.println("UPDATE raw_availability SET data = 0 , where updated = null WHERE PACK" + i);
                            rawAvailabilityDao.updateRawAvailabilityStart(site_oid, i, avg_Ibus, avg_Vbus, 0.0, 0.0, 0.0, max_Ibus, max_Vbus, duration_hour);

                            //status_site = "COMM.LOST";
                            System.out.println("SITE STATUS: " + "COMM.LOST");



                        } else if (communicationDao.getNode(node_id).getMonitoring_status() == 2){
                            //insert daily_power_calculate data= 0
                            //System.out.println("INSERT INTO daily_power_calculate data = 0 WHERE PACK" + i);
                            dailyPowerCalculationDao.insertNewData(site_oid, i, 0.0, 0.0, 0.0, time_now, time_now);


                            //update raw_availability  updated_at = current_time/time_now
                            //System.out.println("UPDATE raw_availability SET data = 0 , where updated = null WHERE PACK" + i);
                            rawAvailabilityDao.updateRawAvailabilityEnd(site_oid, i, avg_Ibus, avg_Vbus, 0.0, 0.0, 0.0, max_Ibus, max_Vbus, duration_hour);


                            //insert raw_availability with data = 0 , updated_at = null
                            //System.out.println("INSERT INTO raw_availability data = 0 , updated_at = null WHERE PACK" + i);
                            rawAvailabilityDao.insert(region_oid, site_oid, i, serial_number, month_of_data, year_of_data, 4, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, time_now);

                            //status_site = "OUTAGE";
                            System.out.println("SITE STATUS: " + "OUTAGE");


                        }else {
                            //System.out.println("INSERT INTO daily_power_calculate data = 0 WHERE PACK" + i);
                            dailyPowerCalculationDao.insertNewData(site_oid, i, 0.0, 0.0, 0.0, time_now, time_now);


                            //update raw_availability  updated_at = current_time/time_now
                            //System.out.println("UPDATE raw_availability SET data = 0 , where updated = null WHERE PACK" + i);
                            rawAvailabilityDao.updateRawAvailabilityEnd(site_oid, i, avg_Ibus, avg_Vbus, 0.0, 0.0, 0.0, max_Ibus, max_Vbus, duration_hour);


                            //insert raw_availability with data = 0 , updated_at = null
                            //System.out.println("INSERT INTO raw_availability data = 0 , updated_at = null WHERE PACK" + i);
                            rawAvailabilityDao.insert(region_oid, site_oid, i, serial_number, month_of_data, year_of_data, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, time_now);

                            //status_site = "COMM.LOST/UNDEFINED";
                            System.out.println("SITE STATUS: " + "COMM.LOST/UNDEFINED");


                        }


                        //1.update communication_data
                        //System.out.println("UPDATED communication_data");
                        communicationDao.updateMonitoringStatus(node_id, 0);


                    }

                } else {
                    System.out.println("SITE STATUS: " + "CONNECTED & UPDATED");
                    //no action

                }



                System.out.println("------------------------");


            } catch (Exception e) {
                System.out.println("Exception:" + e);
            }
        }


    }

}
