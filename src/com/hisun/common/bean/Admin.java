package com.hisun.common.bean;

import java.util.Date;

/**
 * 
 * @类名： Admin.java
 * @描述：Admin
 * @作者： PAUL
 * @修改日期： 2016年3月20日
 *
 */
public class Admin
{
    private Long id;

    private String adminname;

    private String password;

    private String sex;

    private String phone;

    private String email;

    private Integer level;

    private Date registerdate;

    private Date laterdate;

    private Integer status;

    private String name;


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public String getAdminname()
    {
        return adminname;
    }


    public void setAdminname(String adminname)
    {
        this.adminname = adminname == null ? null : adminname.trim();
    }


    public String getPassword()
    {
        return password;
    }


    public void setPassword(String password)
    {
        this.password = password == null ? null : password.trim();
    }


    public String getSex()
    {
        return sex;
    }


    public void setSex(String sex)
    {
        this.sex = sex == null ? null : sex.trim();
    }


    public String getPhone()
    {
        return phone;
    }


    public void setPhone(String phone)
    {
        this.phone = phone == null ? null : phone.trim();
    }


    public String getEmail()
    {
        return email;
    }


    public void setEmail(String email)
    {
        this.email = email == null ? null : email.trim();
    }


    public Integer getLevel()
    {
        return level;
    }


    public void setLevel(Integer level)
    {
        this.level = level;
    }


    public Date getRegisterdate()
    {
        return registerdate;
    }


    public void setRegisterdate(Date registerdate)
    {
        this.registerdate = registerdate;
    }


    public Date getLaterdate()
    {
        return laterdate;
    }


    public void setLaterdate(Date laterdate)
    {
        this.laterdate = laterdate;
    }


    public Integer getStatus()
    {
        return status;
    }


    public void setStatus(Integer status)
    {
        this.status = status;
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name == null ? null : name.trim();
    }


    @Override
    public String toString()
    {
        return "Admin [id=" + id + ", adminname=" + adminname + ", password=" + password + ", sex=" + sex + ", phone=" + phone + ", email=" + email + ", level=" + level + ", registerdate="
                + registerdate + ", laterdate=" + laterdate + ", status=" + status + ", name=" + name + "]";
    }
}
