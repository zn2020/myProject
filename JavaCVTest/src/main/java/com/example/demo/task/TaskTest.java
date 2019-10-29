package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TaskTest {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    int i = 0;

    //@Scheduled(fixedRate = 5000)
    @Scheduled(cron = "0/5 * * * * ?")
    public void upload(){
        try{
            i++;
            System.out.println("time:" + sdf.format(new Date()));
            if(i < 3){
                Thread.sleep(10000);
            }
            else{
                Thread.sleep(100);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
