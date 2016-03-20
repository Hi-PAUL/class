package com.hisun.common.bean;

import java.util.Date;

/**
 * 
 * @类名： Album.java
 * @描述：Album
 * @作者： PAUL
 * @修改日期： 2016年3月20日
 *
 */
public class Message
{
    private Long id;

    private String username;

    private String title;

    private String sex;

    private String url;

    private String qq;

    private String content;

    private String reply;

    private String faceurl;

    private Long classid;

    private Date dateline;


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public String getUsername()
    {
        return username;
    }


    public void setUsername(String username)
    {
        this.username = username == null ? null : username.trim();
    }


    public String getTitle()
    {
        return title;
    }


    public void setTitle(String title)
    {
        this.title = title == null ? null : title.trim();
    }


    public String getSex()
    {
        return sex;
    }


    public void setSex(String sex)
    {
        this.sex = sex == null ? null : sex.trim();
    }


    public String getUrl()
    {
        return url;
    }


    public void setUrl(String url)
    {
        this.url = url == null ? null : url.trim();
    }


    public String getQq()
    {
        return qq;
    }


    public void setQq(String qq)
    {
        this.qq = qq == null ? null : qq.trim();
    }


    public String getContent()
    {
        return content;
    }


    public void setContent(String content)
    {
        this.content = content == null ? null : content.trim();
    }


    public String getReply()
    {
        return reply;
    }


    public void setReply(String reply)
    {
        this.reply = reply == null ? null : reply.trim();
    }


    public String getFaceurl()
    {
        return faceurl;
    }


    public void setFaceurl(String faceurl)
    {
        this.faceurl = faceurl == null ? null : faceurl.trim();
    }


    public Long getClassid()
    {
        return classid;
    }


    public void setClassid(Long classid)
    {
        this.classid = classid;
    }


    public Date getDateline()
    {
        return dateline;
    }


    public void setDateline(Date dateline)
    {
        this.dateline = dateline;
    }


    @Override
    public String toString()
    {
        return "Message [id=" + id + ", username=" + username + ", title=" + title + ", sex=" + sex + ", url=" + url + ", qq=" + qq + ", content=" + content + ", reply=" + reply + ", faceurl="
                + faceurl + ", classid=" + classid + ", dateline=" + dateline + "]";
    }
}
