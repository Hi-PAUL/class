package com.hisun.common.bean;

import java.util.Date;

/**
 * 
 * @类名： User.java
 * @描述：User
 * @作者： PAUL
 * @修改日期： 2016年3月20日
 *
 */
public class User
{
    private Long id;

    private String username;

    private String password;

    private String sex;

    private String qq;

    private String phone;

    private String email;

    private Date registerdate;

    private Date laterdate;

    private Integer status;

    private Integer isonline;

    private Long point;

    private Integer isagree;

    private String name;

    private String studentid;

    private Long classid;

    private String cdkey;


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


    public String getQq()
    {
        return qq;
    }


    public void setQq(String qq)
    {
        this.qq = qq == null ? null : qq.trim();
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


    public Integer getIsonline()
    {
        return isonline;
    }


    public void setIsonline(Integer isonline)
    {
        this.isonline = isonline;
    }


    public Long getPoint()
    {
        return point;
    }


    public void setPoint(Long point)
    {
        this.point = point;
    }


    public Integer getIsagree()
    {
        return isagree;
    }


    public void setIsagree(Integer isagree)
    {
        this.isagree = isagree;
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name == null ? null : name.trim();
    }


    public String getStudentid()
    {
        return studentid;
    }


    public void setStudentid(String studentid)
    {
        this.studentid = studentid == null ? null : studentid.trim();
    }


    public Long getClassid()
    {
        return classid;
    }


    public void setClassid(Long classid)
    {
        this.classid = classid;
    }


    public String getCdkey()
    {
        return cdkey;
    }


    public void setCdkey(String cdkey)
    {
        this.cdkey = cdkey == null ? null : cdkey.trim();
    }


    @Override
    public String toString()
    {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", qq=" + qq + ", phone=" + phone + ", email=" + email + ", registerdate=" + registerdate
                + ", laterdate=" + laterdate + ", status=" + status + ", isonline=" + isonline + ", point=" + point + ", isagree=" + isagree + ", name=" + name + ", studentid=" + studentid
                + ", classid=" + classid + ", cdkey=" + cdkey + "]";
    }
}
