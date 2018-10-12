package com.niuchaoqun.example.advance;

import com.niuchaoqun.example.advance.quartz.Hellojob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzExample {
    public static void run(String[] args) throws SchedulerException {

        StdSchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        JobDetail job = newJob(Hellojob.class)
                .withIdentity("job", "group")
                .usingJobData("id", 1)
                .usingJobData("name", "zhangsan")
                .build();

        SimpleTrigger trigger = newTrigger().withIdentity("trigger", "group")
                .startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(1).repeatForever())
                .build();

        scheduler.scheduleJob(job, trigger);

        scheduler.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.shutdown(true);
    }
}
