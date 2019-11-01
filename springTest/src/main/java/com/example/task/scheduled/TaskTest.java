package com.example.task.scheduledTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 定时任务测试
 */
@Component
public class TaskTest {

    private static Logger log = LoggerFactory.getLogger(TaskTest.class);

    int i = 0;

    //@Scheduled(fixedRate = 5000)
    //@Scheduled(cron = "0/5 * * * * ?")
    public void upload(){
        try{
            i++;
            log.info(Thread.currentThread().getName() + "-upload:" + LocalDateTime.now());
            if(i < 3){
                Thread.sleep(1000);
            }
            else{
                Thread.sleep(1000000);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void download(){
        try{
            i++;
            log.info(Thread.currentThread().getName() + "-download:" + LocalDateTime.now());
            Thread.sleep(1000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
