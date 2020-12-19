package com.ticker.cryptoTicker.scheduledTasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TickerDataScheduledTask {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @Scheduled(cron = "0/5 * * ? * *")
    public void task() {
        System.out.println("Scheduler (cron expression) task with duration : " + sdf.format(new Date()));
    }
}
