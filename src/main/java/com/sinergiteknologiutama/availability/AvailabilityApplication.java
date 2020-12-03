package com.sinergiteknologiutama.availability;

import com.sinergiteknologiutama.availability.execute.Execute;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class AvailabilityApplication {

    final Execute execute;

    public AvailabilityApplication(Execute execute) {
        this.execute = execute;
    }

    public static void main(String[] args) {
        SpringApplication.run(AvailabilityApplication.class, args);
    }


    @Value("${pool.core-size}")
    private int corePoolSize;

    @Value("${pool.max-size}")
    private int maxPoolSize;

    @Value("${pool.queue-capacity}")
    private int queueCapacity;


    @Bean
    public TaskScheduler taskScheduler() {
        return new ThreadPoolTaskScheduler();

    }

    @Bean
    public TaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
        threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
        threadPoolTaskExecutor.setQueueCapacity(queueCapacity);

        return threadPoolTaskExecutor;

    }



    @PostConstruct
    public void runTask(){
        System.out.println("RUN TASK FOR THE FIRST TIME");
        execute.checkStatusTask();
    }

}
