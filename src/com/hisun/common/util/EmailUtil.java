package com.hisun.common.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @类名： EmailUtil.java
 * 
 * @描述：EmailUtil @作者： PAUL @修改日期： 2016年3月28日
 *
 */
public class EmailUtil
{

    public static void sendEmail(String username, String email, String cdKey, String LocalIP) throws Exception
    {
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.transport.protocol", "smtp");

        Session session = Session.getInstance(props);
        session.setDebug(true);

        Message msg = new MimeMessage(session);
        msg.setSubject("班级网注册账号激活");
        msg.setText("http://paul:8088/class/activate.xhtml?name=" + username + "&cdKey=" + cdKey);
        // msg.setText("http://"+LocalIP+":8088/class/activate.xhtml?name="+username+"&cdKey="+cdKey);
        msg.setFrom(new InternetAddress("liangliying132@163.com"));

        Transport transport = session.getTransport();
        transport.connect("smtp.163.com", 25, "liangliying132", "tzewgnsoypfdxfwl");

        transport.sendMessage(msg, new Address[] { new InternetAddress(email) });
        System.out.println("邮件发送成功...");
        transport.close();

    }
}
