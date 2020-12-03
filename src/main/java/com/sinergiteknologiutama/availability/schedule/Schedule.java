package com.sinergiteknologiutama.availability.schedule;

import com.sinergiteknologiutama.availability.execute.Execute;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {

    final Execute execute;

    public Schedule(Execute execute) {
        this.execute = execute;
    }

    //@Scheduled(cron = "0/60 * * * * *")
    @Scheduled(cron = "0 0/${cron.scheduler.minute} * * * *")
    public void scheduledTask(){
        System.out.println("executed task");

        execute.checkStatusTask();

    }
}
