package com.hisun.common.bean;

/**
 * 
 * @类名： PointAction.java
 * @描述：PointAction
 * @作者： PAUL
 * @修改日期： 2016年3月20日
 *
 */
public class PointAction
{
    private Long id;

    private String actionname;

    private Integer point;

    private String description;


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public String getActionname()
    {
        return actionname;
    }


    public void setActionname(String actionname)
    {
        this.actionname = actionname == null ? null : actionname.trim();
    }


    public Integer getPoint()
    {
        return point;
    }


    public void setPoint(Integer point)
    {
        this.point = point;
    }


    public String getDescription()
    {
        return description;
    }


    public void setDescription(String description)
    {
        this.description = description == null ? null : description.trim();
    }


    @Override
    public String toString()
    {
        return "PointAction [id=" + id + ", actionname=" + actionname + ", point=" + point + ", description=" + description + "]";
    }
}
