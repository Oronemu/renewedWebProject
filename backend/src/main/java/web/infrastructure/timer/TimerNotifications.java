package web.infrastructure.timer;

import java.util.Date;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.ejb.Timeout;
import jakarta.ejb.TimerConfig;
import jakarta.ejb.TimerService;
import jakarta.inject.Inject;
import web.application.notification.INotification;
import web.infrastructure.builder.Built;

@Singleton
@Startup
public class TimerNotifications {

    @Inject @Built
    private INotification notification;
    
    @Resource
    TimerService tservice;

    @PostConstruct    
    public void start() {
        tservice.createIntervalTimer(new Date(), 60000, new TimerConfig()); 
    }
  
    @Timeout
    public void timeout() {
        notification.send("ВНИМАНИЕ: В понедельник в 20:00 будут проводиться технические работы.");
        /*технические работы */
    }
}
