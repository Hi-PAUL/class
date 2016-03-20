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
public class Album
{
    private Long id;

    private String albumname;

    private String albumdesc;

    private String imagefm;

    private Long classid;

    private Date createdate;


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public String getAlbumname()
    {
        return albumname;
    }


    public void setAlbumname(String albumname)
    {
        this.albumname = albumname == null ? null : albumname.trim();
    }


    public String getAlbumdesc()
    {
        return albumdesc;
    }


    public void setAlbumdesc(String albumdesc)
    {
        this.albumdesc = albumdesc == null ? null : albumdesc.trim();
    }


    public String getImagefm()
    {
        return imagefm;
    }


    public void setImagefm(String imagefm)
    {
        this.imagefm = imagefm == null ? null : imagefm.trim();
    }


    public Long getClassid()
    {
        return classid;
    }


    public void setClassid(Long classid)
    {
        this.classid = classid;
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
        return "Album [id=" + id + ", albumname=" + albumname + ", albumdesc=" + albumdesc + ", imagefm=" + imagefm + ", classid=" + classid + ", createdate=" + createdate + "]";
    }
}
