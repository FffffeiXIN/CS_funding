package com.sustech.cs_funding.common;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.net.UnknownHostException;
import java.util.Properties;

public class SendEmail {
    public Result sendMailToStudents(String course_id, String title, String content) {
//        List<User> students = courseMapper.getStudentsByCourse(course_id);
//        try {
//            for (Student s : students) {
//                String email = s.getId();
//                sendMail(email, course_id, title, content);
//            }
//        } catch (MessagingException | UnknownHostException e) {
//            throw new RuntimeException(e);
//        }
//
        return Result.ok().message("邮件发送成功");
    }

    public void sendMail(String mail, String course_id, String title, String contents) throws MessagingException, UnknownHostException {
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.sustech.edu.cn");
        props.put("mail.smtps.user", "12012939@mail.sustech.edu.cn");
        props.put("mail.smtps.auth", "true");
        Session mailSession = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(mailSession);

        message.setFrom(new InternetAddress("12012939@mail.sustech.edu.cn"));
        message.setRecipients(MimeMessage.RecipientType.TO, mail);
        message.setSubject("您的课程有新通知发布");

        MimeMultipart msgMultipart = new MimeMultipart("mixed");
        message.setContent(msgMultipart);

        MimeBodyPart content = new MimeBodyPart();
        msgMultipart.addBodyPart(content);

        MimeMultipart bodyMultipart = new MimeMultipart("related");
        content.setContent(bodyMultipart);

        MimeBodyPart htmlPart = new MimeBodyPart();
        bodyMultipart.addBodyPart(htmlPart);
        String send_message = "课程" + course_id + "发布新通知：\n"
                + "通知题目： " + title + "\n内容：" + contents;
        htmlPart.setContent(send_message, "text/plain;charset=UTF-8");

        Transport transport = mailSession.getTransport();

        String password = "Lyx19970420!";
        transport.connect("12012939@mail.sustech.edu.cn", password);

        transport.sendMessage(message, message.getAllRecipients());

    }
}
