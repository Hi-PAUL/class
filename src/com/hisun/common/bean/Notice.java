package com.hisun.common.bean;

import java.util.Date;

import com.hisun.common.util.HisunUtil;

/**
 * 
 * @类名： Notice.java
 * 
 * @描述：Notice @作者： PAUL @修改日期： 2016年3月20日
 *
 */
public class Notice
{
    private Long id;

    private String publisher;

    private String title;

    private String sex;

    private String content;

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


    public String getPublisher()
    {
        return publisher;
    }


    public void setPublisher(String publisher)
    {
        this.publisher = publisher == null ? null : publisher.trim();
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


    public String getContent()
    {
        return content;
    }


    public void setContent(String content)
    {
        this.content = content == null ? null : content.trim();
    }


    public Long getClassid()
    {
        return classid;
    }


    public void setClassid(Long classid)
    {
        this.classid = classid;
    }


    public String getDateline()
    {
        return HisunUtil.formatDate(dateline, "yyyy-MM-dd HH:mm:ss");
    }


    public void setDateline(Date dateline)
    {
        this.dateline = dateline;
    }


    @Override
    public String toString()
    {
        return "Notice [id=" + id + ", publisher=" + publisher + ", title=" + title + ", sex=" + sex + ", content=" + content + ", classid=" + classid + ", dateline=" + dateline + "]";
    }
}
