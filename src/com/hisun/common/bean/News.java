package com.hisun.common.bean;

import java.util.Date;

import com.hisun.common.util.HisunUtil;

/**
 * 
 * @类名： News.java
 * 
 * @描述：News @作者： PAUL @修改日期： 2016年5月10日
 *
 */
public class News
{
    private Long id;

    private String publisher;

    private String title;

    private String content;

    private Date dateline;

    private String node;


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


    public String getContent()
    {
        return content;
    }


    public void setContent(String content)
    {
        this.content = content == null ? null : content.trim();
    }


    public String getDateline()
    {
        return HisunUtil.formatDate(dateline, "yyyy-MM-dd");
    }


    public void setDateline(Date dateline)
    {
        this.dateline = dateline;
    }


    public String getNode()
    {
        return node;
    }


    public void setNode(String node)
    {
        this.node = node == null ? null : node.trim();
    }


    @Override
    public String toString()
    {
        return "News [id=" + id + ", publisher=" + publisher + ", title=" + title + ", content=" + content + ", dateline=" + dateline + ", node=" + node + "]";
    }
}
