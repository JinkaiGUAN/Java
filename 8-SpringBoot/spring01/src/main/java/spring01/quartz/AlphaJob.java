package spring01.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Copyright (C), Peter GUAN
 * FileName: AlphaJob
 * Author:   Peter
 * Date:     04/04/2022 15:56
 * Description:
 * History:
 * Version:
 * @author Peter
 */
public class AlphaJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(Thread.currentThread().getName() + ": execute a quartz job.");
    }
}
