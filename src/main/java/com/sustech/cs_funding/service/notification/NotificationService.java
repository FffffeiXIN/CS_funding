package com.sustech.cs_funding.service.notification;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.entity.Notification;
import com.sustech.cs_funding.mapper.NotificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    NotificationMapper notificationMapper;

    public Result getUserNotification(Integer id){
        List<Notification> notification = notificationMapper.getNotificationByUser(id);
        return  Result.ok().code(200).message("Success").addData("notifications", notification);
    }

    public Result deleteAllNotificationOfUser(Integer id) {
        notificationMapper.deleteAllNotificationOfUser(id);
        return Result.ok().code(200).message("Success");
    }
}
