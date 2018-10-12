package com.niuchaoqun.example.advance.quartz;

import org.quartz.*;

public class Hellojob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail detail = context.getJobDetail();
        JobKey key = detail.getKey();

        int id = detail.getJobDataMap().getInt("id");
        String name = detail.getJobDataMap().getString("name");

        System.out.println("Job " + key + ", id:" + id + ", name:" + name);
    }
}
