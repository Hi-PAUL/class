package com.hisun.common.bean;

import java.util.Date;

import com.hisun.common.util.HisunUtil;

/**
 * 
 * @类名： Class.java
 * 
 * @描述：Class @作者： PAUL @修改日期： 2016年3月20日
 *
 */
public class Class
{
    private Long id;

    private String college;

    private String major;

    private String classname;

    private String classadviser;

    private Integer number;

    private String slogan;

    private String introduce;

    private String honour;

    private String feature;

    private Date createdate;


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public String getCollege()
    {
        return college;
    }


    public void setCollege(String college)
    {
        this.college = college == null ? null : college.trim();
    }


    public String getMajor()
    {
        return major;
    }


    public void setMajor(String major)
    {
        this.major = major == null ? null : major.trim();
    }


    public String getClassname()
    {
        return classname;
    }


    public void setClassname(String classname)
    {
        this.classname = classname == null ? null : classname.trim();
    }


    public String getClassadviser()
    {
        return classadviser;
    }


    public void setClassadviser(String classadviser)
    {
        this.classadviser = classadviser == null ? null : classadviser.trim();
    }


    public Integer getNumber()
    {
        return number;
    }


    public void setNumber(Integer number)
    {
        this.number = number;
    }


    public String getSlogan()
    {
        return slogan;
    }


    public void setSlogan(String slogan)
    {
        this.slogan = slogan == null ? null : slogan.trim();
    }


    public String getIntroduce()
    {
        return introduce;
    }


    public void setIntroduce(String introduce)
    {
        this.introduce = introduce == null ? null : introduce.trim();
    }


    public String getHonour()
    {
        return honour;
    }


    public void setHonour(String honour)
    {
        this.honour = honour == null ? null : honour.trim();
    }


    public String getFeature()
    {
        return feature;
    }


    public void setFeature(String feature)
    {
        this.feature = feature == null ? null : feature.trim();
    }


    public String getCreatedate()
    {
        return HisunUtil.formatDate(createdate, "yyyy-MM-dd HH:mm:ss");
    }


    public void setCreatedate(Date createdate)
    {
        this.createdate = createdate;
    }


    @Override
    public String toString()
    {
        return "Class [id=" + id + ", college=" + college + ", major=" + major + ", classname=" + classname + ", classadviser=" + classadviser + ", number=" + number + ", slogan=" + slogan
                + ", introduce=" + introduce + ", honour=" + honour + ", feature=" + feature + ", createdate=" + createdate + "]";
    }
}
