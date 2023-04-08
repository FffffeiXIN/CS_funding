package com.sustech.cs_funding.mapper;

import com.sustech.cs_funding.entity.Notification;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NotificationMapper {
    @Select("SELECT * FROM notification WHERE user_id = #{sid}")
    List<Notification> getNotificationByUser(Integer sid);

    @Insert("INSERT INTO notification (user_id, messages, date) VALUES (#{sid}, #{messages}, #{date})")
    void insertNotification(Integer sid, String messages, String date);
}
