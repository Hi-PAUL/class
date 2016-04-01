package com.hisun.common.bean;

/**
 * 
 * @类名： TalkBean.java
 * 
 * @描述：TalkBean @作者： PAUL @修改日期： 2016年4月1日
 *
 */
public class TalkBean
{
    private String username;

    private Long sendTime;

    private String said;


    public String getUsername()
    {
        return username;
    }


    public void setUsername(String username)
    {
        this.username = username;
    }


    public Long getSendTime()
    {
        return sendTime;
    }


    public void setSendTime(Long sendTime)
    {
        this.sendTime = sendTime;
    }


    public String getSaid()
    {
        return said;
    }


    public void setSaid(String said)
    {
        this.said = said;
    }


    @Override
    public String toString()
    {
        return "TalkBean [username=" + username + ", sendTime=" + sendTime + ", said=" + said + "]";
    }

}
