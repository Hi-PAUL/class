package com.hisun.common.bean;

/**
 * 
 * @类名： Album.java
 * @描述：Album
 * @作者： PAUL
 * @修改日期： 2016年3月20日
 *
 */
public class Result
{
    private Long id;

    private String studentid;

    private String banbie;

    private String name;

    private String session;

    private String coursename;

    private String coursecode;

    private Integer period;

    private Integer credit;

    private Double scores;

    private String remark;


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public String getStudentid()
    {
        return studentid;
    }


    public void setStudentid(String studentid)
    {
        this.studentid = studentid == null ? null : studentid.trim();
    }


    public String getBanbie()
    {
        return banbie;
    }


    public void setBanbie(String banbie)
    {
        this.banbie = banbie == null ? null : banbie.trim();
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name == null ? null : name.trim();
    }


    public String getSession()
    {
        return session;
    }


    public void setSession(String session)
    {
        this.session = session == null ? null : session.trim();
    }


    public String getCoursename()
    {
        return coursename;
    }


    public void setCoursename(String coursename)
    {
        this.coursename = coursename == null ? null : coursename.trim();
    }


    public String getCoursecode()
    {
        return coursecode;
    }


    public void setCoursecode(String coursecode)
    {
        this.coursecode = coursecode == null ? null : coursecode.trim();
    }


    public Integer getPeriod()
    {
        return period;
    }


    public void setPeriod(Integer period)
    {
        this.period = period;
    }


    public Integer getCredit()
    {
        return credit;
    }


    public void setCredit(Integer credit)
    {
        this.credit = credit;
    }


    public Double getScores()
    {
        return scores;
    }


    public void setScores(Double scores)
    {
        this.scores = scores;
    }


    public String getRemark()
    {
        return remark;
    }


    public void setRemark(String remark)
    {
        this.remark = remark == null ? null : remark.trim();
    }


    @Override
    public String toString()
    {
        return "Result [id=" + id + ", studentid=" + studentid + ", banbie=" + banbie + ", name=" + name + ", session=" + session + ", coursename=" + coursename + ", coursecode=" + coursecode
                + ", period=" + period + ", credit=" + credit + ", scores=" + scores + ", remark=" + remark + "]";
    }
}
