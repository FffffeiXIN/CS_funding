package com.sustech.cs_funding.controller;

import com.sustech.cs_funding.common.Result;
import com.sustech.cs_funding.service.notification.NotificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
@CrossOrigin
@Api(tags = "NotificationController")
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @GetMapping("/user")
    @ApiOperation(value = "Get all notifications by user_id")
    public Result getUserNotification(Integer id) {
        return notificationService.getUserNotification(id);
    }

    @GetMapping("/deleteAllNotificationOfUser")
    public Result deleteAllNotificationOfUser(Integer id) {
        return notificationService.deleteAllNotificationOfUser(id);
    }
}
