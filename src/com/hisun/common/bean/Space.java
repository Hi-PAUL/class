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
public class Space
{
    private Long id;

    private String school;

    private String college;

    private String major;

    private String banbie;

    private Date admissiondate;

    private Date birthday;

    private String address;

    private String hobbies;

    private String inttroduction;

    private Long userid;

    private Date createdate;


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public String getSchool()
    {
        return school;
    }


    public void setSchool(String school)
    {
        this.school = school == null ? null : school.trim();
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


    public String getBanbie()
    {
        return banbie;
    }


    public void setBanbie(String banbie)
    {
        this.banbie = banbie == null ? null : banbie.trim();
    }


    public Date getAdmissiondate()
    {
        return admissiondate;
    }


    public void setAdmissiondate(Date admissiondate)
    {
        this.admissiondate = admissiondate;
    }


    public Date getBirthday()
    {
        return birthday;
    }


    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }


    public String getAddress()
    {
        return address;
    }


    public void setAddress(String address)
    {
        this.address = address == null ? null : address.trim();
    }


    public String getHobbies()
    {
        return hobbies;
    }


    public void setHobbies(String hobbies)
    {
        this.hobbies = hobbies == null ? null : hobbies.trim();
    }


    public String getInttroduction()
    {
        return inttroduction;
    }


    public void setInttroduction(String inttroduction)
    {
        this.inttroduction = inttroduction == null ? null : inttroduction.trim();
    }


    public Long getUserid()
    {
        return userid;
    }


    public void setUserid(Long userid)
    {
        this.userid = userid;
    }


    public Date getCreatedate()
    {
        return createdate;
    }


    public void setCreatedate(Date createdate)
    {
        this.createdate = createdate;
    }


    @Override
    public String toString()
    {
        return "Space [id=" + id + ", school=" + school + ", college=" + college + ", major=" + major + ", banbie=" + banbie + ", admissiondate=" + admissiondate + ", birthday=" + birthday
                + ", address=" + address + ", hobbies=" + hobbies + ", inttroduction=" + inttroduction + ", userid=" + userid + ", createdate=" + createdate + "]";
    }
}
